package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleBasicVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private Integer id;

    private String name;

    private String remark;

    private String state;

    private String categoryId;

    private String createId;

    public RoleBasicVO() {
    }

    public RoleBasicVO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.remark = role.getDesc();
        if(role.getState() != null){
            this.state = role.getState().toString();
        }else{
            this.state = "";
        }
        if(role.getCategory() != null && role.getCategory().getId() != null){
            this.categoryId = "" + role.getCategory().getId();
        }else{
            this.categoryId = "";
        }
        this.createId = this.getCreateId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleBasicVO)) return false;

        RoleBasicVO that = (RoleBasicVO) o;

        if (categoryId != null ? !categoryId.equals(that.categoryId) : that.categoryId != null) return false;
        if (createId != null ? !createId.equals(that.createId) : that.createId != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (createId != null ? createId.hashCode() : 0);
        return result;
    }
}
