package com.s3d.webapps.record.entity.homepage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
public class RecordHomePage {

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

    public String getBusinessKey() {
        return this.homePageBasicInfo.getBusinessKey();
    }

    public void setBusinessKey(String businessKey) {
        this.homePageBasicInfo.setBusinessKey( businessKey);
    }

    public void setMedicalAllergy(String medicalAllergy) {
        homePageBasicInfo.setMedicalAllergy(medicalAllergy);
    }

    public void setRh(String rh) {
        homePageBasicInfo.setRh(rh);
    }

    public Integer getHospitalizedTimes() {
        return homePageBasicInfo.getHospitalizedTimes();
    }

    public void setAllergicMedication(String allergicMedication) {
        homePageBasicInfo.setAllergicMedication(allergicMedication);
    }

    public String getRh() {
        return homePageBasicInfo.getRh();
    }

    public String getMedicalAllergy() {
        return homePageBasicInfo.getMedicalAllergy();
    }

    public String getBloodType() {
        return homePageBasicInfo.getBloodType();
    }

    public void setTrackNo(String caseNumber) {
        homePageBasicInfo.setTrackNo(caseNumber);
    }

    public void setHospitalizedTimes(Integer hospitalizedTimes) {
        homePageBasicInfo.setHospitalizedTimes(hospitalizedTimes);
    }

    public void setBloodType(String bloodType) {
        homePageBasicInfo.setBloodType(bloodType);
    }

    public String getAllergicMedication() {
        return homePageBasicInfo.getAllergicMedication();
    }

    public String getChangeDepartment() {
        return homePageBasicInfo.getChangeDepartment();
    }

    public void setAutopsy(String autopsy) {
        homePageBasicInfo.setAutopsy(autopsy);
    }

    public void setPayType(String payType) {
        homePageBasicInfo.setPayType(payType);
    }

    public String getHealthCard() {
        return homePageBasicInfo.getHealthCard();
    }

    public String getTrackNo() {
        return homePageBasicInfo.getTrackNo();
    }

    public String getAutopsy() {
        return homePageBasicInfo.getAutopsy();
    }

    public String getPayType() {
        return homePageBasicInfo.getPayType();
    }

    public void setChangeDepartment(String changeDepartment) {
        homePageBasicInfo.setChangeDepartment(changeDepartment);
    }

    public void setHealthCard(String healthCard) {
        homePageBasicInfo.setHealthCard(healthCard);
    }

    public String getName() {
        return patientInfo.getName();
    }

    public void setResidenceState(String residenceState) {
        patientInfo.setResidenceState(residenceState);
    }

    public void setBornDistrict(String bornDistrict) {
        patientInfo.setBornDistrict(bornDistrict);
    }

    public Integer getAge() {
        return patientInfo.getAge();
    }

    public void setWorkPlacePhone(String workPlacePhone) {
        patientInfo.setWorkPlacePhone(workPlacePhone);
    }

    public void setBabyBornWeight(Integer babyBornWeight) {
        patientInfo.setBabyBornWeight(babyBornWeight);
    }

    public void setJob(String job) {
        patientInfo.setJob(job);
    }

    public String getAddressDistrict() {
        return patientInfo.getAddressDistrict();
    }

    public void setAddressDistrict(String addressDistrict) {
        patientInfo.setAddressDistrict(addressDistrict);
    }

    public void setBabyHospitalizedWeight(Integer babyHospitalizedWeight) {
        patientInfo.setBabyHospitalizedWeight(babyHospitalizedWeight);
    }

    public void setHometownState(String hometownState) {
        patientInfo.setHometownState(hometownState);
    }

    public Integer getBirthdayMonth() {
        return patientInfo.getBirthdayMonth();
    }

    public void setAddressCity(String addressCity) {
        patientInfo.setAddressCity(addressCity);
    }

    public String getHometownState() {
        return patientInfo.getHometownState();
    }

    public String getJob() {
        return patientInfo.getJob();
    }

    public String getResidenceCity() {
        return patientInfo.getResidenceCity();
    }

    public String getMarriage() {
        return patientInfo.getMarriage();
    }

