package com.s3d.auth.acl.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/11/1 14:23
 */
@Entity
@Table(name = "auth_user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String pwd;

    @Column(name = "registered_time")
    private Date registerTime;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "state")
    private Integer state;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "code")
    private String code;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tel")
    private String tel;

    @Column(name = "`key`")
    private String key;

    @Column(name = "remark")
    private String remark;

    @Column(name = "language_id")
    private Integer languageId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auth_org_id", referencedColumnName = "id")
    private Org org;

    @ManyToMany()
    @JoinTable(name = "auth_user_role",
            joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id") )
    private Set<Role> roles = new HashSet<Role>();

    public User() {
    }

    public User(String loginName, Integer state,
                String fullName, String code, String email, String phone, String tel, String key, String remark, Integer languageId, Org org) {
        this.loginName = loginName;
        this.state = state;
        this.fullName = fullName;
        this.code = code;
        this.email = email;
        this.phone = phone;
        this.tel = tel;
        this.key = key;
        this.remark = remark;
        this.languageId = languageId;
        this.org = org;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    @Transient
    public String getOrgName() {
        if (this.getOrg() != null) {
            return this.getOrg().getName();
        }
        return null;
    }

    @Transient
    public Integer getOrgId() {
        if (this.getOrg() != null) {
            return this.getOrg().getId();
        }
        return null;
    }

}
