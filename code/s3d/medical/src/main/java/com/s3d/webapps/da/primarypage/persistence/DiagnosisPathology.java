package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Administrator
 * @version 1.0
 */
@Entity
@Table(name="mr_diagnosis_pathology")
@PrimaryKeyJoinColumn(name="pathology_id")
public class DiagnosisPathology extends Diagnose {

    @Column(name="pathology_no")
	private String pathologyNo;

    public DiagnosisPathology(String name, String code, String pathologyNo) {
        super(name, code);
        this.pathologyNo = pathologyNo;
    }

    public String getPathologyNo() {
        return pathologyNo;
    }

    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }
}