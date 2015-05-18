package com.s3d.webapps.medicalrecord.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DischargeDiagnosisVO implements Serializable{
    private String diagnosis;
    private String sickCode;
    private String inSickState;

    public DischargeDiagnosisVO() {
    }

    public DischargeDiagnosisVO(String diagnosis, String sickCode, String inSickState) {
        this.diagnosis = diagnosis;
        this.sickCode = sickCode;
        this.inSickState = inSickState;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getSickCode() {
        return sickCode;
    }

    public void setSickCode(String sickCode) {
        this.sickCode = sickCode;
    }

    public String getInSickState() {
        return inSickState;
    }

    public void setInSickState(String inSickState) {
        this.inSickState = inSickState;
    }
}
