package com.s3d.auth.acl.vo.param;

import java.io.Serializable;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class QueryRoleParam implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private Integer id;

    private String name;

    private String remark;

    private Integer state;

    private Integer categoryId;

    private Integer createId;

    public QueryRoleParam() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}
