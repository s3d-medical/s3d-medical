package com.s3d.webapps.da.patient.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 * @created 10-����-2015 10:24:44
 */
@Entity
@Table(name="p_present_address")
public class PresentAddress extends BaseAddress {

    @Column(name="county")
    private Integer county;

    @Column(name = "phone_no")
	private String phoneNo;

    @Column(name="zip_code")
	private String zipCode;

    public int getCounty() {
        return county;
    }

    public void setCounty(int county) {
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
}