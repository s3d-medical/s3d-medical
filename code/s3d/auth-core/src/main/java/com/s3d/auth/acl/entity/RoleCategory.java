package com.s3d.auth.acl.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/12/3 7:52
 */
@Entity
@Table(name="auth_role_category")
public class RoleCategory implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="remark")
    private String remark;

    public RoleCategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
