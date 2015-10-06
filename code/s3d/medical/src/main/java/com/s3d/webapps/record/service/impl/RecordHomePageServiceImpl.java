package com.s3d.webapps.record.service.impl;

import com.s3d.webapps.record.dao.RecordHomePageDao;
import com.s3d.webapps.record.entity.homepage.OperationHistory;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;
import com.s3d.webapps.record.service.RecordHomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.che
 * @date 2015/10/5.
 */
@Service
public class RecordHomePageServiceImpl implements RecordHomePageService {
    @Override
    public RecordHomePage getByBusinessKey(String businessKey) {
        Assert.isTrue(!StringUtils.isEmpty(businessKey), "Business key is not null.");
        RecordHomePage homePage = recordHomePageDao.getByBusinessKey(businessKey);
        return homePage;
    }

    @Override
    public RecordHomePage getWithEmptyOne(String businessKey) {
        RecordHomePage homePage = this.getByBusinessKey(businessKey);
        if(homePage == null){
            homePage = this.buildEmptyOne();
            homePage.setBusinessKey(businessKey);
        }
        return homePage;
    }

    private RecordHomePage buildEmptyOne() {
        RecordHomePage recordHomePage = new RecordHomePage();
        List<OperationHistory> operationHistories = new ArrayList<OperationHistory>();
        for(int i =0 ; i< 28; i++){
            operationHistories.add(new OperationHistory());
        }
        recordHomePage.setOperationHistory(operationHistories);
        return recordHomePage;
    }

    @Override
    public void saveOrUpdate(RecordHomePage homePage) {
        if(homePage == null){
            return ;
        }
        this.recordHomePageDao.saveOrUpdate(homePage);
    }

    @Autowired
    public void setRecordHomePageDao(RecordHomePageDao recordHomePageDao) {
        this.recordHomePageDao = recordHomePageDao;
    }

    private RecordHomePageDao recordHomePageDao;
}
