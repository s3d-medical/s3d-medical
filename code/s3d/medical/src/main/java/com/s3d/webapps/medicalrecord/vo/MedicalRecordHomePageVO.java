package com.s3d.webapps.medicalrecord.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/15.
 */
public class MedicalRecordHomePageVO {

    private Integer payType;
    private String healthCard;
    private Integer hospitalizedTimes = 0;
    private String name;
    private String sex;
    private Integer birthdayYear;
    private String caseNumber;
    private Integer birthdayDay;
    private Integer birthdayMonth;
    private Integer age;
    private Integer country;
    private Integer babyAge;
    private BigDecimal babyBornWeight;
    private BigDecimal babyHospitalizedWeight;
    // born address
    private String bornState;
    private String bornCity;
    private String bornDistrict;
    // native address 籍贯
    private String hometownCity;
    private String hometownState;
    private String nation;
    private String idCard;
    private String job;
    private String marriage;

    // residence address 现住址
    private String addressState;
    private String addressCity;
    private String addressDistrict;
    private String addressPhone;
    private String addressPostcode;
    // registered address户口
    private String residenceState;
    private String residenceCity;
    private String residenceDistrict;
    private String residencePostcode;
    // company information.
    private String workPlaceAddress;
    private String workPlacePhone;
    private String workPlacePostcode;
    // contract person
    private String contact;
    private String relationship;
    private String contactAddress;
    private String contactPhone;

    // enter hospital.
    private String inType;
    private Integer inYear;
    private Integer inMonth;
    private Integer inDay;
    private Integer inDepartment;
    private String inSickroom;
    //change departs.
    private String changeDepartment;
    // discharge register 离院.
    private Integer outYear;
    private Integer outMonth;
    private Integer outDay;
    private String outDepartment;
    private String outSickroom;
    private Integer daysInHospital;
    private Integer outType;
    private String acceptOrganization;
    private Integer willReturn;
    private String returnPurpose;

    // clinic diagnosis
    private String outpatientDiagnosis;
    private String outpatientSickCode;
    // discharge diagnosis. list.
    private List<DischargeDiagnosisVO> dischargeDiagnosis = new ArrayList<DischargeDiagnosisVO>();
    // external reason
    private String outCause;
    private String outSickCode;
    // pathology diagnosis.
    private String pathologyDiagnosis;
    private String pathologySickCode;
    private String pathologyNumber;
    // Allergy
    private String medicalAllergy;
    private String allergicMedication;

    // autopsy
    private Integer autopsy;
    private Integer bloodType;
    private Integer rh;

    // related doctors.
    private String director;
    private String deputyDirector;
    private String attendingDoctor;
    private String residentDoctor;
    private String primaryNurse;
    private String refresherDoctor;
    private String intern;
    private String coder;
    private Integer caseQuality;
    private String qualityDoctor;
    private String qualityNurse;
    private Date qualityDate;

    private List<OperationHistoryVO> operationHistory = new ArrayList<OperationHistoryVO>();
    // comma
    private Integer comaDayBeforeHospital;
    private Integer comaHourBeforeHospital;
    private Integer comaMinuteBeforeHospital;
    private Integer comaDayAfterHospital;
    private Integer comaHourAfterHospital;
    private Integer comaMinuteAfterHospital;

