package com.s3d.webapps.medicalrecord.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
public class MedicalRecordHomePageVO {

    HomePageBasicInfoVO homePageBasicInfoVO = new HomePageBasicInfoVO();

    // patient info   -- part
    private PatientInfoVO patientInfoVO = new PatientInfoVO();

    // enter or leave hospital. -- part
    private EntryExitRecordVO entryExitRecordVO = new EntryExitRecordVO();

    // diagnosis -- part
    private DiagnosisRecordVO diagnosisRecordVO = new DiagnosisRecordVO();

    // related doctors. -- part
    private DoctorAndQualityRecordVO doctorAndQualityRecordVO = new DoctorAndQualityRecordVO();

    // operations.
    private List<OperationHistoryVO> operationHistory = new ArrayList<OperationHistoryVO>();

    // comma -- part
    ComaRecordVO comaRecordVO = new ComaRecordVO();

    // expense -- part
    private ExpenseRecordVO expenseRecordVO = new ExpenseRecordVO();


    // read and fill data or home page vo.

    public PatientInfoVO readPatientInfoVO() {
        return patientInfoVO;
    }

    public void fillInPatientInfoVO(PatientInfoVO patientInfoVO) {
        this.patientInfoVO = patientInfoVO;
    }

    public EntryExitRecordVO readEntryExitRecordVO() {
        return entryExitRecordVO;
    }

    public void fillInEntryExitRecordVO(EntryExitRecordVO entryExitRecordVO) {
        this.entryExitRecordVO = entryExitRecordVO;
    }

    public DiagnosisRecordVO readDiagnosisRecordVO() {
        return diagnosisRecordVO;
    }

    public void fillInDiagnosisRecordVO(DiagnosisRecordVO diagnosisRecordVO) {
        this.diagnosisRecordVO = diagnosisRecordVO;
    }

    public DoctorAndQualityRecordVO readDoctorRecordVO() {
        return doctorAndQualityRecordVO;
    }

    public void fillInDoctorRecordVO(DoctorAndQualityRecordVO doctorAndQualityRecordVO) {
        this.doctorAndQualityRecordVO = doctorAndQualityRecordVO;
    }

    public ComaRecordVO readComaRecordVO() {
        return comaRecordVO;
    }

    public void fillInComaRecordVO(ComaRecordVO comaRecordVO) {
        this.comaRecordVO = comaRecordVO;
    }

    public ExpenseRecordVO readExpenseRecordVO() {
        return expenseRecordVO;
    }

    public void fillInExpenseRecordVO(ExpenseRecordVO expenseRecordVO) {
        this.expenseRecordVO = expenseRecordVO;
    }

    public void fillHomePageBasicInfoVO(HomePageBasicInfoVO homePageBasicInfo){
        this.homePageBasicInfoVO = homePageBasicInfo;
    }
    public HomePageBasicInfoVO readHomePageBasicInfoVO(){
       return  this.homePageBasicInfoVO;
    }



   //-----------------------------------------setter getter ------------------------

    public String getBusinessKey() {
        return this.homePageBasicInfoVO.getBusinessKey();
    }

    public void setBusinessKey(String businessKey) {
        this.homePageBasicInfoVO.setBusinessKey( businessKey);
    }

    public void setMedicalAllergy(String medicalAllergy) {
        homePageBasicInfoVO.setMedicalAllergy(medicalAllergy);
    }

    public void setRh(String rh) {
        homePageBasicInfoVO.setRh(rh);
    }

    public Integer getHospitalizedTimes() {
        return homePageBasicInfoVO.getHospitalizedTimes();
    }

    public void setAllergicMedication(String allergicMedication) {
        homePageBasicInfoVO.setAllergicMedication(allergicMedication);
    }

    public String getRh() {
        return homePageBasicInfoVO.getRh();
    }

    public String getMedicalAllergy() {
        return homePageBasicInfoVO.getMedicalAllergy();
    }

    public String getBloodType() {
        return homePageBasicInfoVO.getBloodType();
    }

    public void setCaseNumber(String caseNumber) {
        homePageBasicInfoVO.setCaseNumber(caseNumber);
    }

