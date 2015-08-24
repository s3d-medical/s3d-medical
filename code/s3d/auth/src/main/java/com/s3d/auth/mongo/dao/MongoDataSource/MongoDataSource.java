package com.s3d.auth.mongo.dao.MongoDataSource;

import com.mongodb.client.MongoDatabase;

import java.util.List;

/**
 * @Aut Wind.Chen on 2015/6/30.
 */
public interface MongoDataSource {

    public Integer getBatchSize();

    public void setBatchSize(Integer batchSize);

    public List<String> getServersNames();

    public void setServersNames(List<String> serversNames);

    public List<Integer> getServerPorts();

    public void setServerPorts(List<Integer> serverPorts);

    public String getDatabaseName();

    public void setDatabaseName(String databaseName);

    public MongoDatabase getDatabase();

}
