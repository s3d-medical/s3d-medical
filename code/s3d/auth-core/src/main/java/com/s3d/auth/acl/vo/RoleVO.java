package com.s3d.auth.acl.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;
    private Integer id;

    private String name;

    private String desc;

    private Integer state;

    private List<ActionVO> permissions;

    private List<UserVO> users;

    public RoleVO() {

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<ActionVO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<ActionVO> permissions) {
        this.permissions = permissions;
    }

    public List<UserVO> getUsers() {
        return users;
    }

    public void setUsers(List<UserVO> users) {
        this.users = users;
    }
}
