package com.s3d.auth.mongo.dao;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;


import com.s3d.auth.mongo.dao.MongoDataSource.MongoDataSource;
import com.s3d.tech.slicer.ListSlicer;
import com.s3d.tech.utils.JacksonParser;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wind.Chen
 * @since 2015/6/30.
 */
public class BaseMongoDaoImpl implements BaseMongoDao {

    private MongoDataSource mongoDataSource;

    public BaseMongoDaoImpl() {

    }

    public void insertOneByDocument(String collectionName, Document doc) {
        if (doc == null) {
            return;
        }
        MongoCollection<Document> collection = this.getMongoDataSource().getDatabase().getCollection(collectionName);
        collection.insertOne(doc);
    }

    public void insertOneByJson(String collectionName, String jsonDoc) {
        if (jsonDoc == null) {
            return;
        }
        Document doc = Document.parse(jsonDoc);
        this.insertOneByDocument(collectionName, doc);
    }

    public void insertOneByObject(String collectionName, Object doc) {
        if (doc == null) {
            return;
        }
        String json = JacksonParser.convertToJSONString(doc);
        this.insertOneByJson(collectionName, json);
    }

    public void insertManyByDocument(String collectionName, List<Document> allDocuments) {
        if (CollectionUtils.isEmpty(allDocuments)) {
            return;
        }
        MongoCollection<Document> collection = getMongoDataSource().getDatabase().getCollection(collectionName);
        if (allDocuments.size() <= getMongoDataSource().getBatchSize()) {
            collection.insertMany(allDocuments);
            return;
        }
        ListSlicer slicer = new ListSlicer(allDocuments, getMongoDataSource().getBatchSize());
        int total = slicer.getSliceTotalCount();
        for (int currentStep = 1; currentStep <= total; currentStep++) {
            List<Document> subDocuments = slicer.getSliceByNo(currentStep);
            collection.insertMany(subDocuments);
        }
    }

    public void insertManyByJson(String collectionName, List<String> docsInJson) {
        if (CollectionUtils.isEmpty(docsInJson)) {
            return;
        }
        List<Document> docs = new ArrayList<Document>();
        for (String docInJson : docsInJson) {
            docs.add(Document.parse(docInJson));
        }
        this.insertManyByDocument(collectionName, docs);
    }

    public void insertManyByObject(String collectionName, List<Object> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        List<String> docsInJson = new ArrayList<String>();
        for (Object item : list) {
            docsInJson.add(JacksonParser.convertToJSONString(item));
        }
        this.insertManyByJson(collectionName, docsInJson);
    }

    @Override
    public List<String> findInJson(String collectionName,  Document query) {
        MongoCollection<Document> collection = this.getMongoDataSource().getDatabase().getCollection(collectionName);
        return this.fetchIntoStringList(collection.find());
    }

    @Override
    public List<String> findInJson(String collectionName, Bson query) {
        return null;
    }

    private List<String> fetchIntoStringList(FindIterable<Document> iterator) {
        final List<String> items = new ArrayList<String>();
        iterator.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String json = document.toJson();
                items.add(json);
            }
        });
        return items;
    }

    @Override
    public List<Document> findInDocuments(String collectionName,  Document query) {
        MongoCollection<Document> collection = this.getMongoDataSource().getDatabase().getCollection(collectionName);
        return this.fetchIntoDocumentList(collection.find());
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

    private List<Document> fetchIntoDocumentList(FindIterable<Document> iterable) {
        final List<Document> items = new ArrayList<Document>();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                items.add(document);
            }
        });
        return items;
    }

    @Override
    public <T> List<T> findInObjects(String collectionName, Class<T> givenClass,  Document query) {
        MongoCollection<Document> collection = this.getMongoDataSource().getDatabase().getCollection(collectionName);
        FindIterable<Document> iterable = collection.find();
        return this.fetchIntoObjectList(iterable, givenClass);
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

    private <T> List<T> fetchIntoObjectList(FindIterable<Document> iterable, final Class<T> givenClass) {
        final List<T> items = new ArrayList<T>();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                String json = document.toJson();
                T obj = JacksonParser.convertFromJSONString(json, givenClass);
                items.add(obj);
            }
        });
        return items;
    }

    public MongoDataSource getMongoDataSource() {
        return mongoDataSource;
    }

    @Autowired
    public void setMongoDataSource(MongoDataSource mongoDataSource) {
        this.mongoDataSource = mongoDataSource;
    }

}
