package com.s3d.tech.mongo.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.s3d.tech.mongo.MongoClientUtil;
import com.s3d.tech.mongo.datasource.MongoDataSource;
import com.s3d.tech.slicer.ListSlicer;

import com.s3d.tech.slicer.PageParam;
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
        Document document = MongoClientUtil.toDoc(doc);
        this.insertOneByDocument(collectionName, document);
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
        List<Document> docs = new ArrayList<Document>();
        for (Object doc : objectsToBeSaved) {
            Document document = MongoClientUtil.toDoc(doc);
            if(document != null){
                docs.add(document);
            }
        }
        this.insertManyByDocument(collectionName, docs);
    }

    //-------------------------query ---------------------------------

    /**
     * result will be returned in Document format.
     *
     * @param collectionName
     * @param filter
     * @return
     */
    @Override
    public List<Document> findManyInDocument(String collectionName, Bson filter) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> findIterable = collection.find(filter);
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
    public List<String> findManyInJson(String collectionName, Bson filter) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> iterator = collection.find(filter);
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
    public <T> List<T> findManyInObject(String collectionName, final Class<T> givenClass, Bson filter) {
        return  this.findManyInObject(collectionName, givenClass, filter, null);
    }

    @Override
    public <T> List<T> findManyInObject(String collectionName, final Class<T> givenClass, Bson filter, PageParam pageParam) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        FindIterable<Document> iterable = null;
        if(filter != null){
            iterable = collection.find(filter);
        }else{
            iterable = collection.find();
        }
        if(pageParam != null) {
            iterable =iterable.skip(pageParam.getStartNo()).limit(pageParam.getPageSize());
        }
        final List<T> items = new ArrayList<T>();
        if(iterable != null){
            iterable.forEach(new Block<Document>() {
                @Override
                public void apply(Document document) {
                    items.add(MongoClientUtil.toObj(document, givenClass));
                }
            });
        }
        return items;
    }

    @Override
    public Document findOneInDocument(String collectionName, Bson filter) {
        MongoCollection<Document> collection = this.getCollection(collectionName);
        Document doc = collection.find(filter).first();
        return doc;
    }

    /**
     * find first one.
     *
     * @param collectionName
     * @param filter
     * @return
     */
    @Override
    public String findOneInJson(String collectionName, Bson filter) {
        Document doc = this.findOneInDocument(collectionName, filter);
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
     * @param filter
     * @param <T>
     * @return
     */
    @Override
    public <T> T findOneInObject(String collectionName, Class<T> givenClass, Bson filter) {
        Document doc = this.findOneInDocument(collectionName, filter);
        return MongoClientUtil.toObj(doc, givenClass);
    }

    @Override
    public void updateOne(String collectionName, Bson filter, Object newObj) {
        if (newObj == null) {
            return;
        }
        String newObjInJson = JacksonParser.convertToJSONString(newObj);
        Document newDoc = Document.parse(newObjInJson);
        this.getCollection(collectionName).updateOne(filter, new Document("$set", newDoc));
    }

    @Override
    public void updateMany(String collectionName, Bson filter, Object newObj) {
        if (newObj == null) {
            return;
        }
        String newObjInJson = JacksonParser.convertToJSONString(newObj);
        Document newDoc = Document.parse(newObjInJson);
        this.getCollection(collectionName).updateMany(filter, new Document("$set", newDoc));
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
