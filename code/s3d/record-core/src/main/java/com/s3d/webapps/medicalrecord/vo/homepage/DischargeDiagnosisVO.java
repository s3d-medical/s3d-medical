package com.s3d.webapps.medicalrecord.vo.homepage;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DischargeDiagnosisVO implements Serializable{
    private String diagnosis;
    private List<String> sickCodes;
    private String inSickState;

    public DischargeDiagnosisVO() {
    }

    public DischargeDiagnosisVO(String diagnosis, List<String> sickCodes, String inSickState) {
        this.diagnosis = diagnosis;
        this.sickCodes = sickCodes;
        this.inSickState = inSickState;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<String> getSickCodes() {
        return sickCodes;
    }

    public void setSickCodes(List<String> sickCodes) {
        this.sickCodes = sickCodes;
    }

    public String getInSickState() {
        return inSickState;
    }

    public void setInSickState(String inSickState) {
        this.inSickState = inSickState;
    }
}
