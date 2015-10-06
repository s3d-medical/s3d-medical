package com.s3d.webapps.record.entity.homepage;

import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseInvoice;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.expense.ExpenseItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author  wind.chen
 * @date2015/5/17.
 */
public class ExpenseRecord {
    // total fee
    private BigDecimal expenseTotal;
    private BigDecimal expensePersonal;
    //
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

    public ExpenseRecord() {

    }

    public void fill(ExpenseInvoice invoice){
        this.expenseTotal = invoice.getTotalAmount();
        this.expensePersonal = invoice.getSelfPayingAmount();
        List<ExpenseItem> items = invoice.getExpenseItems();
        this.expenseNormalMedicalService = items.get(0).getAmount();
        this.expenseNormalCureOperating = items.get(1).getAmount();
        this.expenseNormalNurse = items.get(2).getAmount();
        this.expenseNormalOther = items.get(3).getAmount();
        this.expenseDiagnosisPathology = items.get(4).getAmount();
        this.expenseDiagnosisLab = items.get(5).getAmount();
        this.expenseDiagnosisImaging = items.get(6).getAmount();
        this.expenseDiagnosisClinical = items.get(7).getAmount();
        this.expenseCureNonOperation = items.get(8).getAmount();
        this.expenseCureClinicalPhysics = items.get(9).getAmount();
        this.expenseCureOperationCure = items.get(10).getAmount();
        this.expenseCureAnaesthesia = items.get(11).getAmount();
        this.expenseCureOperation = items.get(12).getAmount();
        this.expenseRecovery = items.get(13).getAmount();
        this.expenseChineseMedicineCure = items.get(14).getAmount();
        this.expenseWesternMedicineMedication = items.get(15).getAmount();
        this.expenseWesternMedicineAntibiosisMedication = items.get(16).getAmount();
        this.expenseChineseMedicinePatentDrag = items.get(17).getAmount();
        this.expenseChineseMedicineHerb = items.get(18).getAmount();
        this.expenseBlood = items.get(19).getAmount();
        this.expenseBloodAlbumin = items.get(20).getAmount();
        this.expenseBloodGlobulin = items.get(21).getAmount();
        this.expenseBloodCoagulationFactor = items.get(22).getAmount();
        this.expenseBloodCellFactor = items.get(23).getAmount();
        this.expenseConsumptionExamine = items.get(24).getAmount();
        this.expenseConsumptionCure = items.get(25).getAmount();
        this.expenseConsumptionOperation = items.get(26).getAmount();
        this.expenseOther = items.get(27).getAmount();
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
