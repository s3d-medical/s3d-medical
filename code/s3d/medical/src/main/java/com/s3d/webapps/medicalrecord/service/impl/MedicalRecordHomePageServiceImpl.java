package com.s3d.webapps.medicalrecord.service.impl;

import com.s3d.webapps.medicalrecord.convertor.MedicalRecordHomePageConvertor;
import com.s3d.webapps.medicalrecord.dao.MedicalRecordHomePageDao;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.homepagebasic.HomePageBasicInfo;
import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.coma.ComaInfo;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisPathology;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.doctor.DoctorInCharge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.entryexit.RegisterAdmission;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.entryexit.RegisterDischarge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseInvoice;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseItem;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient.PatientInfo;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.quality.QualityControlInfo;
import com.s3d.webapps.medicalrecord.service.MedicalRecordHomePageService;
import com.s3d.webapps.medicalrecord.vo.MedicalRecordHomePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
@Component("medicalRecordHomePageService")
@Transactional
public class MedicalRecordHomePageServiceImpl implements MedicalRecordHomePageService {
    @Override
    public MedicalRecordHomePageVO getHomePageByBusinessKey(String businessKey) {
        MedicalRecordHomePage homePage = this.medicalRecordHomePageDao.getByBusinessKey(businessKey);
        if (homePage == null) {
            homePage = this.buildOneEmpty(businessKey);
        }
        // convert to vo.
        MedicalRecordHomePageVO homePageVO = new MedicalRecordHomePageVO();
        this.medicalRecordHomePageConvertor.copyToVO(homePage, homePageVO);
        return homePageVO;
    }

    @Override
    public void saveOrUpdateHomePage(MedicalRecordHomePageVO homePageVO) {
        MedicalRecordHomePage homePage = this.medicalRecordHomePageDao.getByBusinessKey(homePageVO.getBusinessKey());
        if (homePage == null) {
            homePage = this.buildOneEmpty(homePageVO.getBusinessKey());
        }
        this.medicalRecordHomePageConvertor.copyToPo(homePageVO, homePage);
        this.medicalRecordHomePageDao.saveOrUpdate(homePage);
    }

    protected MedicalRecordHomePage buildOneEmpty(String businessKey) {
        MedicalRecordHomePage medicalRecordHomePage = new MedicalRecordHomePage();
        medicalRecordHomePage.setHomePageBasicInfo(new HomePageBasicInfo());
        medicalRecordHomePage.getHomePageBasicInfo().setBusinessKey(businessKey);
        medicalRecordHomePage.setPatientInfo(new PatientInfo());
        medicalRecordHomePage.setRegisterAdmission(new RegisterAdmission());
        medicalRecordHomePage.setRegisterDischarge(new RegisterDischarge());
        medicalRecordHomePage.setDiagnosisClinic(new DiagnosisClinic());
        medicalRecordHomePage.setDiagnosisExternalReason(new DiagnosisExternalReason());
        medicalRecordHomePage.setDiagnosisPathology(new DiagnosisPathology());
        List<DoctorInCharge> doctorInChargeList = medicalRecordHomePage.getDoctorInChargeList();
        for (int i = 0; i < 8; i++) {
            DoctorInCharge doctorInCharge = new DoctorInCharge();
            doctorInCharge.setMedicalRecordHomePage(medicalRecordHomePage);
            doctorInChargeList.add(doctorInCharge);
        }
        medicalRecordHomePage.setQualityControlInfo(new QualityControlInfo());
        medicalRecordHomePage.setComaInfo(new ComaInfo());
        ExpenseInvoice expenseInvoice = new ExpenseInvoice();
        List<ExpenseItem> expenseItems = expenseInvoice.getExpenseItems();
        for (int i = 0; i < 28; i++) {
            ExpenseItem item = new ExpenseItem();
            item.setExpenseInvoice(expenseInvoice);
            expenseItems.add(item);
        }
        medicalRecordHomePage.setExpenseInvoice(expenseInvoice);
        return medicalRecordHomePage;
    }

    @Autowired
    public void setMedicalRecordHomePageDao(MedicalRecordHomePageDao medicalRecordHomePageDao) {
        this.medicalRecordHomePageDao = medicalRecordHomePageDao;
    }

    private MedicalRecordHomePageDao medicalRecordHomePageDao;

    protected MedicalRecordHomePageConvertor medicalRecordHomePageConvertor = new MedicalRecordHomePageConvertor();
}
