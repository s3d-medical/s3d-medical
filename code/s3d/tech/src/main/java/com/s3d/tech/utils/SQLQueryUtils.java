package com.s3d.tech.utils;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.NullableType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.*;

/**
 * This class is used to handle the function of adding scalars to SQLQuery.
 *
 * @author  Wind.Chen
 * @date 2015/1/16.
 */
public class SQLQueryUtils {

    private static Logger logger = LoggerFactory.getLogger(SQLQueryUtils.class);
    /**
     * Register the java data type and its corresponded Hibernate type defined in class Hibernate(such as Hibernate.STRING)
     */
    private static Map<String, NullableType> JAVA_HIBERNATE_TYPE_MAP = new HashMap <String, NullableType>();
    /**
     * Registered class information in the map. by get the registered information by class name.
     *
     */
    private static Map<String, Map<String, String>> REGISTERED_CLASSES_CACHE = new HashMap<String, Map<String, String>>();

    private static final String PREFIX_SET = "set";

    static {
        mapJavaHibernateType();
    }

    private static void mapJavaHibernateType(){
/*        JAVA_HIBERNATE_TYPE_MAP.put("int", Hibernate.INTEGER);
        JAVA_HIBERNATE_TYPE_MAP.put("Integer", Hibernate.INTEGER);
        JAVA_HIBERNATE_TYPE_MAP.put("String", Hibernate.STRING);
        JAVA_HIBERNATE_TYPE_MAP.put("Date", Hibernate.DATE);
        JAVA_HIBERNATE_TYPE_MAP.put("double", Hibernate.DOUBLE);
        JAVA_HIBERNATE_TYPE_MAP.put("Double", Hibernate.DOUBLE);
        JAVA_HIBERNATE_TYPE_MAP.put("float", Hibernate.FLOAT);
        JAVA_HIBERNATE_TYPE_MAP.put("Float", Hibernate.FLOAT);*/
    }


    /**
     * Fill parameters. Value in map can be Collection or Object[].
     * @param sqlQuery
     * @param params
     */
    public static void fillParameters(SQLQuery sqlQuery, Map params){
        if(params != null && params.size() > 0){
            sqlQuery.setProperties(params);
        }
    }

    /**
     * Fill parameters, every parameter can not be Collection or Object[]  type.
     * @param sqlQuery
     * @param values
     */
    public static void fillParameters(SQLQuery sqlQuery, Object... values){
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    if(values[i] instanceof Collection || values[i] instanceof Object[]){
                        throw new RuntimeException("Collection type parameter is not supported.");
                    }else{
                        sqlQuery.setParameter(i, values[i]);
                    }
                }
            }
    }

    public static SQLQuery createSQLQuery(Session session, String sql){
        return session.createSQLQuery(sql);
    }

    /**
     * Add sqlQuery object scalar information.  mapped class refer to the mapped class. selectColNames used in sql sentence contains the cols list separated by ",".
     *
     * @param sqlQuery
     * @param mappedToBeanClass
     * @param usedColNames  cols must be split by ",". or it will be regard as only one col.
     */
    public static void mapBeanClassToCols(SQLQuery sqlQuery, Class mappedToBeanClass, String usedColNames){
        Assert.isTrue(StringUtils.isNotBlank(usedColNames), "Mapped column names can not be empty");
        List<String> colNames = Arrays.asList(usedColNames.split(","));
        mapBeanClassToCols(sqlQuery, mappedToBeanClass, colNames);
    }

    public static void mapBeanClassToCols(SQLQuery sqlQuery, Class mappedToBeanClass, List<String> usedColNames){
        Assert.notNull(sqlQuery, "Target SQLQuery object can not be null.");
        Assert.notNull(mappedToBeanClass, "Mapped class can not be null");
        Assert.notEmpty(usedColNames, "Mapped column names can not be empty");

        Map<String, String> setterMethodsParamsMap = extractSetterMethodsOfClass(mappedToBeanClass);

        for(String colName : usedColNames){
            colName = colName.trim();
            Assert.isTrue(StringUtils.isNotBlank(colName), "Column name should not be null and empty.");
            NullableType nullableType = getColumnHibernateType(setterMethodsParamsMap, colName);
            sqlQuery.addScalar(colName, nullableType);
        }
        sqlQuery.setResultTransformer(Transformers.aliasToBean(mappedToBeanClass));
    }

    protected static NullableType getColumnHibernateType(Map<String, String> setterMethodsParamsMap, String selectedColName){
        // get corresponding setter method.
        String paramTypeName = getSimpleSetterMethodParamType(setterMethodsParamsMap, selectedColName);
        Assert.isTrue(StringUtils.isNotBlank(paramTypeName), "Column '" + selectedColName + "' has no corresponding setter method.");
        // get hibernate type.
        NullableType nullableType = getMappedHibernateType(paramTypeName);
        Assert.notNull(nullableType, "Java data type " + paramTypeName + "has no corresponding configured hibernate scalar type.");
        return nullableType;
    }

    /**
     * java type
     * @param javaTypeSimpleName   int , Integer, Double, double and etc.
     * @return
     */
    private static NullableType getMappedHibernateType(String javaTypeSimpleName ){
        if(StringUtils.isBlank(javaTypeSimpleName)){
            return null;
        }
        return JAVA_HIBERNATE_TYPE_MAP.get(javaTypeSimpleName);
    }

    private static String getSimpleSetterMethodParamType(Map<String, String> setterMethodsParamsMap, String selectedColName){
        String setterMethodName = buildSetterMethodName(selectedColName);
        String paramTypeName = setterMethodsParamsMap.get(setterMethodName);
        return paramTypeName;
    }

    private static void setSimpleSetterMethodParamType(Map<String, String> setterMethodsParamsMap, Method method){
        // end sure it has one one parameter.
        Class<?>[] parameterTypes = method.getParameterTypes();
        if(parameterTypes != null && parameterTypes.length == 1){
            Class parameterType = parameterTypes[0];
            setterMethodsParamsMap.put(method.getName(), parameterType.getSimpleName());
        }
    }

    private static Map<String, String> extractSetterMethodsOfClass(Class mappedClass){
        // get first from cache.
        Map<String, String> setterMethodsParamsMap = REGISTERED_CLASSES_CACHE.get(mappedClass.getCanonicalName());
        if(setterMethodsParamsMap != null && setterMethodsParamsMap.size() > 0){
            return setterMethodsParamsMap;
        }
        synchronized (REGISTERED_CLASSES_CACHE){
            setterMethodsParamsMap = new HashMap<String, String>();
            Method[] methods =  mappedClass.getMethods();
            if(methods !=null && methods.length > 0){
                // register setter method.
                for(Method method : methods){
                    // ensure it's setter method.
                    if(method.getName().indexOf(PREFIX_SET) > -1 ){
                        setSimpleSetterMethodParamType(setterMethodsParamsMap, method);
                    }
                }
            }
            REGISTERED_CLASSES_CACHE.put(mappedClass.getCanonicalName(), setterMethodsParamsMap);
        }
        return setterMethodsParamsMap;
    }

    protected static String buildSetterMethodName(String fieldName){
        if(StringUtils.isBlank(fieldName)){
            return null;
        }

        String firstChar = StringUtils.substring(fieldName, 0, 1).toUpperCase();
        String leftChars = StringUtils.substring(fieldName, 1, fieldName.length());
        StringBuilder setterMethodName = new StringBuilder();
        setterMethodName.append(PREFIX_SET)
                .append(firstChar)
                .append(leftChars);
        return setterMethodName.toString();
    }

}
