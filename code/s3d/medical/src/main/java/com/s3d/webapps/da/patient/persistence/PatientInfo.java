package com.s3d.webapps.da.patient.persistence;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 10:31:08
 */
@Entity
@Table(name = "p_patient_info")
public class PatientInfo implements Serializable {

    @Column(name = "full_name")
    private String fullName;
    @Column(name = "sex")
    private Integer sex;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "ageYear")
    private Integer ageYear;

    @Column(name = "age_month")
    private Integer ageMonth;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "weight_of_birth")
    private Float weightOfBirth;

    @Column(name = "weight_of_admission")
    private Float weightOfAdmission;

    @Column(name = "race")
    private Integer race;

    @Column(name = "id_card_no")
    private String idCardNo;

    @Column(name = "career")
    private Integer career;

    @Column(name = "marital_status")
    private Integer maritalStatus;

    private Company company;
    private ContactPerson contactPerson;
    private NativePlace nativePlace;
    private PresentAddress presentAddress;
    private RegisteredResidence registeredResidence;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAgeYear() {
        return ageYear;
    }

    public void setAgeYear(Integer ageYear) {
        this.ageYear = ageYear;
    }

    public Integer getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(Integer ageMonth) {
        this.ageMonth = ageMonth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public float getWeightOfBirth() {
        return weightOfBirth;
    }

    public void setWeightOfBirth(float weightOfBirth) {
        this.weightOfBirth = weightOfBirth;
    }

    public float getWeightOfAdmission() {
        return weightOfAdmission;
    }

    public void setWeightOfAdmission(float weightOfAdmission) {
        this.weightOfAdmission = weightOfAdmission;
    }

    public Integer getRace() {
        return race;
    }

    public void setRace(Integer race) {
        this.race = race;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public NativePlace getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(NativePlace nativePlace) {
        this.nativePlace = nativePlace;
    }

    public PresentAddress getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(PresentAddress presentAddress) {
        this.presentAddress = presentAddress;
    }

    public RegisteredResidence getRegisteredResidence() {
        return registeredResidence;
    }

    public void setRegisteredResidence(RegisteredResidence registeredResidence) {
        this.registeredResidence = registeredResidence;
    }
}