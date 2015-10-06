package com.s3d.webapps.record.entity.homepage;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.config.vo.OperationVO;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.operation.Operation;

/**
 * 手术列表
 * @author wind.chen
 * @date 2015/5/17.
 */
public class OperationHistory {
    private OperationVO operation;
    private String date;
    private String operator;
    private String firstAssistant;
    private String secondAssistant;
    private String cutHealGrade;
    private String anaesthesiaType;
    private String anaesthetist;

    public OperationHistory() {

    }

    public OperationHistory(OperationVO operation, String date, String operator, String firstAssistant, String secondAssistant, String anaesthesiaType, String anaesthetist) {
        this.operation = operation;
        this.date = date;
        this.operator = operator;
        this.firstAssistant = firstAssistant;
        this.secondAssistant = secondAssistant;
        this.anaesthesiaType = anaesthesiaType;
        this.anaesthetist = anaesthetist;
    }

    public OperationHistory(Operation operation) {
        this.operation = new OperationVO(operation.getCode(), operation.getName(), Integer.parseInt(operation.getLevel()));
        this.date = DateUtils.convertToStrDate(operation.getOperatedDate());
        this.operator = operation.getMajorOperator();
        this.firstAssistant = operation.getAssistant1();
        this.secondAssistant = operation.getAssistant2();
        this.cutHealGrade = operation.getHealedInGrade();
        this.anaesthesiaType = operation.getAnesthesiaType();
        this.anaesthetist = operation.getAnesthesiaDoctor();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFirstAssistant() {
        return firstAssistant;
    }

    public void setFirstAssistant(String firstAssistant) {
        this.firstAssistant = firstAssistant;
    }

    public String getSecondAssistant() {
        return secondAssistant;
    }

    public void setSecondAssistant(String secondAssistant) {
        this.secondAssistant = secondAssistant;
    }

    public String getCutHealGrade() {
        return cutHealGrade;
    }

    public void setCutHealGrade(String cutHealGrade) {
        this.cutHealGrade = cutHealGrade;
    }

    public String getAnaesthesiaType() {
        return anaesthesiaType;
    }

    public void setAnaesthesiaType(String anaesthesiaType) {
        this.anaesthesiaType = anaesthesiaType;
    }

    public String getAnaesthetist() {
        return anaesthetist;
    }

    public void setAnaesthetist(String anaesthetist) {
        this.anaesthetist = anaesthetist;
    }

    public OperationVO getOperation() {
        return operation;
    }

    public void setOperation(OperationVO operation) {
        this.operation = operation;
    }
}
