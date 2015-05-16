package com.s3d.webapps.medicalrecord.persistence;


import com.s3d.tech.data.po.AbstractGeneralProperties;

import javax.persistence.*;

/**
 * @author wind.chen
 * @version 1.0
 */
@Entity
@Table(name="mr_depart_change")
public class DepartChange  extends AbstractGeneralProperties {

    @Column(name="departs")
	private String departs;

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepartChange)) return false;

        DepartChange that = (DepartChange) o;

        if (departs != null ? !departs.equals(that.departs) : that.departs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return departs != null ? departs.hashCode() : 0;
    }
}