    public void setRelationship(String relationship) {
        patientInfo.setRelationship(relationship);
    }

    public void setBornCity(String bornCity) {
        patientInfo.setBornCity(bornCity);
    }

    public void setSex(String sex) {
        patientInfo.setSex(sex);
    }

    public void setBabyAge(Integer babyAge) {
        patientInfo.setBabyAge(babyAge);
    }

    public String getAddressPhone() {
        return patientInfo.getAddressPhone();
    }

    public String getHometownCity() {
        return patientInfo.getHometownCity();
    }

    public void setAddressState(String addressState) {
        patientInfo.setAddressState(addressState);
    }

    public String getBornCity() {
        return patientInfo.getBornCity();
    }

    public void setMarriage(String marriage) {
        patientInfo.setMarriage(marriage);
    }

    public String getSex() {
        return patientInfo.getSex();
    }

    public String getRelationship() {
        return patientInfo.getRelationship();
    }

    public void setAddressPostcode(String addressPostcode) {
        patientInfo.setAddressPostcode(addressPostcode);
    }

    public void setBirthdayYear(Integer birthdayYear) {
        patientInfo.setBirthdayYear(birthdayYear);
    }

    public Integer getBirthdayDay() {
        return patientInfo.getBirthdayDay();
    }

    public void setHometownCity(String hometownCity) {
        patientInfo.setHometownCity(hometownCity);
    }

    public String getResidenceDistrict() {
        return patientInfo.getResidenceDistrict();
    }

    public String getAddressPostcode() {
        return patientInfo.getAddressPostcode();
    }

    public String getContact() {
        return patientInfo.getContact();
    }

    public void setResidenceDistrict(String residenceDistrict) {
        patientInfo.setResidenceDistrict(residenceDistrict);
    }

    public void setWorkPlaceAddress(String workPlaceAddress) {
        patientInfo.setWorkPlaceAddress(workPlaceAddress);
    }

    public void setCountry(String country) {
        patientInfo.setCountry(country);
    }

    public String getWorkPlacePostcode() {
        return patientInfo.getWorkPlacePostcode();
    }

    public Integer getBabyHospitalizedWeight() {
        return patientInfo.getBabyHospitalizedWeight();
    }

    public Integer getBabyBornWeight() {
        return patientInfo.getBabyBornWeight();
    }

    public String getAddressState() {
        return patientInfo.getAddressState();
    }

    public String getContactPhone() {
        return patientInfo.getContactPhone();
    }

    public void setContact(String contact) {
        patientInfo.setContact(contact);
    }

    public String getBornDistrict() {
        return patientInfo.getBornDistrict();
    }

    public void setResidenceCity(String residenceCity) {
        patientInfo.setResidenceCity(residenceCity);
    }

    public void setBornState(String bornState) {
        patientInfo.setBornState(bornState);
    }

    public void setWorkPlacePostcode(String workPlacePostcode) {
        patientInfo.setWorkPlacePostcode(workPlacePostcode);
    }

    public void setBirthdayMonth(Integer birthdayMonth) {
        patientInfo.setBirthdayMonth(birthdayMonth);
    }

    public String getIdCard() {
        return patientInfo.getIdCard();
    }

    public void setResidencePostcode(String residencePostcode) {
        patientInfo.setResidencePostcode(residencePostcode);
    }

    public void setAge(Integer age) {
        patientInfo.setAge(age);
    }

    public void setIdCard(String idCard) {
        patientInfo.setIdCard(idCard);
    }

    public String getWorkPlaceAddress() {
        return patientInfo.getWorkPlaceAddress();
    }

    public String getAddressCity() {
        return patientInfo.getAddressCity();
    }

    public void setContactPhone(String contactPhone) {
        patientInfo.setContactPhone(contactPhone);
    }

    public void setNation(String nation) {
        patientInfo.setNation(nation);
    }

    public void setName(String name) {
        patientInfo.setName(name);
    }

    public Integer getBirthdayYear() {
        return patientInfo.getBirthdayYear();
    }

    public void setBirthdayDay(Integer birthdayDay) {
        patientInfo.setBirthdayDay(birthdayDay);
    }

