package com.s3d.tech.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * con
 *
 * @author Administrator
 */
public class JsonParser {
    static Gson gson = new Gson();

    public static <T> String parseListToJson(List<T> objList) {
        String json = gson.toJson(objList);
        return json;
    }

    public static <T> List<T> parseJsonToList(String vMsg, TypeToken<List<T>> typeToken) {
        if (vMsg == null || "".equals(vMsg)) {
            return null;
        }
        Type type = typeToken.getType();
        List<T> msgV = (List<T>) gson.fromJson(vMsg, type);
        return msgV;
    }

    public static <T> String parseObjToJson(T obj) {
        String json = gson.toJson(obj);
        return json;
    }

    public static <T> T parseJsonToObj(String json, Class<T> cl) {
        return (T) gson.fromJson(json, cl);
    }

}