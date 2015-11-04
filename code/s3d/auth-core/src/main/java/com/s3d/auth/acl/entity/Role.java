package com.s3d.auth.acl.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.entity
 * @date 2015/11/1 14:19
 */
@Entity
@Table(name = "auth_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "state")
    private Boolean state;

    // action set.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_role_action",
            joinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_action_id", referencedColumnName = "id")
    )
    private Set<Action> actions = new HashSet<Action>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(String id, String name, String desc, boolean state) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