    public String getCountry() {
        return patientInfo.getCountry();
    }

    public String getBornState() {
        return patientInfo.getBornState();
    }

    public void setContactAddress(String contactAddress) {
        patientInfo.setContactAddress(contactAddress);
    }

    public String getWorkPlacePhone() {
        return patientInfo.getWorkPlacePhone();
    }

    public Integer getBabyAge() {
        return patientInfo.getBabyAge();
    }

    public String getResidencePostcode() {
        return patientInfo.getResidencePostcode();
    }

    public String getContactAddress() {
        return patientInfo.getContactAddress();
    }

    public void setAddressPhone(String addressPhone) {
        patientInfo.setAddressPhone(addressPhone);
    }

    public String getResidenceState() {
        return patientInfo.getResidenceState();
    }

    public String getNation() {
        return patientInfo.getNation();
    }

    public String getInType() {
        return entryExitRecord.getInType();
    }

    public void setInSickroom(String inSickroom) {
        entryExitRecord.setInSickroom(inSickroom);
    }

    public void setInType(String inType) {
        entryExitRecord.setInType(inType);
    }

    public Integer getInDay() {
        return entryExitRecord.getInDay();
    }

    public void setOutYear(Integer outYear) {
        entryExitRecord.setOutYear(outYear);
    }

    public String getWillReturn() {
        return entryExitRecord.getWillReturn();
    }

    public void setInDepartment(String inDepartment) {
        entryExitRecord.setInDepartment(inDepartment);
    }

    public void setWillReturn(String willReturn) {
        entryExitRecord.setWillReturn(willReturn);
    }

    public Integer getOutYear() {
        return entryExitRecord.getOutYear();
    }

    public String getReturnPurpose() {
        return entryExitRecord.getReturnPurpose();
    }

    public void setInYear(Integer inYear) {
        entryExitRecord.setInYear(inYear);
    }

    public void setReturnPurpose(String returnPurpose) {
        entryExitRecord.setReturnPurpose(returnPurpose);
    }

    public String getInHour() {
        return entryExitRecord.getInHour();
    }

    public void setInHour(String inHour) {
        entryExitRecord.setInHour(inHour);
    }

    public String getOutHour() {
        return entryExitRecord.getOutHour();
    }

    public void setOutHour(String outHour) {
        entryExitRecord.setOutHour(outHour);
    }

    public void setInDay(Integer inDay) {
        entryExitRecord.setInDay(inDay);
    }

    public void setAcceptOrganization(String acceptOrganization) {
        entryExitRecord.setAcceptOrganization(acceptOrganization);
    }

    public String getOutDepartment() {
        return entryExitRecord.getOutDepartment();
    }

    public void setInMonth(Integer inMonth) {
        entryExitRecord.setInMonth(inMonth);
    }

    public Integer getInYear() {
        return entryExitRecord.getInYear();
    }

    public void setDaysInHospital(Integer daysInHospital) {
        entryExitRecord.setDaysInHospital(daysInHospital);
    }

    public String getInDepartment() {
        return entryExitRecord.getInDepartment();
    }

    public Integer getOutMonth() {
        return entryExitRecord.getOutMonth();
    }

    public String getOutType() {
        return entryExitRecord.getOutType();
    }

    public void setOutType(String outType) {
        entryExitRecord.setOutType(outType);
    }

    public Integer getInMonth() {
        return entryExitRecord.getInMonth();
    }

    public void setOutDepartment(String outDepartment) {
        entryExitRecord.setOutDepartment(outDepartment);
    }

    public String getInSickroom() {
        return entryExitRecord.getInSickroom();
    }

    public Integer getDaysInHospital() {
        return entryExitRecord.getDaysInHospital();
    }

    public void setOutMonth(Integer outMonth) {
        entryExitRecord.setOutMonth(outMonth);
    }

    public String getAcceptOrganization() {
        return entryExitRecord.getAcceptOrganization();
    }

    public void setOutSickroom(String outSickroom) {
        entryExitRecord.setOutSickroom(outSickroom);
    }

    public Integer getOutDay() {
        return entryExitRecord.getOutDay();
    }

