package com.s3d.webapps.record.entity.homepage;

import java.io.Serializable;

/**
 * @author  wind.chen
 * @date 2015/5/17.
 */
public class PatientInfo implements Serializable {
    private String name;
    private String sex;
    private Integer birthdayYear;
    private Integer birthdayDay;
    private Integer birthdayMonth;
    private Integer age;
    private String country;
    private Integer babyAge;
    private Integer babyBornWeight;
    private Integer babyHospitalizedWeight;
    private String idCard;
    private String job;
    private String marriage;
    private String nation;

    // born address
    private String bornState;
    private String bornCity;
    private String bornDistrict;
    // native address 籍贯
    private String hometownState;
    private String hometownCity;

    // residence address 现住址
    private String addressState;
    private String addressCity;
    private String addressDistrict;
    private String addressPhone;
    private String addressPostcode;
    // registered address户口
    private String residenceState;
    private String residenceCity;
    private String residenceDistrict;
    private String residencePostcode;
    // company information.
    private String workPlaceAddress;
    private String workPlacePhone;
    private String workPlacePostcode;
    // contract person
    private String contact;
    private String relationship;
    private String contactAddress;
    private String contactPhone;

    public PatientInfo() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(Integer birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    public Integer getBirthdayDay() {
        return birthdayDay;
    }

    public void setBirthdayDay(Integer birthdayDay) {
        this.birthdayDay = birthdayDay;
    }

    public Integer getBirthdayMonth() {
        return birthdayMonth;
    }

    public void setBirthdayMonth(Integer birthdayMonth) {
        this.birthdayMonth = birthdayMonth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(Integer babyAge) {
        this.babyAge = babyAge;
    }

    public Integer getBabyBornWeight() {
        return babyBornWeight;
    }

    public void setBabyBornWeight(Integer babyBornWeight) {
        this.babyBornWeight = babyBornWeight;
    }

    public Integer getBabyHospitalizedWeight() {
        return babyHospitalizedWeight;
    }

    public void setBabyHospitalizedWeight(Integer babyHospitalizedWeight) {
        this.babyHospitalizedWeight = babyHospitalizedWeight;
    }

    public String getBornState() {
        return bornState;
    }

    public void setBornState(String bornState) {
        this.bornState = bornState;
    }

    public String getBornCity() {
        return bornCity;
    }

    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }

    public String getBornDistrict() {
        return bornDistrict;
    }

    public void setBornDistrict(String bornDistrict) {
        this.bornDistrict = bornDistrict;
    }

    public String getHometownState() {
        return hometownState;
    }

    public void setHometownState(String hometownState) {
        this.hometownState = hometownState;
    }

    public String getHometownCity() {
        return hometownCity;
    }

    public void setHometownCity(String hometownCity) {
        this.hometownCity = hometownCity;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getAddressPostcode() {
        return addressPostcode;
    }

    public void setAddressPostcode(String addressPostcode) {
        this.addressPostcode = addressPostcode;
    }

    public String getResidenceState() {
        return residenceState;
    }

    public void setResidenceState(String residenceState) {
        this.residenceState = residenceState;
    }

    public String getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(String residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getResidenceDistrict() {
        return residenceDistrict;
    }

    public void setResidenceDistrict(String residenceDistrict) {
        this.residenceDistrict = residenceDistrict;
    }

    public String getResidencePostcode() {
        return residencePostcode;
    }

    public void setResidencePostcode(String residencePostcode) {
        this.residencePostcode = residencePostcode;
    }

    public String getWorkPlaceAddress() {
        return workPlaceAddress;
    }

    public void setWorkPlaceAddress(String workPlaceAddress) {
        this.workPlaceAddress = workPlaceAddress;
    }

    public String getWorkPlacePhone() {
        return workPlacePhone;
    }

    public void setWorkPlacePhone(String workPlacePhone) {
        this.workPlacePhone = workPlacePhone;
    }

    public String getWorkPlacePostcode() {
        return workPlacePostcode;
    }

    public void setWorkPlacePostcode(String workPlacePostcode) {
        this.workPlacePostcode = workPlacePostcode;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
