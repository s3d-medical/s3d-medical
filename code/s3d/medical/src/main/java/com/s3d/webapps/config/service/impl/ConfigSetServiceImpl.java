package com.s3d.webapps.config.service.impl;

import com.s3d.webapps.config.dao.ConfigSetDao;
import com.s3d.webapps.config.persistence.ConfigSet;
import com.s3d.webapps.config.service.ConfigSetService;
import com.s3d.webapps.config.vo.CodeTableItemVO;
import com.s3d.webapps.pub.datatype.ConfigSetType;
import com.s3d.webapps.pub.datatype.ValidationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @date 2015-05-20
 */
@Service
@Transactional
public class ConfigSetServiceImpl implements ConfigSetService {
    @Override
    public List<ConfigSet> getConfigSets(String fdType, ValidationStatus validationStatus) {
        return this.configSetDao.getConfigSets(fdType, validationStatus);
    }

    @Override
    public List<CodeTableItemVO> getCodeTables(String fdType, ValidationStatus validationStatus) {
        List<CodeTableItemVO> codeTableItemVOs = new ArrayList<CodeTableItemVO>();
        List<ConfigSet> srcConfigSets = this.configSetDao.getConfigSets(fdType, validationStatus);
        if (srcConfigSets == null || srcConfigSets.size() == 0) {
            return codeTableItemVOs;
        }
        for (ConfigSet set : srcConfigSets) {
            codeTableItemVOs.add(new CodeTableItemVO(set.getFdCode(), set.getFdName(), set.getFdShortcut()));
        }
        return codeTableItemVOs;
    }


    private void fillCodeTableMap(ConfigSetType configSetType, ValidationStatus validationStatus, Map<String, List<CodeTableItemVO>> targetConfigSetVOMap) {
        List<CodeTableItemVO> codeTableItemVOs = this.getCodeTables(configSetType.getCode(), validationStatus);
        targetConfigSetVOMap.put(configSetType.getName(), codeTableItemVOs);
    }

    @Override
    public Map<String, List<CodeTableItemVO>> getCodeTablesInMap(ValidationStatus validationStatus) {
        Map<String, List<CodeTableItemVO>> codeTableListMap = new HashMap<String, List<CodeTableItemVO>>();
        this.fillCodeTableMap(ConfigSetType.COUNTRY, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.NATIONS, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.LOCATION, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.MARRIAGE_STATUS, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.JOB, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.RELATIONSHIP, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.SICK_CODES, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.HOSPITALIZED_TYPES, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.IN_SICK_STATES, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.DISCHARGED_TYPES, validationStatus, codeTableListMap);
        this.fillCodeTableMap(ConfigSetType.DEPARTMENT, validationStatus, codeTableListMap);
        return codeTableListMap;
    }

    @Autowired
    public void setConfigSetDao(ConfigSetDao configSetDao) {
        this.configSetDao = configSetDao;
    }

    private ConfigSetDao configSetDao;
}
