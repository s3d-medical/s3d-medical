package com.s3d.webapps.record.service.impl;

import com.s3d.webapps.record.entity.homepage.RecordHomePage;
import com.s3d.webapps.record.service.RecordHomePageService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author wind.che
 * @date 2015/10/5.
 */
@Service
public class RecordHomePageServiceImpl implements RecordHomePageService {
    @Override
    public RecordHomePage getHomePageByBusinessKey(String businessKey) {
        Assert.isTrue(!StringUtils.isEmpty(businessKey), "Business key is not null.");

        return null;
    }

    @Override
    public void saveOrUpdateHomePage(RecordHomePage homePageVO) {

    }
}
