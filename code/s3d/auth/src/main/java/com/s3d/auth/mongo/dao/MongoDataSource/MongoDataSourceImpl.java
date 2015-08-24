package com.s3d.auth.mongo.dao.MongoDataSource;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wind.Chen
 * @since 2015/6/30.
 */
public class MongoDataSourceImpl implements MongoDataSource{

    private Integer batchSize = 100;

    private String databaseName;

    private List<String> serversNames;

    private List<Integer> serverPorts;

    private MongoClient mongoClient;

    private MongoDatabase database;

    public MongoDataSourceImpl() {

    }

    synchronized private void initMongoClient() {
        if (serversNames == null || serverPorts == null
                || serversNames.size() == 0 || serverPorts.size() == 0
                || (serversNames.size() != serverPorts.size())) {
            throw new RuntimeException("Mongo data source should be given server names and related ports");
        }
        if(mongoClient == null){
            List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
            for(int i=0; i< serversNames.size(); i++){
                serverAddresses.add(new ServerAddress(serversNames.get(i), serverPorts.get(i)));
            }
            mongoClient = new MongoClient(serverAddresses);
            mongoClient.setReadPreference(ReadPreference.secondary());
        }
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(Integer batchSize) {
        this.batchSize = batchSize;
    }

    public List<String> getServersNames() {
        return serversNames;
    }

    public void setServersNames(List<String> serversNames) {
        this.serversNames = serversNames;
    }

    public List<Integer> getServerPorts() {
        return serverPorts;
    }

    public void setServerPorts(List<Integer> serverPorts) {
        this.serverPorts = serverPorts;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public MongoDatabase getDatabase() {
        if(mongoClient == null){
            this.initMongoClient();
        }
        if (database == null) {
            database = mongoClient.getDatabase(databaseName);
        }
        return database;
    }

    public MongoDatabase getDatabaseByName(String givenDbName) {
        if (StringUtils.hasText(givenDbName)) {
            if(mongoClient == null){
                this.initMongoClient();
            }
            return mongoClient.getDatabase(databaseName);
        }
        return null;
    }
}
