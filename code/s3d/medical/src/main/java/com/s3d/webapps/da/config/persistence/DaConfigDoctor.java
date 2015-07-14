package com.s3d.webapps.da.config.persistence;

import javax.persistence.*;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Entity
@Table(name = "da_config_doctor")
public class DaConfigDoctor {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Integer id;

    @Column(name = "hospital_id")
    protected String hospitalId;

    @Column(name = "department_id")
    protected String departmentId;

    @Column(name = "position")
    protected String position;

    @Column(name = "name")
    protected String name;

    @Column(name = "shortcut")
    protected String shortcut;

    @Column(name = "status")
    protected String status;

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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