    public String getOutSickroom() {
        return entryExitRecord.getOutSickroom();
    }

    public void setOutDay(Integer outDay) {
        entryExitRecord.setOutDay(outDay);
    }

    public String getOutpatientDiagnosis() {
        return diagnosisRecord.getOutpatientDiagnosis();
    }


    public void setDischargeDiagnosis(List<DischargeDiagnosis> dischargeDiagnosis) {
        diagnosisRecord.setDischargeDiagnosis(dischargeDiagnosis);
    }

    public void setOutSickCodes(List<String> outSickCodes) {
        diagnosisRecord.setOutSickCodes(outSickCodes);
    }

    public List<String> getOutSickCodes() {
        return diagnosisRecord.getOutSickCodes();
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        diagnosisRecord.setOutpatientDiagnosis(outpatientDiagnosis);
    }

    public void setOutCause(String outCause) {
        diagnosisRecord.setOutCause(outCause);
    }

    public String getOutCause() {
        return diagnosisRecord.getOutCause();
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        diagnosisRecord.setPathologyDiagnosis(pathologyDiagnosis);
    }

    public List<String> getPathologySickCodes() {
        return diagnosisRecord.getPathologySickCodes();
    }

    public void setPathologySickCodes(List<String> pathologySickCodes) {
        diagnosisRecord.setPathologySickCodes(pathologySickCodes);
    }
    public void setPathologyNumber(String pathologyNumber) {
        diagnosisRecord.setPathologyNumber(pathologyNumber);
    }

    public String getPathologyNumber() {
        return diagnosisRecord.getPathologyNumber();
    }

    public List<DischargeDiagnosis> getDischargeDiagnosis() {
        return diagnosisRecord.getDischargeDiagnosis();
    }

    public String getPathologyDiagnosis() {
        return diagnosisRecord.getPathologyDiagnosis();
    }

    public List<String> getOutpatientSickCodes() {
        return diagnosisRecord.getOutpatientSickCodes();
    }

    public void setOutpatientSickCodes(List<String> outpatientSickCodes) {
        diagnosisRecord.setOutpatientSickCodes(outpatientSickCodes);
    }
    public String getDirector() {
        return doctorAndQualityRecord.getDirector();
    }

    public void setQualityNurse(String qualityNurse) {
        doctorAndQualityRecord.setQualityNurse(qualityNurse);
    }

    public Integer getQualityMonth() {
        return doctorAndQualityRecord.getQualityMonth();
    }

    public Integer getQualityYear() {
        return doctorAndQualityRecord.getQualityYear();
    }

    public void setQualityDay(Integer qualityDay) {
        doctorAndQualityRecord.setQualityDay(qualityDay);
    }

    public void setQualityYear(Integer qualityYear) {
        doctorAndQualityRecord.setQualityYear(qualityYear);
    }

    public Integer getQualityDay() {
        return doctorAndQualityRecord.getQualityDay();
    }

    public void setQualityMonth(Integer qualityMonth) {
        doctorAndQualityRecord.setQualityMonth(qualityMonth);
    }

    public void setQualityDoctor(String qualityDoctor) {
        doctorAndQualityRecord.setQualityDoctor(qualityDoctor);
    }

    public void setCaseQuality(String caseQuality) {
        doctorAndQualityRecord.setCaseQuality(caseQuality);
    }

    public void setDeputyDirector(String deputyDirector) {
        doctorAndQualityRecord.setDeputyDirector(deputyDirector);
    }

    public String getResidentDoctor() {
        return doctorAndQualityRecord.getResidentDoctor();
    }

    public void setIntern(String intern) {
        doctorAndQualityRecord.setIntern(intern);
    }

    public void setDirector(String director) {
        doctorAndQualityRecord.setDirector(director);
    }

    public String getCaseQuality() {
        return doctorAndQualityRecord.getCaseQuality();
    }

    public String getRefresherDoctor() {
        return doctorAndQualityRecord.getRefresherDoctor();
    }

    public void setCoder(String coder) {
        doctorAndQualityRecord.setCoder(coder);
    }

    public String getPrimaryNurse() {
        return doctorAndQualityRecord.getPrimaryNurse();
    }

