package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_register_discharge")
public class RegisterDischarge extends Register {
    @Column(name="total_days")
    private Integer totalDays;

    @Column(name="discharge_type")
	private Integer dischargeType;

    @Column(name="accepting_agency_name")
	private String acceptingAgencyName;

    @Column(name="has_readmission_plan")
	private Boolean hasReadmissionPlan;

    @Column(name="readmission_goal")
	private String readmissionGoal;

	public RegisterDischarge(){

	}

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public Integer getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(Integer dischargeType) {
        this.dischargeType = dischargeType;
    }

    public String getAcceptingAgencyName() {
        return acceptingAgencyName;
    }

    public void setAcceptingAgencyName(String acceptingAgencyName) {
        this.acceptingAgencyName = acceptingAgencyName;
    }

    public Boolean getHasReadmissionPlan() {
        return hasReadmissionPlan;
    }

    public void setHasReadmissionPlan(Boolean hasReadmissionPlan) {
        this.hasReadmissionPlan = hasReadmissionPlan;
    }

    public String getReadmissionGoal() {
        return readmissionGoal;
    }

    public void setReadmissionGoal(String readmissionGoal) {
        this.readmissionGoal = readmissionGoal;
    }
}