    // expense
    private BigDecimal expenseTotal;
    private BigDecimal expensePersonal;
    private BigDecimal expenseNormalMedicalService;
    private BigDecimal expenseNormalCureOperating;
    private BigDecimal expenseNormalNurse;
    private BigDecimal expenseNormalOther;
    private BigDecimal expenseDiagnosisPathology;
    private BigDecimal expenseDiagnosisLab;
    private BigDecimal expenseDiagnosisImaging;
    private BigDecimal expenseDiagnosisClinical;
    private BigDecimal expenseCureNonOperation;
    private BigDecimal expenseCureClinicalPhysics;
    private BigDecimal expenseCureOperationCure;
    private BigDecimal expenseCureAnaesthesia;
    private BigDecimal expenseCureOperation;
    private BigDecimal expenseRecovery;
    private BigDecimal expenseChineseMedicineCure;
    private BigDecimal expenseWesternMedicineMedication;
    private BigDecimal expenseWesternMedicineAntibiosisMedication;
    private BigDecimal expenseChineseMedicinePatentDrag;
    private BigDecimal expenseChineseMedicineHerb;
    private BigDecimal expenseBlood;
    private BigDecimal expenseBloodAlbumin;
    private BigDecimal expenseBloodGlobulin;
    private BigDecimal expenseBloodCoagulationFactor;
    private BigDecimal expenseBloodCellFactor;
    private BigDecimal expenseConsumptionExamine;
    private BigDecimal expenseConsumptionCure;
    private BigDecimal expenseConsumptionOperation;
    private BigDecimal expenseOther;

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getHealthCard() {
        return healthCard;
    }

    public void setHealthCard(String healthCard) {
        this.healthCard = healthCard;
    }

    public Integer getHospitalizedTimes() {
        return hospitalizedTimes;
    }