    public String getCoder() {
        return doctorAndQualityRecord.getCoder();
    }

    public void setPrimaryNurse(String primaryNurse) {
        doctorAndQualityRecord.setPrimaryNurse(primaryNurse);
    }

    public void setRefresherDoctor(String refresherDoctor) {
        doctorAndQualityRecord.setRefresherDoctor(refresherDoctor);
    }

    public String getQualityDoctor() {
        return doctorAndQualityRecord.getQualityDoctor();
    }

    public String getQualityNurse() {
        return doctorAndQualityRecord.getQualityNurse();
    }

    public String getIntern() {
        return doctorAndQualityRecord.getIntern();
    }

    public void setResidentDoctor(String residentDoctor) {
        doctorAndQualityRecord.setResidentDoctor(residentDoctor);
    }

    public void setAttendingDoctor(String attendingDoctor) {
        doctorAndQualityRecord.setAttendingDoctor(attendingDoctor);
    }

    public String getDeputyDirector() {
        return doctorAndQualityRecord.getDeputyDirector();
    }

    public String getAttendingDoctor() {
        return doctorAndQualityRecord.getAttendingDoctor();
    }

    public List<OperationHistory> getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(List<OperationHistory> operationHistory) {
        this.operationHistory = operationHistory;
    }

    public Integer getComaDayBeforeHospital() {
        return comaRecord.getComaDayBeforeHospital();
    }

    public void setComaHourAfterHospital(Integer comaHourAfterHospital) {
        comaRecord.setComaHourAfterHospital(comaHourAfterHospital);
    }

    public void setComaDayAfterHospital(Integer comaDayAfterHospital) {
        comaRecord.setComaDayAfterHospital(comaDayAfterHospital);
    }

    public Integer getComaHourBeforeHospital() {
        return comaRecord.getComaHourBeforeHospital();
    }

    public void setComaMinuteAfterHospital(Integer comaMinuteAfterHospital) {
        comaRecord.setComaMinuteAfterHospital(comaMinuteAfterHospital);
    }

    public Integer getComaDayAfterHospital() {
        return comaRecord.getComaDayAfterHospital();
    }

    public void setComaDayBeforeHospital(Integer comaDayBeforeHospital) {
        comaRecord.setComaDayBeforeHospital(comaDayBeforeHospital);
    }

    public Integer getComaMinuteBeforeHospital() {
        return comaRecord.getComaMinuteBeforeHospital();
    }

    public Integer getComaMinuteAfterHospital() {
        return comaRecord.getComaMinuteAfterHospital();
    }

    public Integer getComaHourAfterHospital() {
        return comaRecord.getComaHourAfterHospital();
    }

    public void setComaMinuteBeforeHospital(Integer comaMinuteBeforeHospital) {
        comaRecord.setComaMinuteBeforeHospital(comaMinuteBeforeHospital);
    }

    public void setComaHourBeforeHospital(Integer comaHourBeforeHospital) {
        comaRecord.setComaHourBeforeHospital(comaHourBeforeHospital);
    }

    public BigDecimal getExpenseTotal() {
        return expenseRecord.getExpenseTotal();
    }

    public BigDecimal getExpenseDiagnosisLab() {
        return expenseRecord.getExpenseDiagnosisLab();
    }

    public BigDecimal getExpenseCureNonOperation() {
        return expenseRecord.getExpenseCureNonOperation();
    }

    public void setExpenseBloodCellFactor(BigDecimal expenseBloodCellFactor) {
        expenseRecord.setExpenseBloodCellFactor(expenseBloodCellFactor);
    }

    public BigDecimal getExpenseNormalMedicalService() {
        return expenseRecord.getExpenseNormalMedicalService();
    }

    public void setExpenseCureNonOperation(BigDecimal expenseCureNonOperation) {
        expenseRecord.setExpenseCureNonOperation(expenseCureNonOperation);
    }

    public void setExpenseChineseMedicineCure(BigDecimal expenseChineseMedicineCure) {
        expenseRecord.setExpenseChineseMedicineCure(expenseChineseMedicineCure);
    }

    public BigDecimal getExpenseCureAnaesthesia() {
        return expenseRecord.getExpenseCureAnaesthesia();
    }

