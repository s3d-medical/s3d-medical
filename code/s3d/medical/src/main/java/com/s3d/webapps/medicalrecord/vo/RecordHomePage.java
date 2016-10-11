package com.s3d.webapps.medicalrecord.vo;

import com.s3d.webapps.record.entity.homepage.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
public class RecordHomePage extends com.s3d.webapps.record.entity.homepage.RecordHomePage {

    HomePageBasicInfo homePageBasicInfo = new HomePageBasicInfo();

    // patient info   -- part
    private PatientInfo patientInfo = new PatientInfo();

    // enter or leave hospital. -- part
    private EntryExitRecord entryExitRecord = new EntryExitRecord();

    // diagnosis -- part
    private DiagnosisRecord diagnosisRecord = new DiagnosisRecord();

    // related doctors. -- part
    private DoctorAndQualityRecord doctorAndQualityRecord = new DoctorAndQualityRecord();

    // operations.
    private List<OperationHistory> operationHistory = new ArrayList<OperationHistory>();

    // comma -- part
    private ComaRecord comaRecord = new ComaRecord();

    // expense -- part
    private ExpenseRecord expenseRecord = new ExpenseRecord();

    // read and fill data or home page vo.

    public RecordHomePage() {
    }

    public PatientInfo readPatientInfoVO() {
        return patientInfo;
    }

    public void fillInPatientInfoVO(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }

    public EntryExitRecord readEntryExitRecordVO() {
        return entryExitRecord;
    }

    public void fillInEntryExitRecordVO(EntryExitRecord entryExitRecord) {
        this.entryExitRecord = entryExitRecord;
    }

    public DiagnosisRecord readDiagnosisRecordVO() {
        return diagnosisRecord;
    }

    public void fillInDiagnosisRecordVO(DiagnosisRecord diagnosisRecord) {
        this.diagnosisRecord = diagnosisRecord;
    }

    public DoctorAndQualityRecord readDoctorRecordVO() {
        return doctorAndQualityRecord;
    }

    public void fillInDoctorRecordVO(DoctorAndQualityRecord doctorAndQualityRecord) {
        this.doctorAndQualityRecord = doctorAndQualityRecord;
    }

    public ComaRecord readComaRecordVO() {
        return comaRecord;
    }

    public void fillInComaRecordVO(ComaRecord comaRecord) {
        this.comaRecord = comaRecord;
    }

    public ExpenseRecord readExpenseRecordVO() {
        return expenseRecord;
    }

    public void fillInExpenseRecordVO(ExpenseRecord expenseRecord) {
        this.expenseRecord = expenseRecord;
    }

    public void fillHomePageBasicInfoVO(HomePageBasicInfo homePageBasicInfo){
        this.homePageBasicInfo = homePageBasicInfo;
    }
    public HomePageBasicInfo readHomePageBasicInfoVO(){
       return  this.homePageBasicInfo;
    }

   //-----------------------------------------setter getter ------------------------

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

    public EntryExitRecord getEntryExitRecord() {
        return entryExitRecord;
    }

    public void setEntryExitRecord(EntryExitRecord entryExitRecord) {
        this.entryExitRecord = entryExitRecord;
    }

    public DiagnosisRecord getDiagnosisRecord() {
        return diagnosisRecord;
    }

    public void setDiagnosisRecord(DiagnosisRecord diagnosisRecord) {
        this.diagnosisRecord = diagnosisRecord;
    }

    public DoctorAndQualityRecord getDoctorAndQualityRecord() {
        return doctorAndQualityRecord;
    }

    public void setDoctorAndQualityRecord(DoctorAndQualityRecord doctorAndQualityRecord) {
        this.doctorAndQualityRecord = doctorAndQualityRecord;
    }

    public List<OperationHistory> getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(List<OperationHistory> operationHistory) {
        this.operationHistory = operationHistory;
    }

    public ComaRecord getComaRecord() {
        return comaRecord;
    }

    public void setComaRecord(ComaRecord comaRecord) {
        this.comaRecord = comaRecord;
    }

    public ExpenseRecord getExpenseRecord() {
        return expenseRecord;
    }

    public void setExpenseRecord(ExpenseRecord expenseRecord) {
        this.expenseRecord = expenseRecord;
    }
}
