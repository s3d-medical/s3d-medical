package com.s3d.webapps.config.service;

import com.s3d.webapps.config.persistence.ConfigSet;
import com.s3d.webapps.config.vo.CodeTableItemVO;
import com.s3d.webapps.pub.datatype.ValidationStatus;

import java.util.List;
import java.util.Map;

/**
 * @author  Administrator
 * @date 2015/5/23.
 */
public interface ConfigSetService {
    public List<ConfigSet> getConfigSets(String fdType, ValidationStatus validationStatus);
    public List<CodeTableItemVO> getCodeTables(String fdType, ValidationStatus validationStatus);
    public Map<String, Object> getCodeTablesInMap(ValidationStatus validationStatus, String businessKey, String hospitalId);
}
