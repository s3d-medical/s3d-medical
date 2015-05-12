package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_diagnosis_external_reason")
@PrimaryKeyJoinColumn(name="external_reason_id")
public class DiagnosisExternalReason extends Diagnose {
    public DiagnosisExternalReason(String name, String code) {
        super(name, code);
    }
}