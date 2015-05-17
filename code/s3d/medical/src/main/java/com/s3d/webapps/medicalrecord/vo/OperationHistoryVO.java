package com.s3d.webapps.medicalrecord.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class OperationHistoryVO {
    private String operateCode;
    private Date date;
    private String grade;
    private String operationName;
    private String operator;
    private String firstAssistant;
    private String secondAssistant;
    private String cutHealGrade;
    private String anaesthesiaType;
    private String anaesthetist;

    @JsonIgnore
    public OperationHistoryVO() {
    }

    public String getOperateCode() {
        return operateCode;
    }

    public void setOperateCode(String operateCode) {
        this.operateCode = operateCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
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
}