    public void setHospitalizedTimes(Integer hospitalizedTimes) {
        homePageBasicInfoVO.setHospitalizedTimes(hospitalizedTimes);
    }

    public void setBloodType(String bloodType) {
        homePageBasicInfoVO.setBloodType(bloodType);
    }

    public String getAllergicMedication() {
        return homePageBasicInfoVO.getAllergicMedication();
    }

    public String getChangeDepartment() {
        return homePageBasicInfoVO.getChangeDepartment();
    }

    public void setAutopsy(String autopsy) {
        homePageBasicInfoVO.setAutopsy(autopsy);
    }

    public void setPayType(String payType) {
        homePageBasicInfoVO.setPayType(payType);
    }

    public String getHealthCard() {
        return homePageBasicInfoVO.getHealthCard();
    }

    public String getCaseNumber() {
        return homePageBasicInfoVO.getCaseNumber();
    }

    public String getAutopsy() {
        return homePageBasicInfoVO.getAutopsy();
    }

    public String getPayType() {
        return homePageBasicInfoVO.getPayType();
    }

    public void setChangeDepartment(String changeDepartment) {
        homePageBasicInfoVO.setChangeDepartment(changeDepartment);
    }

    public void setHealthCard(String healthCard) {
        homePageBasicInfoVO.setHealthCard(healthCard);
    }

    public String getName() {
        return patientInfoVO.getName();
    }

    public void setResidenceState(String residenceState) {
        patientInfoVO.setResidenceState(residenceState);
    }

    public void setBornDistrict(String bornDistrict) {
        patientInfoVO.setBornDistrict(bornDistrict);
    }

    public Integer getAge() {
        return patientInfoVO.getAge();
    }

    public void setWorkPlacePhone(String workPlacePhone) {
        patientInfoVO.setWorkPlacePhone(workPlacePhone);
    }

    public void setBabyBornWeight(Integer babyBornWeight) {
        patientInfoVO.setBabyBornWeight(babyBornWeight);
    }

    public void setJob(String job) {
        patientInfoVO.setJob(job);
    }

    public String getAddressDistrict() {
        return patientInfoVO.getAddressDistrict();
    }

    public void setBabyHospitalizedWeight(Integer babyHospitalizedWeight) {
        patientInfoVO.setBabyHospitalizedWeight(babyHospitalizedWeight);
    }

    public void setHometownState(String hometownState) {
        patientInfoVO.setHometownState(hometownState);
    }

    public Integer getBirthdayMonth() {
        return patientInfoVO.getBirthdayMonth();
    }

    public void setAddressCity(String addressCity) {
        patientInfoVO.setAddressCity(addressCity);
    }

    public String getHometownState() {
        return patientInfoVO.getHometownState();
    }

    public String getJob() {
        return patientInfoVO.getJob();
    }

    public String getResidenceCity() {
        return patientInfoVO.getResidenceCity();
    }

    public String getMarriage() {
        return patientInfoVO.getMarriage();
    }

    public void setRelationship(String relationship) {
        patientInfoVO.setRelationship(relationship);
    }

    public void setBornCity(String bornCity) {
        patientInfoVO.setBornCity(bornCity);
    }

    public void setSex(String sex) {
        patientInfoVO.setSex(sex);
    }

    public void setBabyAge(Integer babyAge) {
        patientInfoVO.setBabyAge(babyAge);
    }

    public String getAddressPhone() {
        return patientInfoVO.getAddressPhone();
    }

    public String getHometownCity() {
        return patientInfoVO.getHometownCity();
    }

    public void setAddressState(String addressState) {
        patientInfoVO.setAddressState(addressState);
    }

    public String getBornCity() {
        return patientInfoVO.getBornCity();
    }

    public void setMarriage(String marriage) {
        patientInfoVO.setMarriage(marriage);
    }

    public void setAddressDistrict(String addressDistrict) {
        patientInfoVO.setAddressDistrict(addressDistrict);
    }

    public String getSex() {
        return patientInfoVO.getSex();
    }

