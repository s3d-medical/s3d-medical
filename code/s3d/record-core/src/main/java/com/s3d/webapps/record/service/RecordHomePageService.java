package com.s3d.webapps.record.service;

import com.s3d.tech.slicer.PageParam;
import com.s3d.webapps.record.dto.QRecordAccess;
import com.s3d.webapps.record.dto.QRecordParam;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;

import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */

public interface RecordHomePageService {

    public void insertOrReplace(RecordHomePage homePageVO);

    public RecordHomePage getByBusinessKey(String businessKey);

    /**
     * Get one RecordHomePage , if there is no one, just create new empty and return.
     * @param businessKey
     * @return
     */
    public RecordHomePage getWithEmptyOne(String businessKey);

    /**
     * query records.
     * 1. depart limitation.
     * 2. sign fields limitation.
     * 3.
     * @param qRecordParam
     * @return
     */
    public List<RecordHomePage>  queryRecordsByAccess(QRecordParam qRecordParam, List<QRecordAccess> accessList, PageParam pageParam);

}
