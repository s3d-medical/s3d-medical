package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.entryexit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_register_discharge")
public class RegisterDischarge extends BaseRegister {
    @Column(name="total_days")
    private Integer totalDays;

    @Column(name="discharge_type")
	private String dischargeType;

    @Column(name="accepting_agency_name")
	private String acceptingAgencyName;

    @Column(name="has_readmission_plan")
	private String hasReadmissionPlan;

    @Column(name="readmission_goal")
	private String readmissionGoal;

	public RegisterDischarge(){

	}

    public void fill(Date registeredTime, String depart, String sickRoomNo, Integer totalDays,
                     String dischargeType, String acceptingAgencyName, String hasReadmissionPlan, String readmissionGoal) {
        this.fill(registeredTime, depart, sickRoomNo);
        this.totalDays = totalDays;
        this.dischargeType = dischargeType;
        this.acceptingAgencyName = acceptingAgencyName;
        this.hasReadmissionPlan = hasReadmissionPlan;
        this.readmissionGoal = readmissionGoal;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

    public String getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(String dischargeType) {
        this.dischargeType = dischargeType;
    }

    public String getAcceptingAgencyName() {
        return acceptingAgencyName;
    }

    public void setAcceptingAgencyName(String acceptingAgencyName) {
        this.acceptingAgencyName = acceptingAgencyName;
    }

    public String getHasReadmissionPlan() {
        return hasReadmissionPlan;
    }

    public void setHasReadmissionPlan(String hasReadmissionPlan) {
        this.hasReadmissionPlan = hasReadmissionPlan;
    }

    public String getReadmissionGoal() {
        return readmissionGoal;
    }

    public void setReadmissionGoal(String readmissionGoal) {
        this.readmissionGoal = readmissionGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterDischarge)) return false;
        if (!super.equals(o)) return false;

        RegisterDischarge that = (RegisterDischarge) o;

        if (acceptingAgencyName != null ? !acceptingAgencyName.equals(that.acceptingAgencyName) : that.acceptingAgencyName != null)
            return false;
        if (dischargeType != null ? !dischargeType.equals(that.dischargeType) : that.dischargeType != null)
            return false;
        if (hasReadmissionPlan != null ? !hasReadmissionPlan.equals(that.hasReadmissionPlan) : that.hasReadmissionPlan != null)
            return false;
        if (readmissionGoal != null ? !readmissionGoal.equals(that.readmissionGoal) : that.readmissionGoal != null)
            return false;
        if (totalDays != null ? !totalDays.equals(that.totalDays) : that.totalDays != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (totalDays != null ? totalDays.hashCode() : 0);
        result = 31 * result + (dischargeType != null ? dischargeType.hashCode() : 0);
        result = 31 * result + (acceptingAgencyName != null ? acceptingAgencyName.hashCode() : 0);
        result = 31 * result + (hasReadmissionPlan != null ? hasReadmissionPlan.hashCode() : 0);
        result = 31 * result + (readmissionGoal != null ? readmissionGoal.hashCode() : 0);
        return result;
    }
}