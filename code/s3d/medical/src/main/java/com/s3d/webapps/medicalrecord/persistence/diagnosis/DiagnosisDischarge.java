package com.s3d.webapps.medicalrecord.persistence.diagnosis;

import com.s3d.webapps.medicalrecord.persistence.MedicalRecordHomePage;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.
 */
@Entity
@Table(name="mr_diagnosis_discharge")
@PrimaryKeyJoinColumn(name="discharge_id")
public class DiagnosisDischarge extends BaseDiagnose {

    @Column(name="illness_state")
	private String illnessState;

    @ManyToOne()
    @JoinColumn(name="medical_record_home_page_id", referencedColumnName = "id")
    private MedicalRecordHomePage medicalRecordHomePage;

    public void fill(String name, String code, String illnessState) {
        super.fill(name, code);
        this.illnessState = illnessState;
    }

    public MedicalRecordHomePage getMedicalRecordHomePage() {
        return medicalRecordHomePage;
    }

    public void setMedicalRecordHomePage(MedicalRecordHomePage medicalRecordHomePage) {
        this.medicalRecordHomePage = medicalRecordHomePage;
    }


    public String getIllnessState() {
        return illnessState;
    }

    public void setIllnessState(String illnessState) {
        this.illnessState = illnessState;
    }

}