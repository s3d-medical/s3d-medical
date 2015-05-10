package com.s3d.webapps.da.primarypage.persistence;

import java.util.Date;

/**
 * @author Administrator
 * @version 1.0
 * @created 10-����-2015 14:11:43
 */
public class DischargeRegistration {

	private String depart;
	private Date dischargeTime;
	private int sickRoomNo;
	private int totalDay;
	private int dischargeType;
	private int acceptingAgency;
	private boolean hasReadmissionPlan;
	private String readmissionGoal;

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Date getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Date dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public int getSickRoomNo() {
        return sickRoomNo;
    }

    public void setSickRoomNo(int sickRoomNo) {
        this.sickRoomNo = sickRoomNo;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(int totalDay) {
        this.totalDay = totalDay;
    }

    public int getDischargeType() {
        return dischargeType;
    }

    public void setDischargeType(int dischargeType) {
        this.dischargeType = dischargeType;
    }

    public int getAcceptingAgency() {
        return acceptingAgency;
    }

    public void setAcceptingAgency(int acceptingAgency) {
        this.acceptingAgency = acceptingAgency;
    }

    public boolean isHasReadmissionPlan() {
        return hasReadmissionPlan;
    }

    public void setHasReadmissionPlan(boolean hasReadmissionPlan) {
        this.hasReadmissionPlan = hasReadmissionPlan;
    }

    public String getReadmissionGoal() {
        return readmissionGoal;
    }

    public void setReadmissionGoal(String readmissionGoal) {
        this.readmissionGoal = readmissionGoal;
    }
}