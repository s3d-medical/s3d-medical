package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "RegisteredResidence")
public class RegisteredResidence extends BaseAddress {
    @Column(name="county")
    private String county;

    @Column(name="zip_code")
    private String zipCode;

	public RegisteredResidence(){

	}

    public void fill(String province, String city, String county, String zipCode) {
        super.fill(province, city);
        this.county = county;
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisteredResidence)) return false;
        if (!super.equals(o)) return false;

        RegisteredResidence that = (RegisteredResidence) o;

        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}