package com.s3d.auth.acl.vo;

import java.io.Serializable;
import java.util.List;

/**
 * New created or updated roles.
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleAddedVO extends RoleBasicVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private List<Integer> permissions;

    private List<Integer> users;

    public RoleAddedVO() {

    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public List<Integer> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Integer> permissions) {
        this.permissions = permissions;
    }
}
