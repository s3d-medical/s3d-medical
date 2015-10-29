package com.s3d.webapps.da.config.service;

import com.s3d.webapps.config.persistence.ConfigOperation;
import com.s3d.webapps.config.vo.CodeTableItemVO;
import com.s3d.webapps.pub.datatype.ValidationStatus;

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
