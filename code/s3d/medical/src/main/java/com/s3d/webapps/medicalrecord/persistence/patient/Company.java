package com.s3d.webapps.medicalrecord.persistence.patient;



import com.s3d.tech.data.po.AbstractGeneralProperties;

import javax.persistence.*;

/**
 * @author Administrator
 * @version 1.0
 * @created 09-����-2015 18:55:33
 */
@Entity
@Table(name="p_company")
public class Company  extends AbstractGeneralProperties {

    @Column(name="name")
	private String name;

    @Column(name="address")
	private String address;

    @Column(name="phone_no")
	private String phoneNo;

    @Column(name="zip_code")
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