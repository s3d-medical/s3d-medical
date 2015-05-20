package com.s3d.webapps.medicalrecord.persistence.diagnosis;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author wind.chen
 * @version 1.0
 * parent holds public properties, other properties in subclass.
 */
@Entity
@Table(name = "mr_diagnosis")
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseDiagnose implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "name")
    protected String name;

    @Column(name = "code")
    protected String code;


    public BaseDiagnose() {

    }

    public BaseDiagnose(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void fill(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDiagnose)) return false;
        if (!super.equals(o)) return false;

        BaseDiagnose that = (BaseDiagnose) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }
}