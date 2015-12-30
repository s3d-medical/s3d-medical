package com.s3d.auth.acl.entity;

import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
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
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "`desc`")
    private String desc;

    @Column(name = "state")
    private Integer state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="creator", referencedColumnName = "id")
    private User creator;

    // action set.
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_role_action",
            joinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_action_id", referencedColumnName = "id")
    )
    private Set<Action> actions = new HashSet<Action>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private RoleCategory category;

    public Role() {
    }

    public Role(Integer id, String name, String desc, String state) {
        if(!StringUtils.isEmpty(id)){
            this.id = id;
        }
        this.name = name;
        this.desc = desc;
        if(!StringUtils.isEmpty(state)){
            this.state = Integer.parseInt(state);
        }else{
            this.state = 1;
        }
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public RoleCategory getCategory() {
        return category;
    }

    public void setCategory(RoleCategory category) {
        this.category = category;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void addedActions(Collection<Action> addedActions){
        if(this.actions == null){
            this.actions = new HashSet<Action>();
        }
        if(addedActions != null && addedActions.size() > 0 ){
            this.actions.addAll(addedActions);
        }
    }

    public void addUsers(Collection<User> addedUsers){
        if(this.users == null){
            this.users = new HashSet<User>();
        }
        if(addedUsers != null && addedUsers.size() > 0){
            this.users.addAll(addedUsers);
        }
    }

}
