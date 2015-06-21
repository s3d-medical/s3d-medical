package com.s3d.webapps.medicalrecord.vo.homepage;

import com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.coma.ComaInfo;

/**
 * @author wind.chen
 * @date 2015/5/17.
 */
public class ComaRecordVO {
    private Integer comaDayBeforeHospital;
    private Integer comaHourBeforeHospital;
    private Integer comaMinuteBeforeHospital;
    private Integer comaDayAfterHospital;
    private Integer comaHourAfterHospital;
    private Integer comaMinuteAfterHospital;

    public ComaRecordVO() {

    }
    public void fill(ComaInfo comaInfo) {
        this.comaDayBeforeHospital = comaInfo.getDaysBeforeAdmission();
        this.comaHourBeforeHospital = comaInfo.getHoursBeforeAdmission();
        this.comaMinuteBeforeHospital = comaInfo.getMinutesBeforeAdmission();
        this.comaDayAfterHospital = comaInfo.getDaysInHospital();
        this.comaHourAfterHospital = comaInfo.getHoursInHospital();
        this.comaMinuteAfterHospital = comaInfo.getMinutesInHospital();
    }

    public Integer getComaDayBeforeHospital() {
        return comaDayBeforeHospital;
    }

    public void setComaDayBeforeHospital(Integer comaDayBeforeHospital) {
        this.comaDayBeforeHospital = comaDayBeforeHospital;
    }

    public Integer getComaHourBeforeHospital() {
        return comaHourBeforeHospital;
    }

    public void setComaHourBeforeHospital(Integer comaHourBeforeHospital) {
        this.comaHourBeforeHospital = comaHourBeforeHospital;
    }

    public Integer getComaMinuteBeforeHospital() {
        return comaMinuteBeforeHospital;
    }

    public void setComaMinuteBeforeHospital(Integer comaMinuteBeforeHospital) {
        this.comaMinuteBeforeHospital = comaMinuteBeforeHospital;
    }

    public Integer getComaDayAfterHospital() {
        return comaDayAfterHospital;
    }

    public void setComaDayAfterHospital(Integer comaDayAfterHospital) {
        this.comaDayAfterHospital = comaDayAfterHospital;
    }

    public Integer getComaHourAfterHospital() {
        return comaHourAfterHospital;
    }

    public void setComaHourAfterHospital(Integer comaHourAfterHospital) {
        this.comaHourAfterHospital = comaHourAfterHospital;
    }

    public Integer getComaMinuteAfterHospital() {
        return comaMinuteAfterHospital;
    }

    public void setComaMinuteAfterHospital(Integer comaMinuteAfterHospital) {
        this.comaMinuteAfterHospital = comaMinuteAfterHospital;
    }
}
