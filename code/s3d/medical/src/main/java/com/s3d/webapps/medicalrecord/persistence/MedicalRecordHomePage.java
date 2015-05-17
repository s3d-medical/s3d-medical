package com.s3d.webapps.medicalrecord.persistence;


import com.s3d.webapps.medicalrecord.persistence.patient.PatientInfo;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisPathology;
import com.s3d.webapps.medicalrecord.persistence.expense.ExpenseInvoice;
import com.s3d.webapps.medicalrecord.persistence.inOrout.RegisterAdmission;
import com.s3d.webapps.medicalrecord.persistence.inOrout.RegisterDischarge;
import com.s3d.webapps.medicalrecord.persistence.quality.QualityControlInfo;

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
public class MedicalRecordHomePage extends AbstractGeneralProperties {

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "health_card_no")
    private String healthCardNo;

    @Column(name = "seq_no")
    private Integer seqNo;

    @Column(name = "if_drug_allergy")
    private Integer ifDrugAllergy;

    @Column(name = "if_autopsy")
    private Boolean ifAutopsy;

    @Column(name = "blood_type")
    private Integer bloodType;

    @Column(name = "is_rh")
    private Integer isRH;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_info_id", referencedColumnName = "id")
    private PatientInfo patientInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "register_admission_id")
    private RegisterAdmission registerAdmission;

    // department changes
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_change_id")
    public DepartChange departChange;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "register_discharge_id")
    private RegisterDischarge registerDischarge;

    // ----------------- diagnosis ---------------
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "diagnosis_clinic_id")
    private DiagnosisClinic diagnosisClinic;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalRecordHomePage")
    @JoinColumn(name = "medical_record_home_page_id")
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
    private List<PersonInCharge> personsInChargeList = new ArrayList<PersonInCharge>();

    // --------------quality -----------------
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quality_control_info_id")
    public QualityControlInfo qualityControl;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "expense_invoice")
    public ExpenseInvoice expenseInvoice;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "medicalRecordHomePage")
    @JoinColumn(name="medical_record_home_page_id")
    public List<Operation> operationList = new ArrayList<Operation>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "comma_info_id")
    public ComaInfo comaInfo;

    public MedicalRecordHomePage() {

    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public Integer getIfDrugAllergy() {
        return ifDrugAllergy;
    }

    public void setIfDrugAllergy(Integer ifDrugAllergy) {
        this.ifDrugAllergy = ifDrugAllergy;
    }

    public Boolean getIfAutopsy() {
        return ifAutopsy;
    }

    public void setIfAutopsy(Boolean ifAutopsy) {
        this.ifAutopsy = ifAutopsy;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getIsRH() {
        return isRH;
    }

    public void setIsRH(Integer isRH) {
        this.isRH = isRH;
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

    public DepartChange getDepartChange() {
        return departChange;
    }

    public void setDepartChange(DepartChange departChange) {
        this.departChange = departChange;
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

    public List<PersonInCharge> getPersonsInChargeList() {
        return personsInChargeList;
    }

    public void setPersonsInChargeList(List<PersonInCharge> personsInChargeList) {
        this.personsInChargeList = personsInChargeList;
    }

    public QualityControlInfo getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControlInfo qualityControl) {
        this.qualityControl = qualityControl;
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