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

    @Column(name="category")
	private Integer category;

    @Column(name="illness_state")
	private Integer illnessState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medical_record_home_page_id", referencedColumnName = "id")
    private MedicalRecordHomePage medicalRecordHomePage;

    public DiagnosisDischarge(String name, String code, Integer category, Integer illnessState) {
        super(name, code);
        this.category = category;
        this.illnessState = illnessState;
    }

    public DiagnosisDischarge(Integer category) {
        this.category = category;
    }

    public DiagnosisDischarge(String name, String code, Integer category) {
        super(name, code);
        this.category = category;
    }

    public MedicalRecordHomePage getMedicalRecordHomePage() {
        return medicalRecordHomePage;
    }

    public void setMedicalRecordHomePage(MedicalRecordHomePage medicalRecordHomePage) {
        this.medicalRecordHomePage = medicalRecordHomePage;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getIllnessState() {
        return illnessState;
    }

    public void setIllnessState(Integer illnessState) {
        this.illnessState = illnessState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiagnosisDischarge)) return false;
        if (!super.equals(o)) return false;

        DiagnosisDischarge that = (DiagnosisDischarge) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (illnessState != null ? !illnessState.equals(that.illnessState) : that.illnessState != null) return false;
        if (medicalRecordHomePage != null ? !medicalRecordHomePage.equals(that.medicalRecordHomePage) : that.medicalRecordHomePage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (illnessState != null ? illnessState.hashCode() : 0);
        result = 31 * result + (medicalRecordHomePage != null ? medicalRecordHomePage.hashCode() : 0);
        return result;
    }
}