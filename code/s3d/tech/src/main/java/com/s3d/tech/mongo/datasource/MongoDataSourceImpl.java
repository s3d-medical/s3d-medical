package com.s3d.tech.mongo.datasource;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoDatabase;
import org.springframework.util.StringUtils;

/**
 * @author Wind.Chen
 * @since 2015/6/30.
 */
public class MongoDataSourceImpl implements MongoDataSource {

    private Integer batchSize = 100;

    private String databaseName;

    private String mongodbServerURI;

    private MongoClient mongoClient;

    private MongoDatabase database;

    public MongoDataSourceImpl() {

    }

    synchronized private void initMongoClient() {
        if (StringUtils.isEmpty(mongodbServerURI)) {
            throw new RuntimeException("Mongo data source should be given server names and related ports");
        }
        MongoClientURI connectionString = new MongoClientURI(mongodbServerURI);
        mongoClient = new MongoClient(connectionString);
        mongoClient.setReadPreference(ReadPreference.secondary());
    }

    public String getMongodbServerURI() {
        return mongodbServerURI;
    }

    public void setMongodbServerURI(String mongodbServerURI) {
        this.mongodbServerURI = mongodbServerURI;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public MongoDatabase getDatabase() {
        if (mongoClient == null) {
            this.initMongoClient();
        }
        if (database == null) {
            database = mongoClient.getDatabase(databaseName);
        }
        return database;
    }

    public MongoDatabase getDatabaseByName(String givenDbName) {
        if (StringUtils.hasText(givenDbName)) {
            if (mongoClient == null) {
                this.initMongoClient();
            }
            return mongoClient.getDatabase(databaseName);
        }
        return null;
    }

}
