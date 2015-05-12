package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_comma_info")
public class ComaInfo {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="days_before_admission")
	private Integer daysBeforeAdmission;

    @Column(name="hours_before_admission")
	private Integer hoursBeforeAdmission;

    @Column(name="minutes_before_admission")
	private Integer minutesBeforeAdmission;

    @Column(name="days_in_hospital")
	private Integer daysInHospital;

    @Column(name="hours_in_hospital")
	private Integer hoursInHospital;

    @Column(name="minutes_in_hospital")
	private Integer minutesInHospital;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDaysBeforeAdmission() {
        return daysBeforeAdmission;
    }

    public void setDaysBeforeAdmission(Integer daysBeforeAdmission) {
        this.daysBeforeAdmission = daysBeforeAdmission;
    }

    public Integer getHoursBeforeAdmission() {
        return hoursBeforeAdmission;
    }

    public void setHoursBeforeAdmission(Integer hoursBeforeAdmission) {
        this.hoursBeforeAdmission = hoursBeforeAdmission;
    }

    public Integer getMinutesBeforeAdmission() {
        return minutesBeforeAdmission;
    }

    public void setMinutesBeforeAdmission(Integer minutesBeforeAdmission) {
        this.minutesBeforeAdmission = minutesBeforeAdmission;
    }

    public Integer getDaysInHospital() {
        return daysInHospital;
    }

    public void setDaysInHospital(Integer daysInHospital) {
        this.daysInHospital = daysInHospital;
    }

    public Integer getHoursInHospital() {
        return hoursInHospital;
    }

    public void setHoursInHospital(Integer hoursInHospital) {
        this.hoursInHospital = hoursInHospital;
    }

    public Integer getMinutesInHospital() {
        return minutesInHospital;
    }

    public void setMinutesInHospital(Integer minutesInHospital) {
        this.minutesInHospital = minutesInHospital;
    }
}