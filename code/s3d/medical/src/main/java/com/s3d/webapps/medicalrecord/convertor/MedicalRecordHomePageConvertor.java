package com.s3d.webapps.medicalrecord.convertor;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.homepagebasic.HomePageBasicInfo;
import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.doctor.DoctorInCharge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseInvoice;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseItem;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.operation.Operation;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient.PatientInfo;
import com.s3d.webapps.medicalrecord.vo.*;
import com.s3d.webapps.medicalrecord.vo.homepage.*;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator on 2015/5/17.
 */
public class MedicalRecordHomePageConvertor {
    public void copyToVO(MedicalRecordHomePage homePage, MedicalRecordHomePageVO homePageVO) {
        //1 basic info.
        HomePageBasicInfoVO homePageBasicInfoVO = new HomePageBasicInfoVO();
        homePageBasicInfoVO.fill(homePage.getHomePageBasicInfo());
        homePageVO.fillHomePageBasicInfoVO(homePageBasicInfoVO);

        //2 patient
        PatientInfoVO patientInfoVO = new PatientInfoVO();
        patientInfoVO.fill(homePage.getPatientInfo());
        homePageVO.fillInPatientInfoVO(patientInfoVO);

        //3 entry exit
        EntryExitRecordVO entryExitRecordVO = new EntryExitRecordVO();
        entryExitRecordVO.fill(homePage.getRegisterAdmission(), homePage.getRegisterDischarge());
        homePageVO.fillInEntryExitRecordVO(entryExitRecordVO);

        //4 diagnosis
        DiagnosisRecordVO diagnosisRecordVO = new DiagnosisRecordVO();
        diagnosisRecordVO.fill(homePage.getDiagnosisClinic(),
                homePage.getDiagnosisDischargeList(),
                homePage.getDiagnosisExternalReason(), homePage.getDiagnosisPathology());
        homePageVO.fillInDiagnosisRecordVO(diagnosisRecordVO);

        //5  doctors and quality.
        DoctorAndQualityRecordVO doctorAndQualityRecordVO = new DoctorAndQualityRecordVO();
        doctorAndQualityRecordVO.fill(homePage.getDoctorInChargeList(), homePage.getQualityControlInfo());
        homePageVO.fillInDoctorRecordVO(doctorAndQualityRecordVO);

        // operations
        List<Operation> operations = homePage.getOperationList();
        if (operations != null && operations.size() > 0) {
            for (int i = 0; i < operations.size(); i++) {
                homePageVO.getOperationHistory().add(new OperationHistoryVO(operations.get(i)));
            }
        }

        // coma
        ComaRecordVO comaRecordVO = new ComaRecordVO();
        comaRecordVO.fill(homePage.getComaInfo());
        homePageVO.fillInComaRecordVO(comaRecordVO);

        // expense
        ExpenseRecordVO expenseRecordVO = new ExpenseRecordVO();
        expenseRecordVO.fill(homePage.getExpenseInvoice());
        homePageVO.fillInExpenseRecordVO(expenseRecordVO);

    }


