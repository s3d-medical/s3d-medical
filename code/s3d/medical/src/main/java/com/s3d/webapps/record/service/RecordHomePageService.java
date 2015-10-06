package com.s3d.webapps.record.service;

import com.s3d.webapps.record.entity.homepage.RecordHomePage;

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
}
