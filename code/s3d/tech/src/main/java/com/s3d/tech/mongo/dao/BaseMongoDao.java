package com.s3d.tech.mongo.dao;

import com.mongodb.client.MongoCollection;
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

    List<String> findManyInJson(String collectionName, Bson query);

    List<Document> findManyInDocument(String collectionName, Bson query);

    <T> List<T> findManyInObject(String collection, Class<T> givenClass, Bson query);

    String findOneInJson(String collectionName, Bson query);

    Document findOneInDocument(String collectionName, Bson query);

    <T> T findOneInObject(String collection, Class<T> givenClass, Bson query);
}
