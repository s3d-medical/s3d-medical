package com.s3d.webapps.da.patient.persistence;

/**
 * @author Administrator
 * @version 1.0
 * @created 09-����-2015 18:55:33
 */
public class Company {

	private String name;
	private String address;
	private String phoneNo;
	private String zipCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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