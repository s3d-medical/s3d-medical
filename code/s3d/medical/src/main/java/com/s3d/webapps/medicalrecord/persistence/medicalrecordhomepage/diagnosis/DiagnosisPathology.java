package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 */
@Entity
@Table(name="mr_diagnosis_pathology")
@PrimaryKeyJoinColumn(name="pathology_id")
public class DiagnosisPathology extends BaseDiagnosis {

    @Column(name="pathology_no")
	private String pathologyNo;

    public DiagnosisPathology() {

    }

    public void fill(String name, List<String> codes, String pathologyNo) {
        super.fill(name, codes);
        this.pathologyNo = pathologyNo;
    }

    public String getPathologyNo() {
        return pathologyNo;
    }

    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiagnosisPathology)) return false;
        if (!super.equals(o)) return false;

        DiagnosisPathology that = (DiagnosisPathology) o;

        if (pathologyNo != null ? !pathologyNo.equals(that.pathologyNo) : that.pathologyNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (pathologyNo != null ? pathologyNo.hashCode() : 0);
        return result;
    }
}