    public void copyToPo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage) {
        //1fill home basic info
        this.fillBasicInfo(homePageVO, homePage);
        //2 fill patient
        this.fillPatientInfo(homePageVO, homePage);

        //3 join and leave hospital record.
        this.fillEntryAndExitInfo(homePageVO, homePage);
        //4 diagnosis
        this.fillDiagnosisInfo(homePageVO, homePage);
        // 5 doctors and quality.
        this.fillDoctorsAndQualityInfo(homePageVO, homePage);
        // 6 operations
        this.fillOperations(homePageVO, homePage);
        //7 comma
        this.fillComaInfo(homePageVO, homePage);
        //8 expense
        this.fillExpense(homePageVO, homePage);
    }

    private void fillBasicInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        HomePageBasicInfoVO basicInfoVO = homePageVO.readHomePageBasicInfoVO();

        HomePageBasicInfo homePageBasicInfo = homePage.getHomePageBasicInfo();

        homePageBasicInfo.fillHomePageBasicInfo(basicInfoVO.getBusinessKey(),
                basicInfoVO.getPayType(),
                basicInfoVO.getHealthCard(),
                basicInfoVO.getHospitalizedTimes(),
                basicInfoVO.getTrackNo(),
                basicInfoVO.getChangeDepartment(),
                basicInfoVO.getMedicalAllergy(),
                basicInfoVO.getAllergicMedication(),
                basicInfoVO.getAutopsy(),
                basicInfoVO.getBloodType(),
                basicInfoVO.getRh());
    }

    /**
     * fill patient information.
     * @param homePageVO
     * @param homePage
     */
    private void fillPatientInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        PatientInfoVO patientInfoVO = homePageVO.readPatientInfoVO();

        Date birthDate = DateUtils.convertToDate(patientInfoVO.getBirthdayYear(), patientInfoVO.getBirthdayMonth(), patientInfoVO.getBirthdayDay());
        PatientInfo patientInfo = homePage.getPatientInfo();

        patientInfo.fillPatientBasicInfo(patientInfoVO.getName(), patientInfoVO.getSex(), birthDate, patientInfoVO.getAge(), patientInfoVO.getBabyAge(),
                patientInfoVO.getCountry(), patientInfoVO.getBabyBornWeight(), patientInfoVO.getBabyHospitalizedWeight(),
                patientInfoVO.getNation(), patientInfoVO.getIdCard(), patientInfoVO.getJob(), patientInfoVO.getMarriage());

        patientInfo.fillBirthPlace(patientInfoVO.getBornState(), patientInfoVO.getBornCity(), patientInfoVO.getBornDistrict());

        patientInfo.fillNativeAddress(patientInfoVO.getHometownState(), patientInfoVO.getHometownCity());

        patientInfo.fillPresentAddress(patientInfoVO.getAddressState(), patientInfoVO.getAddressCity(), patientInfoVO.getAddressDistrict(), patientInfoVO.getAddressPhone(), patientInfoVO.getAddressPostcode());

        patientInfo.fillRegisteredResidence(patientInfoVO.getResidenceState(), patientInfoVO.getResidenceCity(), patientInfoVO.getResidenceDistrict(), patientInfoVO.getResidencePostcode());

        patientInfo.fillCompany("", patientInfoVO.getWorkPlaceAddress(), patientInfoVO.getWorkPlacePhone(), patientInfoVO.getWorkPlacePostcode());

        patientInfo.fillContactPerson(patientInfoVO.getContact(), patientInfoVO.getRelationship(), patientInfoVO.getContactAddress(), patientInfoVO.getContactPhone());
    }

    /**
     * join and leave hospital record.
     * @param homePageVO
     * @param homePage
     */
    private void fillEntryAndExitInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        EntryExitRecordVO entryExitRecordVO = homePageVO.readEntryExitRecordVO();

        Date inDateTime = DateUtils.convertToDateHourMinute(entryExitRecordVO.getInYear(),
                entryExitRecordVO.getInMonth(),
                entryExitRecordVO.getInDay(),
                entryExitRecordVO.getInHour());
        homePage.getRegisterAdmission().fill(inDateTime,
                entryExitRecordVO.getInDepartment(),
                entryExitRecordVO.getInSickroom(),
                entryExitRecordVO.getInType());

        Date outDatetime = DateUtils.convertToDateHourMinute(entryExitRecordVO.getOutYear(),
                entryExitRecordVO.getOutMonth(),
                entryExitRecordVO.getOutDay(),
                entryExitRecordVO.getOutHour());
        homePage.getRegisterDischarge().fill(outDatetime,
                entryExitRecordVO.getOutDepartment(),
                entryExitRecordVO.getOutSickroom(),
                entryExitRecordVO.getDaysInHospital(),
                entryExitRecordVO.getOutType(),
                entryExitRecordVO.getAcceptOrganization(),
                entryExitRecordVO.getWillReturn(), entryExitRecordVO.getReturnPurpose());

    }

    /**
     * fill diagnosis related data.
     * @param homePageVO
     * @param homePage
     */
    private void fillDiagnosisInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        DiagnosisRecordVO diagnosisRecordVO = homePageVO.readDiagnosisRecordVO();
        // clinic
        homePage.getDiagnosisClinic().fill(diagnosisRecordVO.getOutpatientDiagnosis(), diagnosisRecordVO.getOutpatientSickCodes());

        // discharges remove old, then add new ones.
        List<DischargeDiagnosisVO> dischargeVOs = diagnosisRecordVO.getDischargeDiagnosis();
        List<DiagnosisDischarge> discharges = homePage.getDiagnosisDischargeList();
        discharges.clear();
        if (dischargeVOs != null && dischargeVOs.size() > 0) {
            for (int i = 0; i < dischargeVOs.size(); i++) {
                DischargeDiagnosisVO item = dischargeVOs.get(i);
                DiagnosisDischarge diagnosisDischarge = new DiagnosisDischarge();
                diagnosisDischarge.fill(item.getDiagnosis(), item.getSickCodes(), item.getInSickState());
                diagnosisDischarge.setMedicalRecordHomePage(homePage); // fill relation
                discharges.add(diagnosisDischarge);
            }
        }
        homePage.setDiagnosisDischargeList(discharges);

        // external reason
        homePage.getDiagnosisExternalReason().fill(diagnosisRecordVO.getOutCause(), diagnosisRecordVO.getOutSickCodes());

        // pathology
        homePage.getDiagnosisPathology().fill(diagnosisRecordVO.getPathologyDiagnosis(), diagnosisRecordVO.getPathologySickCodes(), diagnosisRecordVO.getPathologyNumber());  // pathology diagnosis.

    }

    private void fillExpense(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage) {
        ExpenseRecordVO expenseRecordVO = homePageVO.readExpenseRecordVO();

        ExpenseInvoice expenseInvoice = homePage.getExpenseInvoice();

        expenseInvoice.setTotalAmount(expenseRecordVO.getExpenseTotal());

        expenseInvoice.setSelfPayingAmount(expenseRecordVO.getExpensePersonal());

        List<ExpenseItem> items = expenseInvoice.getExpenseItems();
        items.get(0).setAmount(expenseRecordVO.getExpenseNormalMedicalService());
        items.get(1).setAmount(expenseRecordVO.getExpenseNormalCureOperating());
        items.get(2).setAmount(expenseRecordVO.getExpenseNormalNurse());
        items.get(3).setAmount(expenseRecordVO.getExpenseNormalOther());
        items.get(4).setAmount(expenseRecordVO.getExpenseDiagnosisPathology());
        items.get(5).setAmount(expenseRecordVO.getExpenseDiagnosisLab());
        items.get(6).setAmount(expenseRecordVO.getExpenseDiagnosisImaging());
        items.get(7).setAmount(expenseRecordVO.getExpenseDiagnosisClinical());
        items.get(8).setAmount(expenseRecordVO.getExpenseCureNonOperation());
        items.get(9).setAmount(expenseRecordVO.getExpenseCureClinicalPhysics());
        items.get(10).setAmount(expenseRecordVO.getExpenseCureOperationCure());
        items.get(11).setAmount(expenseRecordVO.getExpenseCureAnaesthesia());
        items.get(12).setAmount(expenseRecordVO.getExpenseCureOperation());
        items.get(13).setAmount(expenseRecordVO.getExpenseRecovery());
        items.get(14).setAmount(expenseRecordVO.getExpenseChineseMedicineCure());
        items.get(15).setAmount(expenseRecordVO.getExpenseWesternMedicineMedication());
        items.get(16).setAmount(expenseRecordVO.getExpenseWesternMedicineAntibiosisMedication());
        items.get(17).setAmount(expenseRecordVO.getExpenseChineseMedicinePatentDrag());
        items.get(18).setAmount(expenseRecordVO.getExpenseChineseMedicineHerb());
        items.get(19).setAmount(expenseRecordVO.getExpenseBlood());
        items.get(20).setAmount(expenseRecordVO.getExpenseBloodAlbumin());
        items.get(21).setAmount(expenseRecordVO.getExpenseBloodGlobulin());
        items.get(22).setAmount(expenseRecordVO.getExpenseBloodCoagulationFactor());
        items.get(23).setAmount(expenseRecordVO.getExpenseBloodCellFactor());
        items.get(24).setAmount(expenseRecordVO.getExpenseConsumptionExamine());
        items.get(25).setAmount(expenseRecordVO.getExpenseConsumptionCure());
        items.get(26).setAmount(expenseRecordVO.getExpenseConsumptionOperation());
        items.get(27).setAmount(expenseRecordVO.getExpenseOther());
    }

    private void fillOperations(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        List<OperationHistoryVO> operationVOs = homePageVO.getOperationHistory();
        List<Operation> operations = homePage.getOperationList();
        operations.clear();

        if(operationVOs != null && operationVOs.size() >0){

            for(int i=0; i<operationVOs.size(); i++){
                OperationHistoryVO itemVO = operationVOs.get(i);
                Operation operation = new Operation();
                operation.fill(itemVO.getOperateCode(),
                        itemVO.getDate(),
                        itemVO.getGrade(),
                        itemVO.getOperationName(),
                        itemVO.getOperator(),
                        itemVO.getFirstAssistant(),
                        itemVO.getSecondAssistant(),
                        itemVO.getCutHealGrade(),
                        itemVO.getAnaesthesiaType(),
                        itemVO.getAnaesthetist());

                operation.setMedicalRecordHomePage(homePage);
                operations.add(operation);
            }

        }
    }

    private void fillDoctorsAndQualityInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){
        DoctorAndQualityRecordVO doctorAndQualityRecordVO = homePageVO.readDoctorRecordVO();
        List<DoctorInCharge> doctorInChargeList = homePage.getDoctorInChargeList();
        doctorInChargeList.get(0).setDoctor(doctorAndQualityRecordVO.getDirector());
        doctorInChargeList.get(1).setDoctor(doctorAndQualityRecordVO.getDeputyDirector());
        doctorInChargeList.get(2).setDoctor(doctorAndQualityRecordVO.getAttendingDoctor());
        doctorInChargeList.get(3).setDoctor(doctorAndQualityRecordVO.getResidentDoctor());
        doctorInChargeList.get(4).setDoctor(doctorAndQualityRecordVO.getPrimaryNurse());
        doctorInChargeList.get(5).setDoctor(doctorAndQualityRecordVO.getRefresherDoctor());
        doctorInChargeList.get(6).setDoctor(doctorAndQualityRecordVO.getIntern());
        doctorInChargeList.get(7).setDoctor(doctorAndQualityRecordVO.getCoder());

        Date qualityDate = DateUtils.convertToDate(doctorAndQualityRecordVO.getQualityYear(),
                            doctorAndQualityRecordVO.getQualityMonth(), doctorAndQualityRecordVO.getQualityDay());
        homePage.getQualityControlInfo().fill(doctorAndQualityRecordVO.getCaseQuality(), doctorAndQualityRecordVO.getQualityDoctor(),
                doctorAndQualityRecordVO.getQualityNurse(), qualityDate);

    }

    private void fillComaInfo(MedicalRecordHomePageVO homePageVO, MedicalRecordHomePage homePage){

        ComaRecordVO comaRecordVO = homePageVO.readComaRecordVO();
        homePage.getComaInfo().fill(comaRecordVO.getComaDayBeforeHospital(),
                comaRecordVO.getComaHourBeforeHospital(),
                comaRecordVO.getComaMinuteBeforeHospital(),
                comaRecordVO.getComaDayAfterHospital(),
                comaRecordVO.getComaHourAfterHospital(),
                comaRecordVO.getComaMinuteAfterHospital());
    }

}
