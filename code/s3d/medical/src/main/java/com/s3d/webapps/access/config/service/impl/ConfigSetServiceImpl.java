package com.s3d.webapps.access.config.service.impl;

import com.s3d.webapps.access.config.dao.ConfigSetDao;
import com.s3d.webapps.access.config.persistence.ConfigDoctor;
import com.s3d.webapps.access.config.persistence.ConfigOperation;
import com.s3d.webapps.access.config.persistence.ConfigSet;
import com.s3d.webapps.access.config.service.ConfigSetService;
import com.s3d.webapps.access.config.vo.CodeTableItemVO;
import com.s3d.webapps.access.config.vo.OperationVO;
import com.s3d.webapps.da.config.dao.IDaConfigDoctorDao;
import com.s3d.webapps.da.config.dao.IDaConfigOperationDao;
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


    private void fillCodeTableMap(ConfigSetType configSetType, ValidationStatus validationStatus, Map<String, Object> targetConfigSetVOMap) {
        List<CodeTableItemVO> codeTableItemVOs = this.getCodeTables(configSetType.getCode(), validationStatus);
        targetConfigSetVOMap.put(configSetType.getName(), codeTableItemVOs);
    }

    private void fillDoctors(ConfigSetType configSetType, ValidationStatus validationStatus, Map<String, Object> targetConfigSetVOMap, String businessKey) {
        List<ConfigDoctor> doctors = configDoctorDao.getDoctorsByMainPage(businessKey, validationStatus.ordinal());
        List<CodeTableItemVO> vos = new ArrayList<CodeTableItemVO>();
        for (ConfigDoctor doctor : doctors) {
            vos.add(new CodeTableItemVO(doctor.getId() + "", doctor.getName(), doctor.getShortcut()));
        }
        targetConfigSetVOMap.put(configSetType.getName(), vos);
    }

    private void fillOperations(ConfigSetType configSetType, ValidationStatus validationStatus, Map<String, Object> targetConfigSetVOMap, String hospitalId) {
        List<ConfigOperation> operations = configOperationDao.getOperations(hospitalId, validationStatus.ordinal());
        List<OperationVO> vos = new ArrayList<OperationVO>();
        for(ConfigOperation operation : operations) {
            vos.add(new OperationVO(operation.getCode(), operation.getName(), operation.getShortcut(), operation.getGrade()));
        }
        targetConfigSetVOMap.put(configSetType.getName(), vos);
    }

    @Override
    public Map<String, Object> getCodeTablesInMap(ValidationStatus validationStatus, String businessKey, String hospitalId) {
        Map<String, Object> codeTableListMap = new HashMap<String, Object>();
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
        this.fillDoctors(ConfigSetType.DISCHARGE_DOCTORS, validationStatus, codeTableListMap, businessKey);
        this.fillOperations(ConfigSetType.DISCHARGE_OPERATIONS, validationStatus, codeTableListMap, hospitalId);
        return codeTableListMap;
    }

    @Autowired
    public void setConfigSetDao(ConfigSetDao configSetDao) {
        this.configSetDao = configSetDao;
    }

    @Autowired
    public void setConfigDoctorDao(IDaConfigDoctorDao configDoctorDao) {
        this.configDoctorDao = configDoctorDao;
    }

    @Autowired
    public void setConfigOperationDao(IDaConfigOperationDao configOperationDao) {
        this.configOperationDao = configOperationDao;
    }

    private ConfigSetDao configSetDao;

    private IDaConfigDoctorDao configDoctorDao;

    private IDaConfigOperationDao configOperationDao;
}
