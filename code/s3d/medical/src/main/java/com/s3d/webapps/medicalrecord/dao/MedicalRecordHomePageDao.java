package com.s3d.webapps.medicalrecord.dao;

import com.s3d.tech.data.dao.GenericDao;
import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;

/**
 * @author wind.chen
 * @dte 2015/5/15.
 */
public interface MedicalRecordHomePageDao extends GenericDao<MedicalRecordHomePage,Integer> {
    MedicalRecordHomePage getByBusinessKey(String businessKey);
}
