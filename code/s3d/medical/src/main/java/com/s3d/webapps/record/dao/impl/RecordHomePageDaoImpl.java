package com.s3d.webapps.record.dao.impl;

import com.mongodb.client.MongoCollection;
import com.s3d.tech.mongo.dao.BaseMongoDao;
import com.s3d.tech.mongo.dao.BaseMongoDaoImpl;
import com.s3d.tech.utils.JacksonParser;
import com.s3d.webapps.record.dao.RecordHomePageDao;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.hibernate.mapping.Collection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

/**
 * @author wind.chen
 * @date 2015/10/5.
 */
@Repository
public class RecordHomePageDaoImpl extends BaseMongoDaoImpl implements RecordHomePageDao {

    @Override
    public String getCollectionName() {
        return "record";
    }

    @Override
    public void saveOrUpdate(RecordHomePage homePage) {
        Bson query = eq("businessKey", homePage.getBusinessKey());
        this.findOneAndUpdate(this.getCollectionName(), query, homePage);
    }

    @Override
    public RecordHomePage getByBusinessKey(String businessKey) {
        Bson query = eq("businessKey", businessKey);
        RecordHomePage recordHomePage = this.findOneInObject(this.getCollectionName(), RecordHomePage.class, query);
        return recordHomePage;
    }

}
