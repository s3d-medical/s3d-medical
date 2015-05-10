package com.s3d.webapps.da.patient.persistence;

/**
 * @author wind.chen
 * @version 1.0
 * @created 2015 10:24:46
 */
public class ContactPerson {

	private String relationship;
	private String fullName;
	private String address;
	private String phoneNo;

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}