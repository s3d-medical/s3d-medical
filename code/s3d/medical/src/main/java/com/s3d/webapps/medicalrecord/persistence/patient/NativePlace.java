package com.s3d.webapps.medicalrecord.persistence.patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="p_native_place")
public class NativePlace extends BaseAddress {
    @Column(name="county")
    private Integer county;

    public Integer getCounty() {
        return county;
    }

    public void setCounty(Integer county) {
        this.county = county;
    }
}