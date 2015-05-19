package com.s3d.webapps.medicalrecord.vo;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.medicalrecord.persistence.entryexit.RegisterAdmission;
import com.s3d.webapps.medicalrecord.persistence.entryexit.RegisterDischarge;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * @author  Administrator
 * @date 2015/5/17.
 */
public class EntryExitRecordVO {
    // enter hospital.
    private String inType;
    private Integer inYear;
    private Integer inMonth;
    private Integer inDay;
    private String inTime;

    private String inDepartment;
    private String inSickroom;

    // discharge register 离院.
    private Integer outYear;
    private Integer outMonth;
    private Integer outDay;
    private String outTime;
    private String outDepartment;
    private String outSickroom;
    private Integer daysInHospital;
    private String outType;
    private String acceptOrganization;
    private String willReturn;
    private String returnPurpose;

    public EntryExitRecordVO() {
    }

    public void fill(RegisterAdmission registerAdmission, RegisterDischarge registerDischarge) {
        this.fillRegisterAdmission(registerAdmission);
        this.fillRegisterDischarge(registerDischarge);
    }

    private void fillRegisterAdmission(RegisterAdmission registerAdmission) {
        if (registerAdmission == null) {
            return;
        }
        this.inType = registerAdmission.getApproach();
        this.inYear = DateUtils.getYearInt(registerAdmission.getRegisteredTime());
        this.inMonth = DateUtils.getMonthInt(registerAdmission.getRegisteredTime());
        this.inDay = DateUtils.getDayOfMonthInt(registerAdmission.getRegisteredTime());
        this.inTime = DateUtils.getTimeOfDate(registerAdmission.getRegisteredTime());
        this.inDepartment = registerAdmission.getDepart();
        this.inSickroom = registerAdmission.getSickRoomNo();
    }

    private void fillRegisterDischarge(RegisterDischarge registerDischarge) {
        if (registerDischarge == null) {
            return;
        }
        this.outYear = DateUtils.getYearInt(registerDischarge.getRegisteredTime());
        this.outMonth = DateUtils.getMonthInt(registerDischarge.getRegisteredTime());
        this.outDay = DateUtils.getDayOfMonthInt(registerDischarge.getRegisteredTime());
        this.outTime = DateUtils.getTimeOfDate(registerDischarge.getRegisteredTime());
        this.outDepartment = registerDischarge.getDepart();
        this.outSickroom = registerDischarge.getSickRoomNo();
        this.daysInHospital = registerDischarge.getTotalDays();
        this.outType = registerDischarge.getDischargeType();
        this.acceptOrganization = registerDischarge.getAcceptingAgencyName();
        this.willReturn = registerDischarge.getHasReadmissionPlan();
        this.returnPurpose = registerDischarge.getHasReadmissionPlan();
    }

    public String getInType() {
        return inType;
    }

    public void setInType(String inType) {
        this.inType = inType;
    }

    public Integer getInYear() {
        return inYear;
    }

    public void setInYear(Integer inYear) {
        this.inYear = inYear;
    }

    public Integer getInMonth() {
        return inMonth;
    }

    public void setInMonth(Integer inMonth) {
        this.inMonth = inMonth;
    }

    public Integer getInDay() {
        return inDay;
    }

    public void setInDay(Integer inDay) {
        this.inDay = inDay;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getInDepartment() {
        return inDepartment;
    }

    public void setInDepartment(String inDepartment) {
        this.inDepartment = inDepartment;
    }

    public String getInSickroom() {
        return inSickroom;
    }

    public void setInSickroom(String inSickroom) {
        this.inSickroom = inSickroom;
    }

    public Integer getOutYear() {
        return outYear;
    }

    public void setOutYear(Integer outYear) {
        this.outYear = outYear;
    }

    public Integer getOutMonth() {
        return outMonth;
    }

    public void setOutMonth(Integer outMonth) {
        this.outMonth = outMonth;
    }

    public Integer getOutDay() {
        return outDay;
    }

    public void setOutDay(Integer outDay) {
        this.outDay = outDay;
    }

    public String getOutDepartment() {
        return outDepartment;
    }

    public void setOutDepartment(String outDepartment) {
        this.outDepartment = outDepartment;
    }

    public String getOutSickroom() {
        return outSickroom;
    }

    public void setOutSickroom(String outSickroom) {
        this.outSickroom = outSickroom;
    }

    public Integer getDaysInHospital() {
        return daysInHospital;
    }

    public void setDaysInHospital(Integer daysInHospital) {
        this.daysInHospital = daysInHospital;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getAcceptOrganization() {
        return acceptOrganization;
    }

    public void setAcceptOrganization(String acceptOrganization) {
        this.acceptOrganization = acceptOrganization;
    }

    public String getWillReturn() {
        return willReturn;
    }

    public void setWillReturn(String willReturn) {
        this.willReturn = willReturn;
    }

    public String getReturnPurpose() {
        return returnPurpose;
    }

    public void setReturnPurpose(String returnPurpose) {
        this.returnPurpose = returnPurpose;
    }
}
