package com.s3d.webapps.medicalrecord.persistence.patient;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "BirthPlace")
public class BirthPlace extends BaseAddress {
    @Column(name="county")
    private String county;

    public BirthPlace() {
    }
    public void fill(String province, String city, String county) {
        this.fill(province, city);
        this.county = county;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthPlace)) return false;
        if (!super.equals(o)) return false;

        BirthPlace that = (BirthPlace) o;

        if (county != null ? !county.equals(that.county) : that.county != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (county != null ? county.hashCode() : 0);
        return result;
    }
}