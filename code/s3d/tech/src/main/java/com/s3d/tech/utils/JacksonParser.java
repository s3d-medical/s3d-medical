package com.s3d.tech.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Use jackson
 * @author Wind.Chen
 * @Date 2015/6/25.
 */
public class JacksonParser {
   static ObjectMapper mapper = new ObjectMapper();
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

}
