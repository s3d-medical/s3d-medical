package com.s3d.webapps.record.entity.homepage;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DischargeDiagnosis implements Serializable{
    private String diagnosis;
    private List<String> sickCodes;
    private String inSickState;

    public DischargeDiagnosis() {

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
