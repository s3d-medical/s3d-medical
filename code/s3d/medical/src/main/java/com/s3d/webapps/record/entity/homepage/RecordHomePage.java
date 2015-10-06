package com.s3d.webapps.record.entity.homepage;

import com.s3d.tech.mongo.OId;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
public class RecordHomePage implements Serializable {
    private OId _id = new OId();

    private String businessKey;
    /**
     * 首页基本信息
     */
    HomePageBasicInfo homePageBasicInfo = new HomePageBasicInfo();

    /**
     *   // patient info   -- part
     */
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

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public OId get_id() {
        return _id;
    }

    public void set_id(OId _id) {
        this._id = _id;
    }
}
