package com.s3d.webapps.record.entity.homepage;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.config.vo.OperationVO;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.operation.Operation;

import java.io.Serializable;

/**
 * 手术列表
 * @author wind.chen
 * @date 2015/5/17.
 */
public class OperationHistory  implements Serializable {
    private String date;
    private String operator;
    private String firstAssistant;
    private String secondAssistant;
    private String cutHealGrade;
    private String anaesthesiaType;
    private String anaesthetist;

    public OperationHistory() {

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


}
