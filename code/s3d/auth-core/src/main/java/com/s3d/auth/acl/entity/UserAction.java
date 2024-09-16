package com.s3d.auth.acl.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Gary.Feng on 2016/1/14.
 */
@Entity
@Table(name = "auth_user_action")
public class UserAction {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "auth_user_id")
    private Integer userId;

    @Column(name = "auth_action_id")
    private Integer actionId;

    @Column(name = "created_time")
    private Date createdTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
