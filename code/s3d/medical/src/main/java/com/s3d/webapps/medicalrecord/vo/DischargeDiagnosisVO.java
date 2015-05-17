package com.s3d.webapps.medicalrecord.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/5/17.
 */
public class DischargeDiagnosisVO implements Serializable{
    private String diagnosis;
    private String sickCode;
    private String inSickState;

    public DischargeDiagnosisVO() {
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
