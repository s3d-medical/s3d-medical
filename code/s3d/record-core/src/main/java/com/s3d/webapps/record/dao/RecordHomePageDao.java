package com.s3d.webapps.record.dao;

import com.s3d.tech.mongo.dao.BaseMongoDao;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;

/**
 * @author wind.chen
 * @date 2015/10/5.
 */
public interface RecordHomePageDao extends BaseMongoDao {
    /**
     * find and replace one by replace all document.
     * @param homePage
     */
    public void replaceOne(RecordHomePage homePage);

    public void insertOne(RecordHomePage homePage);

    public RecordHomePage getByBusinessKey(String businessKey);

}
