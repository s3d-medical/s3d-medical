package com.s3d.webapps.record.service;

import com.s3d.webapps.record.entity.homepage.RecordHomePage;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */

public interface RecordHomePageService {

    public void saveOrUpdateHomePage(RecordHomePage homePageVO);

    public RecordHomePage getHomePageByBusinessKey(String businessKey);

}
