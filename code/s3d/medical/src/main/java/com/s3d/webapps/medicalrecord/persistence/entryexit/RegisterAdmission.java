package com.s3d.webapps.medicalrecord.persistence.entryexit;

import javax.persistence.*;
import java.util.Date;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_register_admission")
public class RegisterAdmission extends BaseRegister {

    @Column(name="approach")
	private String approach;

	public RegisterAdmission(){

	}

    public void fill(Date registeredTime, String depart, String sickRoomNo, String approach) {
        super.fill(registeredTime, depart, sickRoomNo);
        this.approach = approach;
    }

    public String getApproach() {
        return approach;
    }

    public void setApproach(String approach) {
        this.approach = approach;
    }
}