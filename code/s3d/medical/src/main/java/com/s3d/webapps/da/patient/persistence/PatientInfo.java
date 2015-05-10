package com.s3d.webapps.da.patient.persistence;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 10:31:08
 */
public class PatientInfo {

	private String fullName;
	private int sex;
	private Date birthDate;
	private int ageYear;
    private int ageMonth;
	private String nationality;
	private float birthWeight;
	private String idCardNo;
	private int maritalStatus;

	public Company company;

	public ContactPerson contactPerson;

	public NativePlace nativePlace;

	public PresentAddress presentAddress;

	public RegisteredResidence registeredResidence;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAgeYear() {
        return ageYear;
    }

    public void setAgeYear(int ageYear) {
        this.ageYear = ageYear;
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(int ageMonth) {
        this.ageMonth = ageMonth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public float getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(float birthWeight) {
        this.birthWeight = birthWeight;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
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