    public String getRelationship() {
        return patientInfoVO.getRelationship();
    }

    public void setAddressPostcode(String addressPostcode) {
        patientInfoVO.setAddressPostcode(addressPostcode);
    }

    public void setBirthdayYear(Integer birthdayYear) {
        patientInfoVO.setBirthdayYear(birthdayYear);
    }

    public Integer getBirthdayDay() {
        return patientInfoVO.getBirthdayDay();
    }

    public void setHometownCity(String hometownCity) {
        patientInfoVO.setHometownCity(hometownCity);
    }

    public String getResidenceDistrict() {
        return patientInfoVO.getResidenceDistrict();
    }

    public String getAddressPostcode() {
        return patientInfoVO.getAddressPostcode();
    }

    public String getContact() {
        return patientInfoVO.getContact();
    }

    public void setResidenceDistrict(String residenceDistrict) {
        patientInfoVO.setResidenceDistrict(residenceDistrict);
    }

    public void setWorkPlaceAddress(String workPlaceAddress) {
        patientInfoVO.setWorkPlaceAddress(workPlaceAddress);
    }

    public void setCountry(String country) {
        patientInfoVO.setCountry(country);
    }

    public String getWorkPlacePostcode() {
        return patientInfoVO.getWorkPlacePostcode();
    }

    public Integer getBabyHospitalizedWeight() {
        return patientInfoVO.getBabyHospitalizedWeight();
    }

    public Integer getBabyBornWeight() {
        return patientInfoVO.getBabyBornWeight();
    }

    public String getAddressState() {
        return patientInfoVO.getAddressState();
    }

    public String getContactPhone() {
        return patientInfoVO.getContactPhone();
    }

    public void setContact(String contact) {
        patientInfoVO.setContact(contact);
    }

    public String getBornDistrict() {
        return patientInfoVO.getBornDistrict();
    }

    public void setResidenceCity(String residenceCity) {
        patientInfoVO.setResidenceCity(residenceCity);
    }

    public void setBornState(String bornState) {
        patientInfoVO.setBornState(bornState);
    }

    public void setWorkPlacePostcode(String workPlacePostcode) {
        patientInfoVO.setWorkPlacePostcode(workPlacePostcode);
    }

    public void setBirthdayMonth(Integer birthdayMonth) {
        patientInfoVO.setBirthdayMonth(birthdayMonth);
    }

    public String getIdCard() {
        return patientInfoVO.getIdCard();
    }

    public void setResidencePostcode(String residencePostcode) {
        patientInfoVO.setResidencePostcode(residencePostcode);
    }

    public void setAge(Integer age) {
        patientInfoVO.setAge(age);
    }

    public void setIdCard(String idCard) {
        patientInfoVO.setIdCard(idCard);
    }

    public String getWorkPlaceAddress() {
        return patientInfoVO.getWorkPlaceAddress();
    }

    public String getAddressCity() {
        return patientInfoVO.getAddressCity();
    }

    public void setContactPhone(String contactPhone) {
        patientInfoVO.setContactPhone(contactPhone);
    }

    public void setNation(String nation) {
        patientInfoVO.setNation(nation);
    }

    public void setName(String name) {
        patientInfoVO.setName(name);
    }

    public Integer getBirthdayYear() {
        return patientInfoVO.getBirthdayYear();
    }

    public void setBirthdayDay(Integer birthdayDay) {
        patientInfoVO.setBirthdayDay(birthdayDay);
    }

    public String getCountry() {
        return patientInfoVO.getCountry();
    }

    public String getBornState() {
        return patientInfoVO.getBornState();
    }

    public void setContactAddress(String contactAddress) {
        patientInfoVO.setContactAddress(contactAddress);
    }

    public String getWorkPlacePhone() {
        return patientInfoVO.getWorkPlacePhone();
    }

    public Integer getBabyAge() {
        return patientInfoVO.getBabyAge();
    }

    public String getResidencePostcode() {
        return patientInfoVO.getResidencePostcode();
    }

    public String getContactAddress() {
        return patientInfoVO.getContactAddress();
    }

