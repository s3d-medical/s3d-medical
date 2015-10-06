package com.s3d.webapps.record.entity.homepage;

import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisPathology;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DiagnosisRecord {
    // clinic diagnosis
    private String outpatientDiagnosis;
    private List<String> outpatientSickCodes;

    // discharge diagnosis. list.
    private List<DischargeDiagnosis> dischargeDiagnosis = new ArrayList<DischargeDiagnosis>();
    // external reason
    private String outCause;
    private List<String> outSickCodes;

    // pathology diagnosis.
    private String pathologyDiagnosis;
    private List<String> pathologySickCodes;
    private String pathologyNumber;

    public DiagnosisRecord() {

    }

    public String getOutpatientDiagnosis() {
        return outpatientDiagnosis;
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        this.outpatientDiagnosis = outpatientDiagnosis;
    }

    public List<DischargeDiagnosis> getDischargeDiagnosis() {
        return dischargeDiagnosis;
    }

    public void setDischargeDiagnosis(List<DischargeDiagnosis> dischargeDiagnosis) {
        this.dischargeDiagnosis = dischargeDiagnosis;
    }

    public String getOutCause() {
        return outCause;
    }

    public void setOutCause(String outCause) {
        this.outCause = outCause;
    }

    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis;
    }

    public String getPathologyNumber() {
        return pathologyNumber;
    }

    public void setPathologyNumber(String pathologyNumber) {
        this.pathologyNumber = pathologyNumber;
    }

    public List<String> getOutpatientSickCodes() {
        return outpatientSickCodes;
    }

    public void setOutpatientSickCodes(List<String> outpatientSickCodes) {
        this.outpatientSickCodes = outpatientSickCodes;
    }

    public List<String> getOutSickCodes() {
        return outSickCodes;
    }

    public void setOutSickCodes(List<String> outSickCodes) {
        this.outSickCodes = outSickCodes;
    }

    public List<String> getPathologySickCodes() {
        return pathologySickCodes;
    }

    public void setPathologySickCodes(List<String> pathologySickCodes) {
        this.pathologySickCodes = pathologySickCodes;
    }
}
