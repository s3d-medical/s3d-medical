package com.s3d.webapps.record.entity.homepage;

import com.s3d.tech.utils.DateUtils;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.entryexit.RegisterAdmission;
import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.entryexit.RegisterDischarge;

import java.io.Serializable;

/**
 * @author  Administrator
 * @date 2015/5/17.
 */
public class EntryExitRecord  implements Serializable {
    // enter hospital.
    private String inType;
    private Integer inYear;
    private Integer inMonth;
    private Integer inDay;
    private String inHour;

    private String inDepartment;
    private String inSickroom;

    // discharge register 离院.
    private Integer outYear;
    private Integer outMonth;
    private Integer outDay;
    private String outHour;

    private String outDepartment;
    private String outSickroom;
    private Integer daysInHospital;
    private String outType;
    private String acceptOrganization;
    private String willReturn;
    private String returnPurpose;

    public EntryExitRecord() {

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

    public String getInHour() {
        return inHour;
    }

    public void setInHour(String inHour) {
        this.inHour = inHour;
    }

    public String getOutHour() {
        return outHour;
    }

    public void setOutHour(String outHour) {
        this.outHour = outHour;
    }

}