    public void setHospitalizedTimes(Integer hospitalizedTimes) {
        this.hospitalizedTimes = hospitalizedTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public Integer getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public Integer getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(Integer babyAge) {
        this.babyAge = babyAge;
    }

    public BigDecimal getBabyBornWeight() {
        return babyBornWeight;
    }

    public void setBabyBornWeight(BigDecimal babyBornWeight) {
        this.babyBornWeight = babyBornWeight;
    }

    public BigDecimal getBabyHospitalizedWeight() {
        return babyHospitalizedWeight;
    }

    public void setBabyHospitalizedWeight(BigDecimal babyHospitalizedWeight) {
        this.babyHospitalizedWeight = babyHospitalizedWeight;
    }

    public String getBornState() {
        return bornState;
    }

    public void setBornState(String bornState) {
        this.bornState = bornState;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    public String getBornDistrict() {
        return bornDistrict;
    }

    public void setBornDistrict(String bornDistrict) {
        this.bornDistrict = bornDistrict;
    }

    public String getHometownCity() {
        return hometownCity;
    }

    public void setHometownCity(String hometownCity) {
        this.hometownCity = hometownCity;
    }

    public String getHometownState() {
        return hometownState;
    }

    public void setHometownState(String hometownState) {
        this.hometownState = hometownState;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getResidenceState() {
        return residenceState;
    }

    public void setResidenceState(String residenceState) {
        this.residenceState = residenceState;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceDistrict() {
        return residenceDistrict;
    }

    public void setResidenceDistrict(String residenceDistrict) {
        this.residenceDistrict = residenceDistrict;
    }

    public String getResidencePostcode() {
        return residencePostcode;
    }

    public void setResidencePostcode(String residencePostcode) {
        this.residencePostcode = residencePostcode;
    }

    public String getWorkPlaceAddress() {
        return workPlaceAddress;
    }

    public void setWorkPlaceAddress(String workPlaceAddress) {
        this.workPlaceAddress = workPlaceAddress;
    }

    public String getWorkPlacePhone() {
        return workPlacePhone;
    }

    public void setWorkPlacePhone(String workPlacePhone) {
        this.workPlacePhone = workPlacePhone;
    }

    public String getWorkPlacePostcode() {
        return workPlacePostcode;
    }

    public void setWorkPlacePostcode(String workPlacePostcode) {
        this.workPlacePostcode = workPlacePostcode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public Integer getInYear() {
        return inYear;
    }

    public void setInYear(Integer inYear) {
        this.inYear = inYear;
    }

    public Integer getInMonth() {
        return inMonth;
    }

    public void setInMonth(Integer inMonth) {
        this.inMonth = inMonth;
    }

    public Integer getInDay() {
        return inDay;
    }

    public void setInDay(Integer inDay) {
        this.inDay = inDay;
    }

    public Integer getInDepartment() {
        return inDepartment;
    }

    public void setInDepartment(Integer inDepartment) {
        this.inDepartment = inDepartment;
    }

    public String getInSickroom() {
        return inSickroom;
    }

    public void setInSickroom(String inSickroom) {
        this.inSickroom = inSickroom;
    }

    public String getChangeDepartment() {
        return changeDepartment;
    }

    public void setChangeDepartment(String changeDepartment) {
        this.changeDepartment = changeDepartment;
    }

    public Integer getOutYear() {
        return outYear;
    }

    public void setOutYear(Integer outYear) {
        this.outYear = outYear;
    }

    public Integer getOutMonth() {
        return outMonth;
    }

    public void setOutMonth(Integer outMonth) {
        this.outMonth = outMonth;
    }

    public Integer getOutDay() {
        return outDay;
    }

    public void setOutDay(Integer outDay) {
        this.outDay = outDay;
    }

    public String getOutDepartment() {
        return outDepartment;
    }

    public void setOutDepartment(String outDepartment) {
        this.outDepartment = outDepartment;
    }

    public String getOutSickroom() {
        return outSickroom;
    }

    public void setOutSickroom(String outSickroom) {
        this.outSickroom = outSickroom;
    }

    public Integer getDaysInHospital() {
        return daysInHospital;
    }

    public void setDaysInHospital(Integer daysInHospital) {
        this.daysInHospital = daysInHospital;
    }

    public Integer getOutType() {
        return outType;
    }

    public void setOutType(Integer outType) {
        this.outType = outType;
    }

    public String getAcceptOrganization() {
        return acceptOrganization;
    }

    public void setAcceptOrganization(String acceptOrganization) {
        this.acceptOrganization = acceptOrganization;
    }

    public Integer getWillReturn() {
        return willReturn;
    }

    public void setWillReturn(Integer willReturn) {
        this.willReturn = willReturn;
    }

    public String getReturnPurpose() {
        return returnPurpose;
    }

    public void setReturnPurpose(String returnPurpose) {
        this.returnPurpose = returnPurpose;
    }

    public String getOutpatientDiagnosis() {
        return outpatientDiagnosis;
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        this.outpatientDiagnosis = outpatientDiagnosis;
    }

    public String getOutpatientSickCode() {
        return outpatientSickCode;
    }

    public void setOutpatientSickCode(String outpatientSickCode) {
        this.outpatientSickCode = outpatientSickCode;
    }

    public List<DischargeDiagnosisVO> getDischargeDiagnosis() {
        return dischargeDiagnosis;
    }

    public void setDischargeDiagnosis(List<DischargeDiagnosisVO> dischargeDiagnosis) {
        this.dischargeDiagnosis = dischargeDiagnosis;
    }

    public String getOutCause() {
        return outCause;
    }

    public void setOutCause(String outCause) {
        this.outCause = outCause;
    }

    public String getOutSickCode() {
        return outSickCode;
    }

    public void setOutSickCode(String outSickCode) {
        this.outSickCode = outSickCode;
    }

    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis;
    }

    public String getPathologySickCode() {
        return pathologySickCode;
    }

    public void setPathologySickCode(String pathologySickCode) {
        this.pathologySickCode = pathologySickCode;
    }

    public String getPathologyNumber() {
        return pathologyNumber;
    }

    public void setPathologyNumber(String pathologyNumber) {
        this.pathologyNumber = pathologyNumber;
    }

    public String getMedicalAllergy() {
        return medicalAllergy;
    }

    public void setMedicalAllergy(String medicalAllergy) {
        this.medicalAllergy = medicalAllergy;
    }

    public String getAllergicMedication() {
        return allergicMedication;
    }

    public void setAllergicMedication(String allergicMedication) {
        this.allergicMedication = allergicMedication;
    }

    public Integer getAutopsy() {
        return autopsy;
    }

    public void setAutopsy(Integer autopsy) {
        this.autopsy = autopsy;
    }

    public Integer getBloodType() {
        return bloodType;
    }

    public void setBloodType(Integer bloodType) {
        this.bloodType = bloodType;
    }

    public Integer getRh() {
        return rh;
    }

    public void setRh(Integer rh) {
        this.rh = rh;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDeputyDirector() {
        return deputyDirector;
    }

    public void setDeputyDirector(String deputyDirector) {
        this.deputyDirector = deputyDirector;
    }

    public String getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(String attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    public String getResidentDoctor() {
        return residentDoctor;
    }

    public void setResidentDoctor(String residentDoctor) {
        this.residentDoctor = residentDoctor;
    }

    public String getPrimaryNurse() {
        return primaryNurse;
    }

    public void setPrimaryNurse(String primaryNurse) {
        this.primaryNurse = primaryNurse;
    }

    public String getRefresherDoctor() {
        return refresherDoctor;
    }

    public void setRefresherDoctor(String refresherDoctor) {
        this.refresherDoctor = refresherDoctor;
    }

    public String getIntern() {
        return intern;
    }

    public void setIntern(String intern) {
        this.intern = intern;
    }

    public String getCoder() {
        return coder;
    }

    public void setCoder(String coder) {
        this.coder = coder;
    }

    public Integer getCaseQuality() {
        return caseQuality;
    }

    public void setCaseQuality(Integer caseQuality) {
        this.caseQuality = caseQuality;
    }

    public String getQualityDoctor() {
        return qualityDoctor;
    }

    public void setQualityDoctor(String qualityDoctor) {
        this.qualityDoctor = qualityDoctor;
    }

    public String getQualityNurse() {
        return qualityNurse;
    }

    public void setQualityNurse(String qualityNurse) {
        this.qualityNurse = qualityNurse;
    }

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }

    public List<OperationHistoryVO> getOperationHistory() {
        return operationHistory;
    }

    public void setOperationHistory(List<OperationHistoryVO> operationHistory) {
        this.operationHistory = operationHistory;
    }

    public Integer getComaDayBeforeHospital() {
        return comaDayBeforeHospital;
    }

    public void setComaDayBeforeHospital(Integer comaDayBeforeHospital) {
        this.comaDayBeforeHospital = comaDayBeforeHospital;
    }

    public Integer getComaHourBeforeHospital() {
        return comaHourBeforeHospital;
    }

    public void setComaHourBeforeHospital(Integer comaHourBeforeHospital) {
        this.comaHourBeforeHospital = comaHourBeforeHospital;
    }

    public Integer getComaMinuteBeforeHospital() {
        return comaMinuteBeforeHospital;
    }

    public void setComaMinuteBeforeHospital(Integer comaMinuteBeforeHospital) {
        this.comaMinuteBeforeHospital = comaMinuteBeforeHospital;
    }

    public Integer getComaDayAfterHospital() {
        return comaDayAfterHospital;
    }

    public void setComaDayAfterHospital(Integer comaDayAfterHospital) {
        this.comaDayAfterHospital = comaDayAfterHospital;
    }

    public Integer getComaHourAfterHospital() {
        return comaHourAfterHospital;
    }

    public void setComaHourAfterHospital(Integer comaHourAfterHospital) {
        this.comaHourAfterHospital = comaHourAfterHospital;
    }

    public Integer getComaMinuteAfterHospital() {
        return comaMinuteAfterHospital;
    }

    public void setComaMinuteAfterHospital(Integer comaMinuteAfterHospital) {
        this.comaMinuteAfterHospital = comaMinuteAfterHospital;
    }

    public BigDecimal getExpenseTotal() {
        return expenseTotal;
    }

    public void setExpenseTotal(BigDecimal expenseTotal) {
        this.expenseTotal = expenseTotal;
    }

    public BigDecimal getExpensePersonal() {
        return expensePersonal;
    }

    public void setExpensePersonal(BigDecimal expensePersonal) {
        this.expensePersonal = expensePersonal;
    }

    public BigDecimal getExpenseNormalMedicalService() {
        return expenseNormalMedicalService;
    }

    public void setExpenseNormalMedicalService(BigDecimal expenseNormalMedicalService) {
        this.expenseNormalMedicalService = expenseNormalMedicalService;
    }

    public BigDecimal getExpenseNormalCureOperating() {
        return expenseNormalCureOperating;
    }

    public void setExpenseNormalCureOperating(BigDecimal expenseNormalCureOperating) {
        this.expenseNormalCureOperating = expenseNormalCureOperating;
    }

    public BigDecimal getExpenseNormalNurse() {
        return expenseNormalNurse;
    }

    public void setExpenseNormalNurse(BigDecimal expenseNormalNurse) {
        this.expenseNormalNurse = expenseNormalNurse;
    }

    public BigDecimal getExpenseNormalOther() {
        return expenseNormalOther;
    }

    public void setExpenseNormalOther(BigDecimal expenseNormalOther) {
        this.expenseNormalOther = expenseNormalOther;
    }

    public BigDecimal getExpenseDiagnosisPathology() {
        return expenseDiagnosisPathology;
    }

    public void setExpenseDiagnosisPathology(BigDecimal expenseDiagnosisPathology) {
        this.expenseDiagnosisPathology = expenseDiagnosisPathology;
    }

    public BigDecimal getExpenseDiagnosisLab() {
        return expenseDiagnosisLab;
    }

    public void setExpenseDiagnosisLab(BigDecimal expenseDiagnosisLab) {
        this.expenseDiagnosisLab = expenseDiagnosisLab;
    }

    public BigDecimal getExpenseDiagnosisImaging() {
        return expenseDiagnosisImaging;
    }

    public void setExpenseDiagnosisImaging(BigDecimal expenseDiagnosisImaging) {
        this.expenseDiagnosisImaging = expenseDiagnosisImaging;
    }

    public BigDecimal getExpenseDiagnosisClinical() {
        return expenseDiagnosisClinical;
    }

    public void setExpenseDiagnosisClinical(BigDecimal expenseDiagnosisClinical) {
        this.expenseDiagnosisClinical = expenseDiagnosisClinical;
    }

    public BigDecimal getExpenseCureNonOperation() {
        return expenseCureNonOperation;
    }

    public void setExpenseCureNonOperation(BigDecimal expenseCureNonOperation) {
        this.expenseCureNonOperation = expenseCureNonOperation;
    }

    public BigDecimal getExpenseCureClinicalPhysics() {
        return expenseCureClinicalPhysics;
    }

    public void setExpenseCureClinicalPhysics(BigDecimal expenseCureClinicalPhysics) {
        this.expenseCureClinicalPhysics = expenseCureClinicalPhysics;
    }

    public BigDecimal getExpenseCureOperationCure() {
        return expenseCureOperationCure;
    }

    public void setExpenseCureOperationCure(BigDecimal expenseCureOperationCure) {
        this.expenseCureOperationCure = expenseCureOperationCure;
    }

    public BigDecimal getExpenseCureAnaesthesia() {
        return expenseCureAnaesthesia;
    }

    public void setExpenseCureAnaesthesia(BigDecimal expenseCureAnaesthesia) {
        this.expenseCureAnaesthesia = expenseCureAnaesthesia;
    }

    public BigDecimal getExpenseCureOperation() {
        return expenseCureOperation;
    }

    public void setExpenseCureOperation(BigDecimal expenseCureOperation) {
        this.expenseCureOperation = expenseCureOperation;
    }

    public BigDecimal getExpenseRecovery() {
        return expenseRecovery;
    }

    public void setExpenseRecovery(BigDecimal expenseRecovery) {
        this.expenseRecovery = expenseRecovery;
    }

    public BigDecimal getExpenseChineseMedicineCure() {
        return expenseChineseMedicineCure;
    }

    public void setExpenseChineseMedicineCure(BigDecimal expenseChineseMedicineCure) {
        this.expenseChineseMedicineCure = expenseChineseMedicineCure;
    }

    public BigDecimal getExpenseWesternMedicineMedication() {
        return expenseWesternMedicineMedication;
    }

    public void setExpenseWesternMedicineMedication(BigDecimal expenseWesternMedicineMedication) {
        this.expenseWesternMedicineMedication = expenseWesternMedicineMedication;
    }

    public BigDecimal getExpenseWesternMedicineAntibiosisMedication() {
        return expenseWesternMedicineAntibiosisMedication;
    }

    public void setExpenseWesternMedicineAntibiosisMedication(BigDecimal expenseWesternMedicineAntibiosisMedication) {
        this.expenseWesternMedicineAntibiosisMedication = expenseWesternMedicineAntibiosisMedication;
    }

    public BigDecimal getExpenseChineseMedicinePatentDrag() {
        return expenseChineseMedicinePatentDrag;
    }

    public void setExpenseChineseMedicinePatentDrag(BigDecimal expenseChineseMedicinePatentDrag) {
        this.expenseChineseMedicinePatentDrag = expenseChineseMedicinePatentDrag;
    }

    public BigDecimal getExpenseChineseMedicineHerb() {
        return expenseChineseMedicineHerb;
    }

    public void setExpenseChineseMedicineHerb(BigDecimal expenseChineseMedicineHerb) {
        this.expenseChineseMedicineHerb = expenseChineseMedicineHerb;
    }

    public BigDecimal getExpenseBlood() {
        return expenseBlood;
    }

    public void setExpenseBlood(BigDecimal expenseBlood) {
        this.expenseBlood = expenseBlood;
    }

    public BigDecimal getExpenseBloodAlbumin() {
        return expenseBloodAlbumin;
    }

    public void setExpenseBloodAlbumin(BigDecimal expenseBloodAlbumin) {
        this.expenseBloodAlbumin = expenseBloodAlbumin;
    }

    public BigDecimal getExpenseBloodGlobulin() {
        return expenseBloodGlobulin;
    }

    public void setExpenseBloodGlobulin(BigDecimal expenseBloodGlobulin) {
        this.expenseBloodGlobulin = expenseBloodGlobulin;
    }

    public BigDecimal getExpenseBloodCoagulationFactor() {
        return expenseBloodCoagulationFactor;
    }

    public void setExpenseBloodCoagulationFactor(BigDecimal expenseBloodCoagulationFactor) {
        this.expenseBloodCoagulationFactor = expenseBloodCoagulationFactor;
    }

    public BigDecimal getExpenseBloodCellFactor() {
        return expenseBloodCellFactor;
    }

    public void setExpenseBloodCellFactor(BigDecimal expenseBloodCellFactor) {
        this.expenseBloodCellFactor = expenseBloodCellFactor;
    }

    public BigDecimal getExpenseConsumptionExamine() {
        return expenseConsumptionExamine;
    }

    public void setExpenseConsumptionExamine(BigDecimal expenseConsumptionExamine) {
        this.expenseConsumptionExamine = expenseConsumptionExamine;
    }

    public BigDecimal getExpenseConsumptionCure() {
        return expenseConsumptionCure;
    }

    public void setExpenseConsumptionCure(BigDecimal expenseConsumptionCure) {
        this.expenseConsumptionCure = expenseConsumptionCure;
    }

    public BigDecimal getExpenseConsumptionOperation() {
        return expenseConsumptionOperation;
    }

    public void setExpenseConsumptionOperation(BigDecimal expenseConsumptionOperation) {
        this.expenseConsumptionOperation = expenseConsumptionOperation;
    }

    public BigDecimal getExpenseOther() {
        return expenseOther;
    }

    public void setExpenseOther(BigDecimal expenseOther) {
        this.expenseOther = expenseOther;
    }
}
