package com.s3d.webapps.da.primarypage.persistence;

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
public class DiagnosisClinic extends Diagnose {
    public DiagnosisClinic(String name, String code) {
        super(name, code);
    }
}