    public void setAddressPhone(String addressPhone) {
        patientInfoVO.setAddressPhone(addressPhone);
    }

    public String getResidenceState() {
        return patientInfoVO.getResidenceState();
    }

    public String getNation() {
        return patientInfoVO.getNation();
    }

    public String getInType() {
        return entryExitRecordVO.getInType();
    }

    public void setInSickroom(String inSickroom) {
        entryExitRecordVO.setInSickroom(inSickroom);
    }

    public void setInType(String inType) {
        entryExitRecordVO.setInType(inType);
    }

    public Integer getInDay() {
        return entryExitRecordVO.getInDay();
    }

    public void setOutYear(Integer outYear) {
        entryExitRecordVO.setOutYear(outYear);
    }

    public String getWillReturn() {
        return entryExitRecordVO.getWillReturn();
    }

    public void setInDepartment(String inDepartment) {
        entryExitRecordVO.setInDepartment(inDepartment);
    }

    public void setWillReturn(String willReturn) {
        entryExitRecordVO.setWillReturn(willReturn);
    }

    public Integer getOutYear() {
        return entryExitRecordVO.getOutYear();
    }

    public String getReturnPurpose() {
        return entryExitRecordVO.getReturnPurpose();
    }

    public void setInYear(Integer inYear) {
        entryExitRecordVO.setInYear(inYear);
    }

    public void setReturnPurpose(String returnPurpose) {
        entryExitRecordVO.setReturnPurpose(returnPurpose);
    }

    public void setInDay(Integer inDay) {
        entryExitRecordVO.setInDay(inDay);
    }

    public void setAcceptOrganization(String acceptOrganization) {
        entryExitRecordVO.setAcceptOrganization(acceptOrganization);
    }

    public String getOutDepartment() {
        return entryExitRecordVO.getOutDepartment();
    }

    public void setInMonth(Integer inMonth) {
        entryExitRecordVO.setInMonth(inMonth);
    }

    public Integer getInYear() {
        return entryExitRecordVO.getInYear();
    }

    public void setInTime(String inTime) {
        entryExitRecordVO.setInTime(inTime);
    }

    public String getInTime() {
        return entryExitRecordVO.getInTime();
    }

    public String getOutTime() {
        return entryExitRecordVO.getOutTime();
    }

    public void setOutTime(String outTime) {
        entryExitRecordVO.setOutTime(outTime);
    }

    public void setDaysInHospital(Integer daysInHospital) {
        entryExitRecordVO.setDaysInHospital(daysInHospital);
    }

    public String getInDepartment() {
        return entryExitRecordVO.getInDepartment();
    }

    public Integer getOutMonth() {
        return entryExitRecordVO.getOutMonth();
    }

    public String getOutType() {
        return entryExitRecordVO.getOutType();
    }

    public void setOutType(String outType) {
        entryExitRecordVO.setOutType(outType);
    }

    public Integer getInMonth() {
        return entryExitRecordVO.getInMonth();
    }

    public void setOutDepartment(String outDepartment) {
        entryExitRecordVO.setOutDepartment(outDepartment);
    }

    public String getInSickroom() {
        return entryExitRecordVO.getInSickroom();
    }

    public Integer getDaysInHospital() {
        return entryExitRecordVO.getDaysInHospital();
    }

    public void setOutMonth(Integer outMonth) {
        entryExitRecordVO.setOutMonth(outMonth);
    }

    public String getAcceptOrganization() {
        return entryExitRecordVO.getAcceptOrganization();
    }

    public void setOutSickroom(String outSickroom) {
        entryExitRecordVO.setOutSickroom(outSickroom);
    }

    public Integer getOutDay() {
        return entryExitRecordVO.getOutDay();
    }

    public String getOutSickroom() {
        return entryExitRecordVO.getOutSickroom();
    }

    public void setOutDay(Integer outDay) {
        entryExitRecordVO.setOutDay(outDay);
    }

    public String getOutpatientDiagnosis() {
        return diagnosisRecordVO.getOutpatientDiagnosis();
    }


