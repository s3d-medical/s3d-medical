package com.s3d.auth.acl.vo.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleBasicInfoVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private String id;

    private String name;

    private String remark;

    private Integer state;

    private String category;

    private Integer getCategoryId;

    private Integer createId;

    private String creator;

    public RoleBasicInfoVO() {

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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getGetCategoryId() {
        return getCategoryId;
    }

    public void setGetCategoryId(Integer getCategoryId) {
        this.getCategoryId = getCategoryId;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
