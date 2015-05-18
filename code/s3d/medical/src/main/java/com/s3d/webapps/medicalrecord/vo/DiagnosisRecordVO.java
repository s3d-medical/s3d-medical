package com.s3d.webapps.medicalrecord.vo;

import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisClinic;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisDischarge;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisExternalReason;
import com.s3d.webapps.medicalrecord.persistence.diagnosis.DiagnosisPathology;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class DiagnosisRecordVO {
    // clinic diagnosis
    private String outpatientDiagnosis;
    private String outpatientSickCode;
    // discharge diagnosis. list.
    private List<DischargeDiagnosisVO> dischargeDiagnosis = new ArrayList<DischargeDiagnosisVO>();
    // external reason
    private String outCause;
    private String outSickCode;
    // pathology diagnosis.
    private String pathologyDiagnosis;
    private String pathologySickCode;
    private String pathologyNumber;

    public DiagnosisRecordVO() {
    }

    public void fill(DiagnosisClinic clinic, List<DiagnosisDischarge> discharges,
                             DiagnosisExternalReason externalReason,  DiagnosisPathology pathology) {
        if(clinic != null) {
            this.outpatientDiagnosis = clinic.getName();
            this.outpatientSickCode = clinic.getCode();
        }
        if(discharges != null && discharges.size() !=0){
            for(int i=0 ;i < discharges.size(); i++){
                DiagnosisDischarge item = discharges.get(i);
                DischargeDiagnosisVO dischargeDiagnosisVO = new DischargeDiagnosisVO(item.getName(), item.getCode(), item.getIllnessState());
                dischargeDiagnosis.add(dischargeDiagnosisVO);
            }
        }
        if(externalReason!= null){
            this.outCause = externalReason.getName();
            this.outSickCode = externalReason.getCode();
        }
        if(pathology !=null){
            this.pathologyDiagnosis = pathology.getName();
            this.pathologySickCode = pathology.getCode();
            this.pathologyNumber = pathology.getPathologyNo();
        }
    }


    public String getOutpatientDiagnosis() {
        return outpatientDiagnosis;
    }

    public void setOutpatientDiagnosis(String outpatientDiagnosis) {
        this.outpatientDiagnosis = outpatientDiagnosis;
    }

    public String getOutpatientSickCode() {
        return outpatientSickCode;
    }

    public void setOutpatientSickCode(String outpatientSickCode) {
        this.outpatientSickCode = outpatientSickCode;
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

    public String getOutSickCode() {
        return outSickCode;
    }

    public void setOutSickCode(String outSickCode) {
        this.outSickCode = outSickCode;
    }

    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis;
    }

    public String getPathologySickCode() {
        return pathologySickCode;
    }

    public void setPathologySickCode(String pathologySickCode) {
        this.pathologySickCode = pathologySickCode;
    }

    public String getPathologyNumber() {
        return pathologyNumber;
    }

    public void setPathologyNumber(String pathologyNumber) {
        this.pathologyNumber = pathologyNumber;
    }

}
