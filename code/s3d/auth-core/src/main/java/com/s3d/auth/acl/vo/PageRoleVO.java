package com.s3d.auth.acl.vo;

import java.io.Serializable;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class PageRoleVO extends RoleBasicVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;

    private String category;

    private String creator;

    public PageRoleVO() {

    }

    public PageRoleVO(Integer id, String name, String desc) {
        this.setId(id.toString());
        this.setName(name);
        this.setRemark(desc);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