    public void setDischargeDiagnosis(List<DischargeDiagnosisVO> dischargeDiagnosis) {
        diagnosisRecordVO.setDischargeDiagnosis(dischargeDiagnosis);
    }

    public void setOutSickCode(String outSickCode) {
        diagnosisRecordVO.setOutSickCode(outSickCode);
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        diagnosisRecordVO.setOutpatientDiagnosis(outpatientDiagnosis);
    }

    public void setOutCause(String outCause) {
        diagnosisRecordVO.setOutCause(outCause);
    }



    public String getOutCause() {
        return diagnosisRecordVO.getOutCause();
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        diagnosisRecordVO.setPathologyDiagnosis(pathologyDiagnosis);
    }

    public void setPathologySickCode(String pathologySickCode) {
        diagnosisRecordVO.setPathologySickCode(pathologySickCode);
    }
    public void setPathologyNumber(String pathologyNumber) {
        diagnosisRecordVO.setPathologyNumber(pathologyNumber);
    }

    public String getPathologyNumber() {
        return diagnosisRecordVO.getPathologyNumber();
    }

    public String getPathologySickCode() {
        return diagnosisRecordVO.getPathologySickCode();
    }

    public String getOutSickCode() {
        return diagnosisRecordVO.getOutSickCode();
    }
    public List<DischargeDiagnosisVO> getDischargeDiagnosis() {
        return diagnosisRecordVO.getDischargeDiagnosis();
    }

    public String getOutpatientSickCode() {
        return diagnosisRecordVO.getOutpatientSickCode();
    }

    public String getPathologyDiagnosis() {
        return diagnosisRecordVO.getPathologyDiagnosis();
    }

    public void setOutpatientSickCode(String outpatientSickCode) {
        diagnosisRecordVO.setOutpatientSickCode(outpatientSickCode);
    }
    public String getDirector() {
        return doctorAndQualityRecordVO.getDirector();
    }

    public void setQualityNurse(String qualityNurse) {
        doctorAndQualityRecordVO.setQualityNurse(qualityNurse);
    }

    public String getQualityDate() {
        return doctorAndQualityRecordVO.getQualityDate();
    }

    public void setQualityDoctor(String qualityDoctor) {
        doctorAndQualityRecordVO.setQualityDoctor(qualityDoctor);
    }

    public void setCaseQuality(String caseQuality) {
        doctorAndQualityRecordVO.setCaseQuality(caseQuality);
    }

    public void setDeputyDirector(String deputyDirector) {
        doctorAndQualityRecordVO.setDeputyDirector(deputyDirector);
    }

    public String getResidentDoctor() {
        return doctorAndQualityRecordVO.getResidentDoctor();
    }

    public void setIntern(String intern) {
        doctorAndQualityRecordVO.setIntern(intern);
    }

    public void setDirector(String director) {
        doctorAndQualityRecordVO.setDirector(director);
    }

    public String getCaseQuality() {
        return doctorAndQualityRecordVO.getCaseQuality();
    }

    public String getRefresherDoctor() {
        return doctorAndQualityRecordVO.getRefresherDoctor();
    }

    public void setCoder(String coder) {
        doctorAndQualityRecordVO.setCoder(coder);
    }

    public String getPrimaryNurse() {
        return doctorAndQualityRecordVO.getPrimaryNurse();
    }

    public String getCoder() {
        return doctorAndQualityRecordVO.getCoder();
    }

    public void setPrimaryNurse(String primaryNurse) {
        doctorAndQualityRecordVO.setPrimaryNurse(primaryNurse);
    }

    public void setRefresherDoctor(String refresherDoctor) {
        doctorAndQualityRecordVO.setRefresherDoctor(refresherDoctor);
    }

    public void setQualityDate(String qualityDate) {
        doctorAndQualityRecordVO.setQualityDate(qualityDate);
    }

    public String getQualityDoctor() {
        return doctorAndQualityRecordVO.getQualityDoctor();
    }

    public String getQualityNurse() {
        return doctorAndQualityRecordVO.getQualityNurse();
    }

