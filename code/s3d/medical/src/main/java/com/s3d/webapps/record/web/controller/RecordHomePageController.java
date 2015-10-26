package com.s3d.webapps.record.web.controller;

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
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.homepagebasic.HomePageBasicInfo;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient.PatientInfo;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.quality.QualityControlInfo;
import com.s3d.webapps.medicalrecord.vo.MedicalRecordHomePageVO;
import com.s3d.webapps.record.entity.homepage.RecordHomePage;
import com.s3d.webapps.record.service.RecordHomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 * @date 2015/5/16.
 */
@Controller
@RequestMapping("/medicalRecord")
public class RecordHomePageController {
    @RequestMapping(value = "/homepages/show/{seq}", method = RequestMethod.GET)
    public ModelAndView showPage(HttpServletRequest request, HttpServletResponse response, @PathVariable String seq) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("seq", seq);
        return modelAndView;
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

    /**
     * @return
     */
    @RequestMapping(value = "/homepages/{seq}", method = RequestMethod.GET)
    public Model getMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String seq) {
        try {
            RecordHomePage homePage = this.recordHomePageService.getWithEmptyOne(seq);
            model.addAttribute("data", homePage);
            return model;
        } catch (Exception ex) {
            logger.error("Failed to get MedicalRecordHomePage", ex);
        }
        model.addAttribute("data", "");
        return model;
    }

    @RequestMapping(value = "/homepages", method = RequestMethod.POST)
    public Model saveMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody RecordHomePage recordHomePage) {
        // do something.
        try {
            if (recordHomePage != null) {
                this.recordHomePageService.insertOrReplace(recordHomePage);
                model.addAttribute("result", "ok");
                return model;
            }
        } catch (Exception ex) {
            logger.error("Failed to save RecordHomePage", ex);
        }
        model.addAttribute("result", "fail");
        return model;
    }

    @Resource
    public void setRecordHomePageService(RecordHomePageService recordHomePageService) {
        this.recordHomePageService = recordHomePageService;
    }

    private RecordHomePageService recordHomePageService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
