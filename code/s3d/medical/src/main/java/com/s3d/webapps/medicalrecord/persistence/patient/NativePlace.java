package com.s3d.webapps.medicalrecord.persistence.patient;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="p_native_place")
@PrimaryKeyJoinColumn(name = "native_place_id")
public class NativePlace extends BaseAddress {
    @Override
    protected void fill(String province, String city) {
        super.fill(province, city);
    }

}