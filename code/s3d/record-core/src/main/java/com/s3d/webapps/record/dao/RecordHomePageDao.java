package com.s3d.webapps.record.dao;

import com.s3d.tech.mongo.dao.BaseMongoDao;
import com.s3d.tech.slicer.PageParam;
import com.s3d.webapps.record.dto.QRecordAccess;
import com.s3d.webapps.record.dto.QRecordParam;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;

import java.util.List;

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

    public List<RecordHomePage> getRecords(QRecordParam qRecordParam, List<QRecordAccess> accessList, PageParam pageParam);
}
