package com.s3d.webapps.record.service.impl;

import com.s3d.tech.slicer.PageParam;
import com.s3d.webapps.record.dao.RecordHomePageDao;
import com.s3d.webapps.record.dto.QRecordAccess;
import com.s3d.webapps.record.dto.QRecordParam;
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

    @Override
    public List<RecordHomePage> queryRecordsByAccess(QRecordParam qRecordParam, List<QRecordAccess> accessList, PageParam pageParam) {
        if(pageParam == null){
            return null;
        }
        if(accessList == null ){
            throw new RuntimeException("请指定查找的当前用户权限");
        }
       return this.recordHomePageDao.getRecords(qRecordParam, accessList, pageParam);
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
    public void insertOrReplace(RecordHomePage homePage) {
        if(homePage == null){
            return ;
        }
        RecordHomePage old = this.recordHomePageDao.getByBusinessKey(homePage.getBusinessKey());
        if(old == null){
            this.recordHomePageDao.insertOne(homePage);
        }else{
            homePage.set_id(old.get_id());
            this.recordHomePageDao.replaceOne(homePage);
        }
    }

    @Autowired
    public void setRecordHomePageDao(RecordHomePageDao recordHomePageDao) {
        this.recordHomePageDao = recordHomePageDao;
    }

    private RecordHomePageDao recordHomePageDao;
}
