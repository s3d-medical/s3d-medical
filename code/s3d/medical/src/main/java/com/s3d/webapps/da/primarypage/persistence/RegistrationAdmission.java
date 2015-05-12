package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_register_admission")
public class RegistrationAdmission extends Register {

    @Column(name="approach")
	private Integer approach;

	public RegistrationAdmission(){

	}

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }
}