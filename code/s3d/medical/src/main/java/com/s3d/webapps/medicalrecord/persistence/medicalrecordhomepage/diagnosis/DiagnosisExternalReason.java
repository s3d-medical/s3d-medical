package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.diagnosis;

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
public class DiagnosisExternalReason extends BaseDiagnosis {
    public DiagnosisExternalReason() {
    }
}