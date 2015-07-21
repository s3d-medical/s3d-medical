package com.s3d.webapps.da.config.service.impl;

import com.s3d.webapps.config.persistence.ConfigOperation;
import com.s3d.webapps.da.config.dao.IDaConfigOperationDao;
import com.s3d.webapps.da.config.service.IDaConfigOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/21.
 */
@Service
@Transactional
public class DaConfigOperationServiceImp implements IDaConfigOperationService {

    @Override
    public List<ConfigOperation> getOperations(String hospitalId) {
        return daConfigOperationDao.getOperations(hospitalId);
    }

    @Override
    public ConfigOperation getOperation(Integer id) {
        return daConfigOperationDao.getOperation(id);
    }

    @Override
    public Integer addOperation(ConfigOperation operation) {
        return daConfigOperationDao.addOperation(operation);
    }

    @Override
    public void updateOperation(ConfigOperation operation) {
        daConfigOperationDao.updateOperation(operation);
    }

    @Override
    public void deleteOperation(Integer id) {
        daConfigOperationDao.deleteOperation(id);
    }

    @Autowired
    private IDaConfigOperationDao daConfigOperationDao;

    public void setDaConfigOperationDao(IDaConfigOperationDao daConfigOperationDao) {
        this.daConfigOperationDao = daConfigOperationDao;
    }
}
