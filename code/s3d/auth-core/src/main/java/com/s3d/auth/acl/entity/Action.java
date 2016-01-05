package com.s3d.auth.acl.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/11/1 14:08
 */
@Entity
@Table(name = "auth_action")
public class Action implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "action_name")
    private String actionName;

    /*@Column(name = "module_no")
    private String moduleNo;*/

    @Column(name = "page_no")
    private String pageNo;

    @Column(name="state")
    private Integer state;

    @ManyToMany(mappedBy = "actions", cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<Role>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_no", referencedColumnName = "id")
    private Module module;

    public Action() {
    }

    public Action(Integer id, String actionName, Module module, String pageNo, Integer state) {
        this.id = id;
        this.pageNo = pageNo;
        this.actionName = actionName;
        this.module = module;
        this.state = state;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
