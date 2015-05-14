package com.s3d.webapps.da.mrhomepage.persistence.inOrout;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_register_admission")
public class RegisterAdmission extends BaseRegister {

    @Column(name="approach")
	private Integer approach;

	public RegisterAdmission(){

	}

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }
}