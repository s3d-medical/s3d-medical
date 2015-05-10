package com.s3d.webapps.da.patient.persistence;

/**
 * @author wind.chen
 * @version 1.0
 * @created  -2015 10:17:02
 */
public class BaseAddress {

	private String province;
	private String city;

	public BaseAddress(){

	}

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}//end BaseAddress