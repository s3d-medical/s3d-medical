package com.s3d.tech.data.po;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author  wind
 * @date 2015/5/13.
 */
public abstract class AbstractGeneralProperties implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractGeneralProperties)) return false;

        AbstractGeneralProperties that = (AbstractGeneralProperties) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
