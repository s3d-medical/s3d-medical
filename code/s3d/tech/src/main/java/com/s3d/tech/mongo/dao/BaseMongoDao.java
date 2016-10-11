package com.s3d.tech.mongo.dao;

import com.mongodb.client.MongoCollection;
import com.s3d.tech.slicer.PageParam;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

/**
 * @Aut Wind.Chen on 2015/6/30.
 */
public interface BaseMongoDao {

    public String getCollectionName();

    public MongoCollection<Document> getCollection(String collectionName);

    void insertOneByDocument(String collectionName, Document objectToBeSaved);

    void insertOneByJson(String collectionName, String objectToBeSaved);

    void insertOneByObject(String collectionName, Object objectToBeSaved);

    void insertManyByDocument(String collectionName, List<Document> objectsToBeSaved);

    void insertManyByJson(String collectionName, List<String> objectsToBeSaved);

    void insertManyByObject(String collectionName, List<Object> objectsToBeSaved);

    void updateOne(String collectionName, Bson filter, Object newObj);

    void updateMany(String collectionName, Bson query, Object newObj);

    List<String> findManyInJson(String collectionName, Bson query);

    /**
     *
     * @param collectionName
     * @param query
     * @return
     */
    List<Document> findManyInDocument(String collectionName, Bson query);

    /**
     *
     * @param collection
     * @param givenClass
     * @param query
     * @param <T>
     * @return
     */
    <T> List<T> findManyInObject(String collection, Class<T> givenClass, Bson query);

    /**
     *
     * @param collectionName
     * @param givenClass
     * @param query
     * @param pageParam
     * @param <T>
     * @return
     */
    <T> List<T> findManyInObject(String collectionName, final Class<T> givenClass, Bson query, PageParam pageParam);

    String findOneInJson(String collectionName, Bson query);

    Document findOneInDocument(String collectionName, Bson query);

    <T> T findOneInObject(String collection, Class<T> givenClass, Bson query);


}
