package com.s3d.webapps.medicalrecord.vo;

import com.s3d.webapps.medicalrecord.persistence.HomePageBasicInfo.HomePageBasicInfo;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author wind.chen
 * @date 2015/5/18.
 */
public class HomePageBasicInfoVO {

    private String payType;
    private String healthCard;
    private Integer hospitalizedTimes = 0;
    private String caseNumber;

    //change departs.
    private String changeDepartment;
    // Allergy
    private String medicalAllergy;
    private String allergicMedication;

    // autopsy
    private String autopsy;
    private String bloodType;
    private String rh;

    public HomePageBasicInfoVO() {
    }

    public void fill(HomePageBasicInfo basicInfo) {
        this.payType = basicInfo.getPaymentType();
        this.healthCard = basicInfo.getHealthCardNo();
        this.hospitalizedTimes = basicInfo.getHospitalizedTimes();
        this.caseNumber = basicInfo.getSeqNo();
        this.changeDepartment = basicInfo.getDepartChanges();
        this.medicalAllergy = basicInfo.getIfDrugAllergy();
        this.allergicMedication = basicInfo.getAllergyDrug();
        this.autopsy = basicInfo.getIfAutopsy();
        this.bloodType = basicInfo.getBloodType();
        this.rh = basicInfo.getIfRH();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getHealthCard() {
        return healthCard;
    }

    public void setHealthCard(String healthCard) {
        this.healthCard = healthCard;
    }

    public Integer getHospitalizedTimes() {
        return hospitalizedTimes;
    }

    public void setHospitalizedTimes(Integer hospitalizedTimes) {
        this.hospitalizedTimes = hospitalizedTimes;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getChangeDepartment() {
        return changeDepartment;
    }

    public void setChangeDepartment(String changeDepartment) {
        this.changeDepartment = changeDepartment;
    }

    public String getMedicalAllergy() {
        return medicalAllergy;
    }

    public void setMedicalAllergy(String medicalAllergy) {
        this.medicalAllergy = medicalAllergy;
    }

    public String getAllergicMedication() {
        return allergicMedication;
    }

    public void setAllergicMedication(String allergicMedication) {
        this.allergicMedication = allergicMedication;
    }

    public String getAutopsy() {
        return autopsy;
    }

    public void setAutopsy(String autopsy) {
        this.autopsy = autopsy;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }
}
