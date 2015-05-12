package com.s3d.webapps.da.primarypage.persistence;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_depart_change")
public class DepartChange {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="departs")
	private String departs;

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }
}