    public String getIntern() {
        return doctorAndQualityRecordVO.getIntern();
    }

    public void setResidentDoctor(String residentDoctor) {
        doctorAndQualityRecordVO.setResidentDoctor(residentDoctor);
    }

    public void setAttendingDoctor(String attendingDoctor) {
        doctorAndQualityRecordVO.setAttendingDoctor(attendingDoctor);
    }

    public String getDeputyDirector() {
        return doctorAndQualityRecordVO.getDeputyDirector();
    }

    public String getAttendingDoctor() {
        return doctorAndQualityRecordVO.getAttendingDoctor();
    }

    public List<OperationHistoryVO> getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(List<OperationHistoryVO> operationHistory) {
        this.operationHistory = operationHistory;
    }

    public Integer getComaDayBeforeHospital() {
        return comaRecordVO.getComaDayBeforeHospital();
    }

    public void setComaHourAfterHospital(Integer comaHourAfterHospital) {
        comaRecordVO.setComaHourAfterHospital(comaHourAfterHospital);
    }

    public void setComaDayAfterHospital(Integer comaDayAfterHospital) {
        comaRecordVO.setComaDayAfterHospital(comaDayAfterHospital);
    }

    public Integer getComaHourBeforeHospital() {
        return comaRecordVO.getComaHourBeforeHospital();
    }

    public void setComaMinuteAfterHospital(Integer comaMinuteAfterHospital) {
        comaRecordVO.setComaMinuteAfterHospital(comaMinuteAfterHospital);
    }

    public Integer getComaDayAfterHospital() {
        return comaRecordVO.getComaDayAfterHospital();
    }

    public void setComaDayBeforeHospital(Integer comaDayBeforeHospital) {
        comaRecordVO.setComaDayBeforeHospital(comaDayBeforeHospital);
    }

    public Integer getComaMinuteBeforeHospital() {
        return comaRecordVO.getComaMinuteBeforeHospital();
    }

    public Integer getComaMinuteAfterHospital() {
        return comaRecordVO.getComaMinuteAfterHospital();
    }

    public Integer getComaHourAfterHospital() {
        return comaRecordVO.getComaHourAfterHospital();
    }

    public void setComaMinuteBeforeHospital(Integer comaMinuteBeforeHospital) {
        comaRecordVO.setComaMinuteBeforeHospital(comaMinuteBeforeHospital);
    }

    public void setComaHourBeforeHospital(Integer comaHourBeforeHospital) {
        comaRecordVO.setComaHourBeforeHospital(comaHourBeforeHospital);
    }

    public BigDecimal getExpenseTotal() {
        return expenseRecordVO.getExpenseTotal();
    }

    public BigDecimal getExpenseDiagnosisLab() {
        return expenseRecordVO.getExpenseDiagnosisLab();
    }

    public BigDecimal getExpenseCureNonOperation() {
        return expenseRecordVO.getExpenseCureNonOperation();
    }

    public void setExpenseBloodCellFactor(BigDecimal expenseBloodCellFactor) {
        expenseRecordVO.setExpenseBloodCellFactor(expenseBloodCellFactor);
    }

    public BigDecimal getExpenseNormalMedicalService() {
        return expenseRecordVO.getExpenseNormalMedicalService();
    }

    public void setExpenseCureNonOperation(BigDecimal expenseCureNonOperation) {
        expenseRecordVO.setExpenseCureNonOperation(expenseCureNonOperation);
    }

    public void setExpenseChineseMedicineCure(BigDecimal expenseChineseMedicineCure) {
        expenseRecordVO.setExpenseChineseMedicineCure(expenseChineseMedicineCure);
    }

    public BigDecimal getExpenseCureAnaesthesia() {
        return expenseRecordVO.getExpenseCureAnaesthesia();
    }

    public BigDecimal getExpenseConsumptionOperation() {
        return expenseRecordVO.getExpenseConsumptionOperation();
    }

    public BigDecimal getExpenseDiagnosisClinical() {
        return expenseRecordVO.getExpenseDiagnosisClinical();
    }

