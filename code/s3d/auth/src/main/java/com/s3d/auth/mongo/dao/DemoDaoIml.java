package com.s3d.auth.mongo.dao;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wind.Chen
 * @date 2015/6/30.
 */
@Repository
public class DemoDaoIml extends BaseMongoDaoImpl implements DemoDao {

    private String collectionName = "demo";

    /**
     * result will be returned in json format.
     *
     * @param collectionName
     * @param query
     *
     * @return
     *
     * @Param , Document query
     */
    @Override
    public List<String> findInJson(String collectionName, Document query) {
        return null;
    }

    @Override
    public List<String> findInJson(String collectionName, Bson query) {
        return null;
    }

    /**
     * result will be returned in Document format.
     *
     * @param collectionName
     * @param query
     *
     * @return
     */
    @Override
    public List<Document> findInDocuments(String collectionName, Document query) {
        return null;
    }


    /**
     * result will be returned in Document format.
     *
     * @param collectionName
     * @param query
     *
     * @return
     */
    @Override
    public List<Document> findInDocuments(String collectionName, Bson query) {
        return null;
    }

    /**
     * Result will be returned in object list.
     *
     * @param collection
     * @param givenClass
     * @param query
     *
     * @return
     */
    @Override
    public <T> List<T> findInObjects(String collection, Class<T> givenClass, Document query) {
        return null;
    }

    /**
     * @param collection
     * @param givenClass
     * @param query
     *
     * @return
     */
    @Override
    public <T> List<T> findInObjects(String collection, Class<T> givenClass, Bson query) {
        return null;
    }
}
