package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.homepagebasic;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author  wind
 * @date 2015/5/18.
 */
@Entity
@Table(name="mr_home_page_basic_info")
public class HomePageBasicInfo implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "health_card_no")
    private String healthCardNo;

    @Column(name = "hospitalized_times")
    private Integer hospitalizedTimes;

    @Column(name = "seq_no")
    private String seqNo;

    @Column(name = "depart_changes")
    public String departChanges;

    @Column(name = "if_drug_allergy")
    private String ifDrugAllergy;

    @Column(name = "allergy_drug")
    private String allergyDrug;

    @Column(name = "if_autopsy")
    private String ifAutopsy;

    @Column(name = "blood_type")
    private String bloodType;

    @Column(name = "if_rh")
    private String ifRH;

    @Column(name="business_key")
    private String businessKey;

    public void fillHomePageBasicInfo(String businessKey, String paymentType, String healthCardNo, Integer hospitalizedTimes, String seqNo,
                                      String departChanges, String ifDrugAllergy, String allergyDrug,
                                      String ifAutopsy, String bloodType, String ifRH) {
        this.paymentType = paymentType;
        this.healthCardNo = healthCardNo;
        this.hospitalizedTimes = hospitalizedTimes;
        this.seqNo = seqNo;
        this.departChanges = departChanges;
        this.ifDrugAllergy = ifDrugAllergy;
        this.allergyDrug = allergyDrug;
        this.ifAutopsy = ifAutopsy;
        this.bloodType = bloodType;
        this.ifRH = ifRH;
        this.businessKey = businessKey;
    }

    public HomePageBasicInfo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    public Integer getHospitalizedTimes() {
        return hospitalizedTimes;
    }

    public void setHospitalizedTimes(Integer hospitalizedTimes) {
        this.hospitalizedTimes = hospitalizedTimes;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getDepartChanges() {
        return departChanges;
    }

    public void setDepartChanges(String departChanges) {
        this.departChanges = departChanges;
    }

    public String getIfDrugAllergy() {
        return ifDrugAllergy;
    }

    public void setIfDrugAllergy(String ifDrugAllergy) {
        this.ifDrugAllergy = ifDrugAllergy;
    }

    public String getIfAutopsy() {
        return ifAutopsy;
    }

    public void setIfAutopsy(String ifAutopsy) {
        this.ifAutopsy = ifAutopsy;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getIfRH() {
        return ifRH;
    }

    public void setIfRH(String ifRH) {
        this.ifRH = ifRH;
    }

    public String getAllergyDrug() {
        return allergyDrug;
    }

    public void setAllergyDrug(String allergyDrug) {
        this.allergyDrug = allergyDrug;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

}
