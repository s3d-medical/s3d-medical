package com.s3d.webapps.medicalrecord.patient.persistence;

import com.s3d.tech.data.persistence.AbstractGeneralProperties;

import javax.persistence.Column;

/**
 * @author wind.chen
 * @version 1.0
 * @created  -2015 10:17:02
 */
public class BaseAddress extends AbstractGeneralProperties {

    @Column(name="province")
	private Integer province;

    @Column(name="city")
    private Integer city;

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

}