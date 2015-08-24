package com.s3d.auth.mongo.dao;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

/**
 * @Aut Wind.Chen on 2015/6/30.
 */
public interface BaseMongoDao {

    void insertOneByDocument(String collectionName, Document doc);

    void insertOneByJson(String collectionName, String jsonDoc);

    void insertOneByObject(String collectionName, Object doc);

    void insertManyByDocument(String collectionName, List<Document> list);

    void insertManyByJson(String collectionName, List<String> list);

    void insertManyByObject(String collectionName, List<Object> list);

    /**
     * result will be returned in json format.
     *
     * @param collectionName
     * @Param , Document query
     * @return
     */
    List<String> findInJson(String collectionName, Document query);

    List<String> findInJson(String collectionName, Bson query);

    /**
     * result will be returned in Document format.
     * @param collectionName
     * @param query
     * @return
     */
    List<Document> findInDocuments(String collectionName, Document query);

    /**
     * result will be returned in Document format.
     * @param collectionName
     * @param query
     * @return
     */
    List<Document> findInDocuments(String collectionName, Bson query);

    /**
     * Result will be returned in object list.
     * @param collection
     * @param givenClass
     * @param query
     * @param <T>
     * @return
     */
    <T> List<T> findInObjects(String collection, Class<T> givenClass, Document query);

    /**
     *
     * @param collection
     * @param givenClass
     * @param query
     * @param <T>
     * @return
     */
    <T> List<T> findInObjects(String collection, Class<T> givenClass, Bson query);

}
