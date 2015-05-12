package com.s3d.webapps.da.patient.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="p_registered_residence")
public class RegisteredResidence extends BaseAddress {
    @Column(name="county")
    private Integer county;

    @Column(name="zip_code")
    private String zipCode;

	public RegisteredResidence(){

	}

    public int getCounty() {
        return county;
    }

    public void setCounty(int county) {
        this.county = county;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}