package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.User;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author  gary.feng
 * @since 2016/1/12.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserActionsVO implements Serializable {
    private static final long serialVersionUID = 6578526809587873686L;
    private Integer id;
    private String name;
    private String remark;
    private List<Map> permissionCategories;
    private String[] departments;

    public UserActionsVO() {

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Map> getPermissionCategories() {
        return permissionCategories;
    }

    public void setPermissionCategories(List<Map> permissionCategories) {
        this.permissionCategories = permissionCategories;
    }

    public String[] getDepartments() {
        return departments;
    }

    public void setDepartments(String[] departments) {
        this.departments = departments;
    }
}
