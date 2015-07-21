package com.s3d.webapps.da.config.dao;

import com.s3d.tech.data.dao.GenericDao;
import com.s3d.webapps.config.persistence.ConfigOperation;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/21.
 */
public interface IDaConfigOperationDao extends GenericDao<ConfigOperation, Integer> {

    List<ConfigOperation> getOperations(String hospitalId);

    ConfigOperation getOperation(Integer id);

    Integer addOperation(ConfigOperation operation);

    void updateOperation(ConfigOperation operation);

    void deleteOperation(Integer id);

}
