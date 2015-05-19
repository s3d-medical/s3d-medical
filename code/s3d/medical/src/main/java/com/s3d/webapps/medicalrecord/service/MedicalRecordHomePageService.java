package com.s3d.webapps.medicalrecord.service;

import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;
import com.s3d.webapps.medicalrecord.vo.MedicalRecordHomePageVO;
import org.springframework.stereotype.Service;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */

public interface MedicalRecordHomePageService {

    MedicalRecordHomePageVO getHomePageByBusinessKey(String businessKey);

    public void saveOrUpdateHomePage(MedicalRecordHomePageVO homePageVO);

}
