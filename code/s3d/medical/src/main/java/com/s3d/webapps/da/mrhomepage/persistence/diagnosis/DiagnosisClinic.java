package com.s3d.webapps.da.mrhomepage.persistence.diagnosis;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 * @created 11-����-2015 21:37:04
 */
@Entity
@Table(name="mr_diagnosis_clinic")
@PrimaryKeyJoinColumn(name="clinic_id")
public class DiagnosisClinic extends BaseDiagnose {
    public DiagnosisClinic(String name, String code) {
        super(name, code);
    }


}