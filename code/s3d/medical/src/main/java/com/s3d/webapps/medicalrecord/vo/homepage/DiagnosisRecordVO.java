package com.s3d.webapps.medicalrecord.vo.homepage;

import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis.DiagnosisPathology;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DiagnosisRecordVO {
    // clinic diagnosis
    private String outpatientDiagnosis;
    private List<String> outpatientSickCodes;

    // discharge diagnosis. list.
    private List<DischargeDiagnosisVO> dischargeDiagnosis = new ArrayList<DischargeDiagnosisVO>();
    // external reason
    private String outCause;
    private List<String> outSickCodes;

    // pathology diagnosis.
    private String pathologyDiagnosis;
    private List<String> pathologySickCodes;
    private String pathologyNumber;

    public DiagnosisRecordVO() {
    }

    public void fill(DiagnosisClinic clinic, List<DiagnosisDischarge> discharges,
                             DiagnosisExternalReason externalReason,  DiagnosisPathology pathology) {
        if(clinic != null) {
            this.outpatientDiagnosis = clinic.getName();
            this.outpatientSickCodes = clinic.getStrDiseaseCodes();
        }

        if(discharges != null && discharges.size() !=0){
            for(int i=0 ;i < discharges.size(); i++){
                DiagnosisDischarge item = discharges.get(i);
                DischargeDiagnosisVO dischargeDiagnosisVO = new DischargeDiagnosisVO(item.getName(), item.getStrDiseaseCodes(), item.getIllnessState());
                dischargeDiagnosis.add(dischargeDiagnosisVO);
            }
        }

        if(externalReason!= null){
            this.outCause = externalReason.getName();
            this.outSickCodes = externalReason.getStrDiseaseCodes();
        }

        if(pathology !=null){
            this.pathologyDiagnosis = pathology.getName();
            this.pathologySickCodes = pathology.getStrDiseaseCodes();
            this.pathologyNumber = pathology.getPathologyNo();
        }
    }

    public String getOutpatientDiagnosis() {
        return outpatientDiagnosis;
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        this.outpatientDiagnosis = outpatientDiagnosis;
    }

    public List<DischargeDiagnosisVO> getDischargeDiagnosis() {
        return dischargeDiagnosis;
    }

    public void setDischargeDiagnosis(List<DischargeDiagnosisVO> dischargeDiagnosis) {
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
