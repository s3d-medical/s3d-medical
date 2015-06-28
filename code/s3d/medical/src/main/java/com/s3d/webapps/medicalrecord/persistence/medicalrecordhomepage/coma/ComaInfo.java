package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.coma;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_comma_info")
public class ComaInfo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

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

    public ComaInfo() {
    }

    public void fill(Integer daysBeforeAdmission, Integer hoursBeforeAdmission, Integer minutesBeforeAdmission, Integer daysInHospital, Integer hoursInHospital, Integer minutesInHospital) {
        this.daysBeforeAdmission = daysBeforeAdmission;
        this.hoursBeforeAdmission = hoursBeforeAdmission;
        this.minutesBeforeAdmission = minutesBeforeAdmission;
        this.daysInHospital = daysInHospital;
        this.hoursInHospital = hoursInHospital;
        this.minutesInHospital = minutesInHospital;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComaInfo)) return false;

        ComaInfo comaInfo = (ComaInfo) o;

        if (daysBeforeAdmission != null ? !daysBeforeAdmission.equals(comaInfo.daysBeforeAdmission) : comaInfo.daysBeforeAdmission != null)
            return false;
        if (daysInHospital != null ? !daysInHospital.equals(comaInfo.daysInHospital) : comaInfo.daysInHospital != null)
            return false;
        if (hoursBeforeAdmission != null ? !hoursBeforeAdmission.equals(comaInfo.hoursBeforeAdmission) : comaInfo.hoursBeforeAdmission != null)
            return false;
        if (hoursInHospital != null ? !hoursInHospital.equals(comaInfo.hoursInHospital) : comaInfo.hoursInHospital != null)
            return false;
        if (minutesBeforeAdmission != null ? !minutesBeforeAdmission.equals(comaInfo.minutesBeforeAdmission) : comaInfo.minutesBeforeAdmission != null)
            return false;
        if (minutesInHospital != null ? !minutesInHospital.equals(comaInfo.minutesInHospital) : comaInfo.minutesInHospital != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = daysBeforeAdmission != null ? daysBeforeAdmission.hashCode() : 0;
        result = 31 * result + (hoursBeforeAdmission != null ? hoursBeforeAdmission.hashCode() : 0);
        result = 31 * result + (minutesBeforeAdmission != null ? minutesBeforeAdmission.hashCode() : 0);
        result = 31 * result + (daysInHospital != null ? daysInHospital.hashCode() : 0);
        result = 31 * result + (hoursInHospital != null ? hoursInHospital.hashCode() : 0);
        result = 31 * result + (minutesInHospital != null ? minutesInHospital.hashCode() : 0);
        return result;
    }
}