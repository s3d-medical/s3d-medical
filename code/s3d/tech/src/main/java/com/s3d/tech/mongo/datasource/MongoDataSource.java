package com.s3d.tech.mongo.datasource;

import com.mongodb.client.MongoDatabase;

/**
 * @Aut Wind.Chen on 2015/6/30.
 */
public interface MongoDataSource {

    public Integer getBatchSize();

    public void setBatchSize(Integer batchSize);

    public String getDatabaseName();

    public void setDatabaseName(String databaseName);

    public MongoDatabase getDatabase();

}
