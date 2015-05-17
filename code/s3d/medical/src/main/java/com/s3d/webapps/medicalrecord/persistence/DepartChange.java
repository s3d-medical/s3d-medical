package com.s3d.webapps.medicalrecord.persistence;


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
    @Column(name = "id")
    protected Integer id;

    @Column(name="departs")
	private String departs;

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}