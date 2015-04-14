package com.s3d.webapps.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.HQLParameter;
import com.s3d.webapps.common.dao.HQLWrapper;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.exception.WebAppsRuntimeException;

public class HQLUtil {

	private static final AtomicLong atomicLong = new AtomicLong(0);

	/**
	 * @return 自增的ID号
	 */
	public static long getFieldIndex() {
		atomicLong.compareAndSet(10000, 0); // 如果累加到了10000，重置为0
		return atomicLong.getAndIncrement();
	}
	
	public static String getAutoFetchInfo(HQLInfo hqlInfo) {
		if (!hqlInfo.isAutoFetch())
			return "";
		if (StringUtils.isEmpty(hqlInfo.getOrderBy()))
			return "";
		String[] info = hqlInfo.getOrderBy().split("[^A-Za-z0-9_\\.]+");
		StringBuffer rtnVal = new StringBuffer();
		for (int i = 0; i < info.length; i++) {
			info[i] = info[i].trim();
			if (info[i].length() == 0)
				continue;
			int j = info[i].indexOf(" ");
			if (j > -1)
				info[i] = info[i].substring(0, j);
			String[] infoArr = info[i].split("\\.");
			info[i] = infoArr[0];
			for (j = 1; j < infoArr.length - 1; j++) {
				info[i] = info[i] + "." + infoArr[j];
				rtnVal.append("left join fetch " + info[i] + " ");
			}
		}
		return rtnVal.toString();
	}

	public static HQLWrapper buildPreparedLogicIN(String item, List<?> valueList) {
		List<?> valueCopy = new ArrayList<Object>(valueList);
		HQLWrapper hqlWrapper = new HQLWrapper();
		int n = (valueCopy.size() - 1) / 1000;
		StringBuffer whereBlockTmp = new StringBuffer();
		List<?> tmpList;
		for (int k = 0; k <= n; k++) {
			int size = k == n ? valueCopy.size() : (k + 1) * 1000;
			if (k > 0) {
				whereBlockTmp.append(" or ");
			}
			String para = "webapps_hql_in_para_" + getFieldIndex();
			whereBlockTmp.append(item + " in (:" + para + ")");
			tmpList = valueCopy.subList(k * 1000, size);
			HQLParameter hqlParameter = new HQLParameter(para, tmpList);
			hqlWrapper.setParameter(hqlParameter);
		}
		if (n > 0) {
			hqlWrapper.setHql("(" + whereBlockTmp.toString() + ")");
		} else {
			hqlWrapper.setHql(whereBlockTmp.toString());
		}
		return hqlWrapper;
	}

	public static String buildLogicIN(String item, List valueList) {
		int n = (valueList.size() - 1) / 1000;
		StringBuffer rtnStr = new StringBuffer();
		Object obj = valueList.get(0);
		boolean isString = false;
		if (obj instanceof Character || obj instanceof String)
			isString = true;
		String tmpStr;
		for (int i = 0; i <= n; i++) {
			int size = i == n ? valueList.size() : (i + 1) * 1000;
			if (i > 0)
				rtnStr.append(" or ");
			rtnStr.append(item + " in (");
			if (isString) {
				StringBuffer tmpBuf = new StringBuffer();
				for (int j = i * 1000; j < size; j++) {
					tmpStr = valueList.get(j).toString().replaceAll("'", "''");
					tmpBuf.append(",'").append(tmpStr).append("'");
				}
				tmpStr = tmpBuf.substring(1);
			} else {
				tmpStr = valueList.subList(i * 1000, size).toString();
				tmpStr = tmpStr.substring(1, tmpStr.length() - 1);
			}
			rtnStr.append(tmpStr);
			rtnStr.append(")");
		}
		if (n > 0)
			return "(" + rtnStr.toString() + ")";
		else
			return rtnStr.toString();
	}

	public static String buildModelIds(List modelList) {
		if (modelList != null && !modelList.isEmpty()) {
			StringBuffer rtnVal = new StringBuffer();
			for (int i = 0; i < modelList.size(); i++) {
				EntityObject baseModel = (EntityObject) modelList.get(i);
				rtnVal.append("'").append(baseModel.getFdId());
				if (i != modelList.size() - 1) {
					rtnVal.append("',");
				} else {
					rtnVal.append("'");
				}
			}
			return rtnVal.toString();
		} else {
			return null;
		}
	}

	public static Map buildManyToManyIDMap(Session hbmSession, String sql) {
		Map rtnMap = new HashMap();
		List rtnList = hbmSession.createSQLQuery(sql).list();
		for (int i = 0; i < rtnList.size(); i++) {
			Object[] ids = (Object[]) rtnList.get(i);
			if (rtnMap.containsKey(ids[0])) {
				List valueList = (List) rtnMap.get(ids[0]);
				if (!valueList.contains(ids[1]))
					valueList.add(ids[1]);
			} else {
				List valueList = new ArrayList();
				valueList.add(ids[1]);
				rtnMap.put(ids[0], valueList);
			}
		}
		return rtnMap;
	}

