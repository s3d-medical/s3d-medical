package com.s3d.webapps.da.patient.persistence;

/**
 * @author wind.chen
 * @version 1.0
 * @created 10-����-2015 10:24:44
 */
public class PresentAddress extends BaseAddress {

	private String phoneNo;
	private String county;
	private String zipCode;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
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
}