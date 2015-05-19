package com.s3d.webapps.medicalrecord.persistence.patient;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Administrator
 * @version 1.0
 * @created 09-����-2015 18:55:33
 */
@Entity
@Table(name="p_company")
public class Company implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name="name")
	private String name;

    @Column(name="address")
	private String address;

    @Column(name="phone_no")
	private String phoneNo;

    @Column(name="zip_code")
	private String zipCode;

    public Company() {
    }

    public void fill(String name, String address, String phoneNo, String zipCode) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.zipCode = zipCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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