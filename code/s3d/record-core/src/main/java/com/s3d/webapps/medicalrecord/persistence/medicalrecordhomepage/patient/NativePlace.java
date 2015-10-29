package com.s3d.webapps.medicalrecord.persistence.medicalrecordhomepage.patient;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "NativePlace")
public class NativePlace extends BaseAddress {
    @Override
    protected void fill(String province, String city) {
        super.fill(province, city);
    }

}