    public void setExpenseRecovery(BigDecimal expenseRecovery) {
        expenseRecordVO.setExpenseRecovery(expenseRecovery);
    }

    public BigDecimal getExpenseWesternMedicineMedication() {
        return expenseRecordVO.getExpenseWesternMedicineMedication();
    }

    public void setExpenseNormalMedicalService(BigDecimal expenseNormalMedicalService) {
        expenseRecordVO.setExpenseNormalMedicalService(expenseNormalMedicalService);
    }

    public void setExpenseBlood(BigDecimal expenseBlood) {
        expenseRecordVO.setExpenseBlood(expenseBlood);
    }

    public BigDecimal getExpenseBloodCellFactor() {
        return expenseRecordVO.getExpenseBloodCellFactor();
    }

    public BigDecimal getExpenseNormalOther() {
        return expenseRecordVO.getExpenseNormalOther();
    }

    public BigDecimal getExpenseBlood() {
        return expenseRecordVO.getExpenseBlood();
    }

    public void setExpenseOther(BigDecimal expenseOther) {
        expenseRecordVO.setExpenseOther(expenseOther);
    }

    public void setExpenseNormalNurse(BigDecimal expenseNormalNurse) {
        expenseRecordVO.setExpenseNormalNurse(expenseNormalNurse);
    }

    public BigDecimal getExpenseChineseMedicinePatentDrag() {
        return expenseRecordVO.getExpenseChineseMedicinePatentDrag();
    }

    public void setExpenseNormalCureOperating(BigDecimal expenseNormalCureOperating) {
        expenseRecordVO.setExpenseNormalCureOperating(expenseNormalCureOperating);
    }

    public BigDecimal getExpenseBloodAlbumin() {
        return expenseRecordVO.getExpenseBloodAlbumin();
    }

    public BigDecimal getExpenseNormalNurse() {
        return expenseRecordVO.getExpenseNormalNurse();
    }

    public BigDecimal getExpenseConsumptionCure() {
        return expenseRecordVO.getExpenseConsumptionCure();
    }

    public BigDecimal getExpenseRecovery() {
        return expenseRecordVO.getExpenseRecovery();
    }

    public void setExpenseWesternMedicineMedication(BigDecimal expenseWesternMedicineMedication) {
        expenseRecordVO.setExpenseWesternMedicineMedication(expenseWesternMedicineMedication);
    }

    public void setExpenseBloodAlbumin(BigDecimal expenseBloodAlbumin) {
        expenseRecordVO.setExpenseBloodAlbumin(expenseBloodAlbumin);
    }

    public void setExpensePersonal(BigDecimal expensePersonal) {
        expenseRecordVO.setExpensePersonal(expensePersonal);
    }

    public BigDecimal getExpenseChineseMedicineCure() {
        return expenseRecordVO.getExpenseChineseMedicineCure();
    }

    public void setExpenseConsumptionCure(BigDecimal expenseConsumptionCure) {
        expenseRecordVO.setExpenseConsumptionCure(expenseConsumptionCure);
    }

    public BigDecimal getExpenseDiagnosisPathology() {
        return expenseRecordVO.getExpenseDiagnosisPathology();
    }

    public BigDecimal getExpenseBloodGlobulin() {
        return expenseRecordVO.getExpenseBloodGlobulin();
    }

    public void setExpenseBloodCoagulationFactor(BigDecimal expenseBloodCoagulationFactor) {
        expenseRecordVO.setExpenseBloodCoagulationFactor(expenseBloodCoagulationFactor);
    }

    public void setExpenseCureClinicalPhysics(BigDecimal expenseCureClinicalPhysics) {
        expenseRecordVO.setExpenseCureClinicalPhysics(expenseCureClinicalPhysics);
    }

    public BigDecimal getExpenseWesternMedicineAntibiosisMedication() {
        return expenseRecordVO.getExpenseWesternMedicineAntibiosisMedication();
    }

    public BigDecimal getExpenseConsumptionExamine() {
        return expenseRecordVO.getExpenseConsumptionExamine();
    }

    public BigDecimal getExpensePersonal() {
        return expenseRecordVO.getExpensePersonal();
    }

