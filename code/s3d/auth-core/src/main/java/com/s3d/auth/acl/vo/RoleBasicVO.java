package com.s3d.auth.acl.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleBasicVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private String id;

    private String name;

    private String remark;

    private String state;

    private String categoryId;

    private String createId;

    public RoleBasicVO() {
    }

    public RoleBasicVO(String id, String name, String remark, String state, String categoryId, String createId) {
        this.id = id;
        this.name = name;
        this.remark = remark;
        this.state = state;
        this.categoryId = categoryId;
        this.createId = createId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }
}
