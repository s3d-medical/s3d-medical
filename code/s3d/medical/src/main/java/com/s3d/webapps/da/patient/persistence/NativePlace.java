package com.s3d.webapps.da.patient.persistence;

/**
 * @author wind.chen
 * @version 1.0
 */

public class NativePlace extends BaseAddress {

	private String zipCode;
	private String county;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}