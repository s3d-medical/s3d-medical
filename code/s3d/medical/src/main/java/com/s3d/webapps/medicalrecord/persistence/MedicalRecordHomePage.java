package com.s3d.webapps.medicalrecord.persistence;


import com.s3d.webapps.medicalrecord.persistence.HomePageBasicInfo.HomePageBasicInfo;
import com.s3d.webapps.medicalrecord.persistence.operation.Operation;
import com.s3d.webapps.medicalrecord.persistence.coma.ComaInfo;
import com.s3d.webapps.medicalrecord.persistence.doctor.DoctorInCharge;
import com.s3d.webapps.medicalrecord.persistence.patient.PatientInfo;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisPathology;
import com.s3d.webapps.medicalrecord.persistence.expense.ExpenseInvoice;
import com.s3d.webapps.medicalrecord.persistence.entryexit.RegisterAdmission;
import com.s3d.webapps.medicalrecord.persistence.entryexit.RegisterDischarge;
import com.s3d.webapps.medicalrecord.persistence.quality.QualityControlInfo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @created 14-����-2015 21:11:54
 */
@Entity
@Table(name = "mr_medical_record_home_page")
public class MedicalRecordHomePage {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name="business_key")
    private String businessKey;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "home_page_basic_info_id", referencedColumnName = "id")
    private HomePageBasicInfo homePageBasicInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_info_id", referencedColumnName = "id")
    private PatientInfo patientInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "register_admission_id")
    private RegisterAdmission registerAdmission;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "register_discharge_id")
    private RegisterDischarge registerDischarge;

    // ----------------- diagnosis ---------------
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_clinic_id")
    private DiagnosisClinic diagnosisClinic;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalRecordHomePage")
    @JoinColumn(name = "medical_record_home_page_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<DiagnosisDischarge> diagnosisDischargeList = new ArrayList<DiagnosisDischarge>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_external_reason_id")
    public DiagnosisExternalReason diagnosisExternalReason;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_pathology_id")
    public DiagnosisPathology diagnosisPathology;

    // -------- persons in charge.-------------
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalRecordHomePage")
    @JoinColumn(name = "medical_record_home_page_id")
    @Fetch(FetchMode.SUBSELECT)
    private List<DoctorInCharge> doctorInChargeList = new ArrayList<DoctorInCharge>();

    // --------------quality -----------------
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quality_control_info_id")
    public QualityControlInfo qualityControlInfo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalRecordHomePage")
    @JoinColumn(name="medical_record_home_page_id")
    @Fetch(FetchMode.SUBSELECT)
    public List<Operation> operationList = new ArrayList<Operation>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "comma_info_id")
    public ComaInfo comaInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "expense_invoice_id")
    public ExpenseInvoice expenseInvoice;

    public MedicalRecordHomePage() {

    }

    ///////////////////////////////////////////////////////setter, getter //////////////////////////

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public HomePageBasicInfo getHomePageBasicInfo() {
        return homePageBasicInfo;
    }

    public void setHomePageBasicInfo(HomePageBasicInfo homePageBasicInfo) {
        this.homePageBasicInfo = homePageBasicInfo;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public RegisterAdmission getRegisterAdmission() {
        return registerAdmission;
    }

    public void setRegisterAdmission(RegisterAdmission registerAdmission) {
        this.registerAdmission = registerAdmission;
    }

    public RegisterDischarge getRegisterDischarge() {
        return registerDischarge;
    }

    public void setRegisterDischarge(RegisterDischarge registerDischarge) {
        this.registerDischarge = registerDischarge;
    }

    public DiagnosisClinic getDiagnosisClinic() {
        return diagnosisClinic;
    }

    public void setDiagnosisClinic(DiagnosisClinic diagnosisClinic) {
        this.diagnosisClinic = diagnosisClinic;
    }

    public List<DiagnosisDischarge> getDiagnosisDischargeList() {
        return diagnosisDischargeList;
    }

    public void setDiagnosisDischargeList(List<DiagnosisDischarge> diagnosisDischargeList) {
        this.diagnosisDischargeList = diagnosisDischargeList;
    }

    public DiagnosisExternalReason getDiagnosisExternalReason() {
        return diagnosisExternalReason;
    }

    public void setDiagnosisExternalReason(DiagnosisExternalReason diagnosisExternalReason) {
        this.diagnosisExternalReason = diagnosisExternalReason;
    }

    public DiagnosisPathology getDiagnosisPathology() {
        return diagnosisPathology;
    }

    public void setDiagnosisPathology(DiagnosisPathology diagnosisPathology) {
        this.diagnosisPathology = diagnosisPathology;
    }

    public List<DoctorInCharge> getDoctorInChargeList() {
        return doctorInChargeList;
    }

    public void setDoctorInChargeList(List<DoctorInCharge> doctorInChargeList) {
        this.doctorInChargeList = doctorInChargeList;
    }

    public QualityControlInfo getQualityControlInfo() {
        return qualityControlInfo;
    }

    public void setQualityControlInfo(QualityControlInfo qualityControlInfo) {
        this.qualityControlInfo = qualityControlInfo;
    }

    public ExpenseInvoice getExpenseInvoice() {
        return expenseInvoice;
    }

    public void setExpenseInvoice(ExpenseInvoice expenseInvoice) {
        this.expenseInvoice = expenseInvoice;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public ComaInfo getComaInfo() {
        return comaInfo;
    }

    public void setComaInfo(ComaInfo comaInfo) {
        this.comaInfo = comaInfo;
    }


}