    public BigDecimal getExpenseConsumptionOperation() {
        return expenseRecord.getExpenseConsumptionOperation();
    }

    public BigDecimal getExpenseDiagnosisClinical() {
        return expenseRecord.getExpenseDiagnosisClinical();
    }

    public void setExpenseRecovery(BigDecimal expenseRecovery) {
        expenseRecord.setExpenseRecovery(expenseRecovery);
    }

    public BigDecimal getExpenseWesternMedicineMedication() {
        return expenseRecord.getExpenseWesternMedicineMedication();
    }

    public void setExpenseNormalMedicalService(BigDecimal expenseNormalMedicalService) {
        expenseRecord.setExpenseNormalMedicalService(expenseNormalMedicalService);
    }

    public void setExpenseBlood(BigDecimal expenseBlood) {
        expenseRecord.setExpenseBlood(expenseBlood);
    }

    public BigDecimal getExpenseBloodCellFactor() {
        return expenseRecord.getExpenseBloodCellFactor();
    }

    public BigDecimal getExpenseNormalOther() {
        return expenseRecord.getExpenseNormalOther();
    }

    public BigDecimal getExpenseBlood() {
        return expenseRecord.getExpenseBlood();
    }

    public void setExpenseOther(BigDecimal expenseOther) {
        expenseRecord.setExpenseOther(expenseOther);
    }

    public void setExpenseNormalNurse(BigDecimal expenseNormalNurse) {
        expenseRecord.setExpenseNormalNurse(expenseNormalNurse);
    }

    public BigDecimal getExpenseChineseMedicinePatentDrag() {
        return expenseRecord.getExpenseChineseMedicinePatentDrag();
    }

    public void setExpenseNormalCureOperating(BigDecimal expenseNormalCureOperating) {
        expenseRecord.setExpenseNormalCureOperating(expenseNormalCureOperating);
    }

    public BigDecimal getExpenseBloodAlbumin() {
        return expenseRecord.getExpenseBloodAlbumin();
    }

    public BigDecimal getExpenseNormalNurse() {
        return expenseRecord.getExpenseNormalNurse();
    }

    public BigDecimal getExpenseConsumptionCure() {
        return expenseRecord.getExpenseConsumptionCure();
    }

    public BigDecimal getExpenseRecovery() {
        return expenseRecord.getExpenseRecovery();
    }

    public void setExpenseWesternMedicineMedication(BigDecimal expenseWesternMedicineMedication) {
        expenseRecord.setExpenseWesternMedicineMedication(expenseWesternMedicineMedication);
    }

    public void setExpenseBloodAlbumin(BigDecimal expenseBloodAlbumin) {
        expenseRecord.setExpenseBloodAlbumin(expenseBloodAlbumin);
    }

    public void setExpensePersonal(BigDecimal expensePersonal) {
        expenseRecord.setExpensePersonal(expensePersonal);
    }

    public BigDecimal getExpenseChineseMedicineCure() {
        return expenseRecord.getExpenseChineseMedicineCure();
    }

    public void setExpenseConsumptionCure(BigDecimal expenseConsumptionCure) {
        expenseRecord.setExpenseConsumptionCure(expenseConsumptionCure);
    }

    public BigDecimal getExpenseDiagnosisPathology() {
        return expenseRecord.getExpenseDiagnosisPathology();
    }

    public BigDecimal getExpenseBloodGlobulin() {
        return expenseRecord.getExpenseBloodGlobulin();
    }

    public void setExpenseBloodCoagulationFactor(BigDecimal expenseBloodCoagulationFactor) {
        expenseRecord.setExpenseBloodCoagulationFactor(expenseBloodCoagulationFactor);
    }

    public void setExpenseCureClinicalPhysics(BigDecimal expenseCureClinicalPhysics) {
        expenseRecord.setExpenseCureClinicalPhysics(expenseCureClinicalPhysics);
    }

    public BigDecimal getExpenseWesternMedicineAntibiosisMedication() {
        return expenseRecord.getExpenseWesternMedicineAntibiosisMedication();
    }

