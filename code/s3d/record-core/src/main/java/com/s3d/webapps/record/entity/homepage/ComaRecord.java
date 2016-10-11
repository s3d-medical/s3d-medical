package com.s3d.webapps.record.entity.homepage;


import java.io.Serializable;

/**
 * 脑损伤患者昏迷时间
 * @author wind.chen
 * @date 2015/5/17.
 */
public class ComaRecord  implements Serializable {
    private Integer comaDayBeforeHospital;
    private Integer comaHourBeforeHospital;
    private Integer comaMinuteBeforeHospital;
    private Integer comaDayAfterHospital;
    private Integer comaHourAfterHospital;
    private Integer comaMinuteAfterHospital;

    public ComaRecord() {

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
