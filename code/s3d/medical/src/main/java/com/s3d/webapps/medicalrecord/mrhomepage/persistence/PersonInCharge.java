package com.s3d.webapps.medicalrecord.mrhomepage.persistence;

import com.s3d.tech.data.persistence.AbstractGeneralProperties;

import javax.persistence.*;

/**
 * role name:
 * 1. 科主任 2. 主任(副主任)医师. 3主治医师 4. 住院医师 5 责任护士 6进修医师 7.实习医师 8.编码员 9.质控医师 10.质控护士
 * @author Administrator
 * @version 1.0

 */
@Entity
@Table(name="person_in_charge")
public class PersonInCharge  extends AbstractGeneralProperties {

    @Column(name="worker_role")
	private Integer workerRole;

    @Column(name="doctor")
	private String doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medical_record_home_page_id", referencedColumnName = "id")
    private MedicalRecordHomePage medicalRecordHomePage;

	public PersonInCharge(){

	}

    public Integer getWorkerRole() {
        return workerRole;
    }

    public void setWorkerRole(Integer workerRole) {
        this.workerRole = workerRole;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public MedicalRecordHomePage getMedicalRecordHomePage() {
        return medicalRecordHomePage;
    }

    public void setMedicalRecordHomePage(MedicalRecordHomePage medicalRecordHomePage) {
        this.medicalRecordHomePage = medicalRecordHomePage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonInCharge)) return false;

        PersonInCharge that = (PersonInCharge) o;

        if (doctor != null ? !doctor.equals(that.doctor) : that.doctor != null) return false;
        if (medicalRecordHomePage != null ? !medicalRecordHomePage.equals(that.medicalRecordHomePage) : that.medicalRecordHomePage != null)
            return false;
        if (workerRole != null ? !workerRole.equals(that.workerRole) : that.workerRole != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = workerRole != null ? workerRole.hashCode() : 0;
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (medicalRecordHomePage != null ? medicalRecordHomePage.hashCode() : 0);
        return result;
    }
}