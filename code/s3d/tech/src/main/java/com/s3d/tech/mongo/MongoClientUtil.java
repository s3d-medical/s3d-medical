package com.s3d.tech.mongo;

import com.s3d.tech.utils.JacksonParser;
import org.bson.Document;

/**
 * @author Administrator
 * @desc com.s3d.tech.mongo
 * @date 2016/2/12 10:23
 */
public class MongoClientUtil {

    public static Document toDoc(Object obj) {
        if (obj == null) {
            return null;
        }
        String newObjInJson = JacksonParser.convertToJSONString(obj);
        return  Document.parse(newObjInJson);
    }

    public static <T> T toObj(Document doc, Class<T> givenClass){
        if(doc == null){
            return null;
        }
        String json = doc.toJson();
        T obj = JacksonParser.convertFromJSONString(json, givenClass);
        return obj;
    }
}
