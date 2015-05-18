package com.s3d.webapps.medicalrecord.persistence.patient;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@DiscriminatorValue(value = "native")
public class NativePlace extends BaseAddress {


}