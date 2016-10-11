package com.s3d.webapps.da.config.service;

import com.s3d.webapps.access.config.persistence.ConfigOperation;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
public interface IDaConfigOperationService {

    List<ConfigOperation> getOperations(String hospitalId, Integer status);

    ConfigOperation getOperation(Integer id);

    Integer addOperation(ConfigOperation operation);

    void updateOperation(ConfigOperation operation);

    void deleteOperation(Integer id);


}