	public static Map[] buildManyToManyIDBidirectionalMap(Session hbmSession,
			String sql) {
		Map[] rtnMap = { new HashMap(), new HashMap() };
		List rtnList = hbmSession.createSQLQuery(sql).list();
		for (int i = 0; i < rtnList.size(); i++) {
			Object[] ids = (Object[]) rtnList.get(i);
			if (rtnMap[0].containsKey(ids[0])) {
				List valueList = (List) rtnMap[0].get(ids[0]);
				if (!valueList.contains(ids[1]))
					valueList.add(ids[1]);
			} else {
				List valueList = new ArrayList();
				valueList.add(ids[1]);
				rtnMap[0].put(ids[0], valueList);
			}
			if (rtnMap[1].containsKey(ids[1])) {
				List valueList = (List) rtnMap[1].get(ids[1]);
				if (!valueList.contains(ids[0]))
					valueList.add(ids[0]);
			} else {
				List valueList = new ArrayList();
				valueList.add(ids[0]);
				rtnMap[1].put(ids[1], valueList);
			}
		}
		return rtnMap;
	}


	public static List fetchManyToManyIDList(List idList, Map idMap) {
		List results = new ArrayList();
		for (int i = 0; i < idList.size(); i++)
			fetchManyToManyIDList((String) idList.get(i), results, idMap);
		ArrayUtils.concatTwoList(idList, results);
		return results;
	}

	
	private static void fetchManyToManyIDList(String id, List results, Map idMap) {
		if (results.contains(id))
			return;
		results.add(id);
		if (idMap.containsKey(id)) {
			List idList = (List) idMap.get(id);
			for (int i = 0; i < idList.size(); i++)
				fetchManyToManyIDList((String) idList.get(i), results, idMap);
		}
	}
	
	
	public static String[] formatPropertyWithJoin(String modelName,
			String propertyName) {
		return formatPropertyWithJoin(modelName, propertyName, null);
	}

	public static String[] formatPropertyWithJoin(String modelName,
			String propertyName, String startProperty) {
		String[] rtnVal = { "", "" };

		String[] propertyArray = propertyName.split("\\.");
		String orgModelName = modelName;
		String tmpProperty = startProperty == null ? ModelUtil
				.getModelTableName(modelName) : startProperty;
		for (int i = 0; i < propertyArray.length; i++) {
			Type type;
			Class<?> z;
			try {
				z = Class.forName(modelName);
				type = HibernateConfigurationHelper.getProperty(z, propertyName).getType();
			} catch (ClassNotFoundException e) {
				throw new WebAppsRuntimeException(new WebAppsMessage(
						"error.datadict.propertyUndefined", orgModelName,
						propertyName));
			}			
			if (type == null)
				throw new WebAppsRuntimeException(new WebAppsMessage(
						"error.datadict.propertyUndefined", orgModelName,
						propertyName));
			
			if (type.isCollectionType()) {
				long index = getFieldIndex();
				rtnVal[1] += " left join " + tmpProperty + "."
						+ propertyArray[i] + " webapps_list_field_" + index + " ";
				tmpProperty = "webapps_list_field_" + index;
				modelName = HibernateConfigurationHelper.getTypeInListProperty(z, propertyName);
			} else {
				tmpProperty += "." + propertyArray[i];
				if(type.isAssociationType()){
					modelName = HibernateConfigurationHelper.getAssociationTypeOProperty(z, propertyName);
				}else{
					System.out.println("TODO : 不应该到这里来");
					//TODO 获取 property 的type 赋给modelName;
					//modelName = 
				}
			}
		}
		rtnVal[0] = tmpProperty;
		return rtnVal;
	}

	/**
	 * 将“aaa,bbb,ccc”或“aaa;bbb;ccc”的字符串转换为SQL使用的“'aaa','bbb','ccc'”
	 * 
	 * @param str
	 * @return
	 */
	public static String replaceToSQLString(String str) {
		if (str == null)
			return null;
		String rtnVal = str.trim();
		if (rtnVal.length() == 0)
			return str;
		rtnVal = rtnVal.replaceAll("\\s*[,;]\\s*", "','");
		return "'" + rtnVal + "'";
	}

	/**
	 * 返回当前使用数据库的uuid生成函数
	 * 
	 * @return
	 */
	public static String getSqlIDGenerationFunction() {
		String retval = "UUID()"; // default mysql
		
		return retval;
	}

	/**
	 * 设置query的预编译参数
	 * 
	 * @param query
	 * @param parameterList
	 */
	public static Query setParameters(Query query,
			List<HQLParameter> parameterList) {
		for (HQLParameter parameter : parameterList) {
			if (parameter.getType() == null) {
				if (parameter.getValue() instanceof Collection<?>) {
					Collection<?> value = (Collection<?>) parameter.getValue();
					query.setParameterList(parameter.getName(), value);
				} else {
					query.setParameter(parameter.getName(), parameter
							.getValue());
				}
			} else {
				if (parameter.getValue() instanceof Collection<?>) {
					Collection<?> value = (Collection<?>) parameter.getValue();
					query.setParameterList(parameter.getName(), value,
							parameter.getType());
				} else {
					query.setParameter(parameter.getName(), parameter
							.getValue(), parameter.getType());
				}
			}
		}
		return query;
	}

}