package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 * @created 10-����-2015 10:24:44
 */
@Entity
@DiscriminatorValue(value = "PresentAddress")
public class PresentAddress extends BaseAddress {

    @Column(name="county")
    private String county;

    @Column(name = "phone_no")
	private String phoneNo;

    @Column(name="zip_code")
	private String zipCode;

    public void fill(String province, String city, String county, String phoneNo, String zipCode) {
        super.fill(province, city);
        this.county = county;
        this.phoneNo = phoneNo;
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
        if (!(o instanceof PresentAddress)) return false;
        if (!super.equals(o)) return false;

        PresentAddress that = (PresentAddress) o;

        if (county != null ? !county.equals(that.county) : that.county != null) return false;
        if (phoneNo != null ? !phoneNo.equals(that.phoneNo) : that.phoneNo != null) return false;
        if (zipCode != null ? !zipCode.equals(that.zipCode) : that.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (county != null ? county.hashCode() : 0);
        result = 31 * result + (phoneNo != null ? phoneNo.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }
}