package com.s3d.tech.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Use jackson
 * @author Wind.Chen
 * @Date 2015/6/25.
 */
public class JacksonParser {
   static ObjectMapper mapper = new ObjectMapper();

    @Deprecated
    public static String convertToJSONString(Object object){
        if(object ==null){
            return null;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public static <T> T convertFromJSONString(String json, Class<T> targetClass) {
        if(StringUtils.isEmpty(json) || targetClass == null){
            return null;
        }
        try {
            return mapper.readValue(json, targetClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertToJSON(Object object){
        if(object ==null){
            return null;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T convertObj(String json, Class<T> targetClass) {
        if(StringUtils.isEmpty(json) || targetClass == null){
            return null;
        }
        try {
            return mapper.readValue(json, targetClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json 转collection
     * @param json
     * @param collectionClass
     * @param elementClass
     * @param <T>
     * @return
     */
    public static <T> List<T> convertToCollection(String json, Class collectionClass, Class<T> elementClass) {
        if(StringUtils.isEmpty(json) || collectionClass == null || elementClass == null){
            return null;
        }
        try {
            JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClass);
            return mapper.readValue(json, javaType);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
