package com.s3d.auth.acl.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleVO implements Serializable{

    private String id;

    private String name;

    private String desc;

    private Boolean state;

    private List<ActionVO> actions;

    public RoleVO() {

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

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<ActionVO> getActions() {
        return actions;
    }

    public void setActions(List<ActionVO> actions) {
        this.actions = actions;
    }
}