    public BigDecimal getExpenseConsumptionExamine() {
        return expenseRecord.getExpenseConsumptionExamine();
    }

    public BigDecimal getExpensePersonal() {
        return expenseRecord.getExpensePersonal();
    }

    public BigDecimal getExpenseCureOperation() {
        return expenseRecord.getExpenseCureOperation();
    }

    public BigDecimal getExpenseNormalCureOperating() {
        return expenseRecord.getExpenseNormalCureOperating();
    }

    public void setExpenseConsumptionExamine(BigDecimal expenseConsumptionExamine) {
        expenseRecord.setExpenseConsumptionExamine(expenseConsumptionExamine);
    }

    public void setExpenseCureAnaesthesia(BigDecimal expenseCureAnaesthesia) {
        expenseRecord.setExpenseCureAnaesthesia(expenseCureAnaesthesia);
    }

    public void setExpenseChineseMedicinePatentDrag(BigDecimal expenseChineseMedicinePatentDrag) {
        expenseRecord.setExpenseChineseMedicinePatentDrag(expenseChineseMedicinePatentDrag);
    }

    public BigDecimal getExpenseChineseMedicineHerb() {
        return expenseRecord.getExpenseChineseMedicineHerb();
    }

    public void setExpenseDiagnosisImaging(BigDecimal expenseDiagnosisImaging) {
        expenseRecord.setExpenseDiagnosisImaging(expenseDiagnosisImaging);
    }

    public void setExpenseChineseMedicineHerb(BigDecimal expenseChineseMedicineHerb) {
        expenseRecord.setExpenseChineseMedicineHerb(expenseChineseMedicineHerb);
    }

    public void setExpenseWesternMedicineAntibiosisMedication(BigDecimal expenseWesternMedicineAntibiosisMedication) {
        expenseRecord.setExpenseWesternMedicineAntibiosisMedication(expenseWesternMedicineAntibiosisMedication);
    }

    public void setExpenseDiagnosisLab(BigDecimal expenseDiagnosisLab) {
        expenseRecord.setExpenseDiagnosisLab(expenseDiagnosisLab);
    }

    public void setExpenseDiagnosisPathology(BigDecimal expenseDiagnosisPathology) {
        expenseRecord.setExpenseDiagnosisPathology(expenseDiagnosisPathology);
    }

    public BigDecimal getExpenseBloodCoagulationFactor() {
        return expenseRecord.getExpenseBloodCoagulationFactor();
    }

    public void setExpenseConsumptionOperation(BigDecimal expenseConsumptionOperation) {
        expenseRecord.setExpenseConsumptionOperation(expenseConsumptionOperation);
    }

    public void setExpenseDiagnosisClinical(BigDecimal expenseDiagnosisClinical) {
        expenseRecord.setExpenseDiagnosisClinical(expenseDiagnosisClinical);
    }

    public BigDecimal getExpenseDiagnosisImaging() {
        return expenseRecord.getExpenseDiagnosisImaging();
    }

    public BigDecimal getExpenseCureOperationCure() {
        return expenseRecord.getExpenseCureOperationCure();
    }

    public BigDecimal getExpenseOther() {
        return expenseRecord.getExpenseOther();
    }

    public void setExpenseTotal(BigDecimal expenseTotal) {
        expenseRecord.setExpenseTotal(expenseTotal);
    }

    public void setExpenseCureOperation(BigDecimal expenseCureOperation) {
        expenseRecord.setExpenseCureOperation(expenseCureOperation);
    }

    public BigDecimal getExpenseCureClinicalPhysics() {
        return expenseRecord.getExpenseCureClinicalPhysics();
    }

    public void setExpenseNormalOther(BigDecimal expenseNormalOther) {
        expenseRecord.setExpenseNormalOther(expenseNormalOther);
    }

    public void setExpenseBloodGlobulin(BigDecimal expenseBloodGlobulin) {
        expenseRecord.setExpenseBloodGlobulin(expenseBloodGlobulin);
    }

    public void setExpenseCureOperationCure(BigDecimal expenseCureOperationCure) {
        expenseRecord.setExpenseCureOperationCure(expenseCureOperationCure);
    }

}
