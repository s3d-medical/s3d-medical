package com.s3d.webapps.config.persistence;

import javax.persistence.*;

/**
 * Created by Gary.Feng on 2015/7/21.
 */
@Entity
@Table(name = "da_config_operation")
public class ConfigOperation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "code")
    protected String code;

    @Column(name = "name")
    protected String name;

    @Column(name = "grade")
    protected Integer grade;

    @Column(name = "hospital_id")
    protected String hospitalId;

    @Column(name = "shortcut")
    protected String shortcut;

    @Column(name = "status")
    protected Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
