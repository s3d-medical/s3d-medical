package com.s3d.auth.acl.entity;

import javax.persistence.*;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/11/7 15:01
 */
@Entity
@Table(name = "auth_org")
public class Org {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="desc")
    private String desc;

    @Column(name="code")
    private String code;

    @Column(name="status")
    private Integer status;

    private Org parent;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Org getParent() {
        return parent;
    }

    public void setParent(Org parent) {
        this.parent = parent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