    public BigDecimal getExpenseCureOperation() {
        return expenseRecordVO.getExpenseCureOperation();
    }

    public BigDecimal getExpenseNormalCureOperating() {
        return expenseRecordVO.getExpenseNormalCureOperating();
    }

    public void setExpenseConsumptionExamine(BigDecimal expenseConsumptionExamine) {
        expenseRecordVO.setExpenseConsumptionExamine(expenseConsumptionExamine);
    }

    public void setExpenseCureAnaesthesia(BigDecimal expenseCureAnaesthesia) {
        expenseRecordVO.setExpenseCureAnaesthesia(expenseCureAnaesthesia);
    }

    public void setExpenseChineseMedicinePatentDrag(BigDecimal expenseChineseMedicinePatentDrag) {
        expenseRecordVO.setExpenseChineseMedicinePatentDrag(expenseChineseMedicinePatentDrag);
    }

    public BigDecimal getExpenseChineseMedicineHerb() {
        return expenseRecordVO.getExpenseChineseMedicineHerb();
    }

    public void setExpenseDiagnosisImaging(BigDecimal expenseDiagnosisImaging) {
        expenseRecordVO.setExpenseDiagnosisImaging(expenseDiagnosisImaging);
    }

    public void setExpenseChineseMedicineHerb(BigDecimal expenseChineseMedicineHerb) {
        expenseRecordVO.setExpenseChineseMedicineHerb(expenseChineseMedicineHerb);
    }

    public void setExpenseWesternMedicineAntibiosisMedication(BigDecimal expenseWesternMedicineAntibiosisMedication) {
        expenseRecordVO.setExpenseWesternMedicineAntibiosisMedication(expenseWesternMedicineAntibiosisMedication);
    }

    public void setExpenseDiagnosisLab(BigDecimal expenseDiagnosisLab) {
        expenseRecordVO.setExpenseDiagnosisLab(expenseDiagnosisLab);
    }

    public void setExpenseDiagnosisPathology(BigDecimal expenseDiagnosisPathology) {
        expenseRecordVO.setExpenseDiagnosisPathology(expenseDiagnosisPathology);
    }

    public BigDecimal getExpenseBloodCoagulationFactor() {
        return expenseRecordVO.getExpenseBloodCoagulationFactor();
    }

    public void setExpenseConsumptionOperation(BigDecimal expenseConsumptionOperation) {
        expenseRecordVO.setExpenseConsumptionOperation(expenseConsumptionOperation);
    }

    public void setExpenseDiagnosisClinical(BigDecimal expenseDiagnosisClinical) {
        expenseRecordVO.setExpenseDiagnosisClinical(expenseDiagnosisClinical);
    }

    public BigDecimal getExpenseDiagnosisImaging() {
        return expenseRecordVO.getExpenseDiagnosisImaging();
    }

    public BigDecimal getExpenseCureOperationCure() {
        return expenseRecordVO.getExpenseCureOperationCure();
    }

    public BigDecimal getExpenseOther() {
        return expenseRecordVO.getExpenseOther();
    }

    public void setExpenseTotal(BigDecimal expenseTotal) {
        expenseRecordVO.setExpenseTotal(expenseTotal);
    }

    public void setExpenseCureOperation(BigDecimal expenseCureOperation) {
        expenseRecordVO.setExpenseCureOperation(expenseCureOperation);
    }

    public BigDecimal getExpenseCureClinicalPhysics() {
        return expenseRecordVO.getExpenseCureClinicalPhysics();
    }

    public void setExpenseNormalOther(BigDecimal expenseNormalOther) {
        expenseRecordVO.setExpenseNormalOther(expenseNormalOther);
    }

    public void setExpenseBloodGlobulin(BigDecimal expenseBloodGlobulin) {
        expenseRecordVO.setExpenseBloodGlobulin(expenseBloodGlobulin);
    }

    public void setExpenseCureOperationCure(BigDecimal expenseCureOperationCure) {
        expenseRecordVO.setExpenseCureOperationCure(expenseCureOperationCure);
    }

}
