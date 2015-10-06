package com.s3d.tech.mongo.dao;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.s3d.tech.mongo.datasource.MongoDataSource;
import com.s3d.tech.slicer.ListSlicer;

import com.s3d.tech.utils.JacksonParser;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author Wind.Chen
 * @since 2015/6/30.
 */
public abstract class BaseMongoDaoImpl implements BaseMongoDao {
    private Map<String, MongoCollection<Document>> collectionMap = new HashMap<String, MongoCollection<Document>>();

    private MongoDataSource mongoDataSource;

    public BaseMongoDaoImpl() {

    }

    //------------------------  insert one -------------------------

    public void insertOneByDocument(String collectionName, Document doc) {
        if (doc == null) {
            return;
        }
        MongoCollection<Document> collection = this.getCollection(collectionName);
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

    //------------- insert many by batch ----------------

    public void insertManyByDocument(String collectionName, List<Document> allDocuments) {
        if (CollectionUtils.isEmpty(allDocuments)) {
            return;
        }
        MongoCollection<Document> collection = this.getCollection(collectionName);
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

    @Override
    public void insertManyByObject(String collectionName, List<Object> objectsToBeSaved) {
        if (CollectionUtils.isEmpty(objectsToBeSaved)) {
            return;
        }
        List<String> docs = new ArrayList<String>();
        for (Object doc : objectsToBeSaved) {
            docs.add(JacksonParser.convertToJSONString(doc));
        }
        this.insertManyByJson(collectionName, docs);
    }

    //-------------------------query ---------------------------------

    /**
     * result will be returned in Document format.
     *
     * @param collectionName
     * @param query
     * @return
     */
    @Override
    public List<Document> findManyInDocument(String collectionName, Bson query) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> findIterable = collection.find(query);
        final List<Document> items = new ArrayList<Document>();
        findIterable.forEach(new Block<Document>() {
            @Override
            public void apply(Document document) {
                items.add(document);
            }
        });
        return items;
    }

    @Override
    public List<String> findManyInJson(String collectionName, Bson query) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> iterator = collection.find(query);
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
    public <T> List<T> findManyInObject(String collectionName, final Class<T> givenClass, Bson query) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> iterable = collection.find(query);
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

    @Override
    public Document findOneInDocument(String collectionName, Bson query) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        Document doc = collection.find(query).first();
        return doc;
    }

    /**
     * find first one.
     *
     * @param collectionName
     * @param query
     * @return
     */
    @Override
    public String findOneInJson(String collectionName, Bson query) {
        Document doc = this.findOneInDocument(collectionName, query);
        if (doc == null) {
            return null;
        }
        return doc.toJson();
    }

    /**
     * find one.
     *
     * @param collectionName
     * @param givenClass
     * @param query
     * @param <T>
     * @return
     */
    @Override
    public <T> T findOneInObject(String collectionName, Class<T> givenClass, Bson query) {
        String doc = this.findOneInJson(collectionName, query);
        return JacksonParser.convertFromJSONString(doc, givenClass);
    }

    // find and update.
    @Override
    public Document findOneAndUpdate(String collectionName, Bson query, Object givenDoc) {
        if (givenDoc == null) {
            return null;
        }
        MongoCollection<Document> collection = this.getCollection(collectionName);
        String json = JacksonParser.convertToJSONString(givenDoc);
        Bson newDoc = Document.parse(json);

        Document oldOneDoc = collection.findOneAndUpdate(query, newDoc);
        return oldOneDoc;
    }

    // --------------------count --------------
    public long count(String collectionName, Bson query) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        long totalCount = collection.count(query);
        return totalCount;
    }


    // ---------------------------assist methods.----------------

    /**
     * Get collection by collection name.
     *
     * @param collectionName
     * @return
     */
    public MongoCollection<Document> getCollection(String collectionName) {
/*        MongoCollection<Document> collection = collectionMap.get(collectionName);
        if (collection == null) {
            collection = getMongoDataSource().getDatabase().getCollection(collectionName);
            this.collectionMap.put(collectionName, collection);
        }
        return collection;*/
        return getMongoDataSource().getDatabase().getCollection(collectionName);
    }

    public MongoDataSource getMongoDataSource() {
        return mongoDataSource;
    }

    @Autowired
    public void setMongoDataSource(MongoDataSource mongoDataSource) {
        this.mongoDataSource = mongoDataSource;
    }

}
