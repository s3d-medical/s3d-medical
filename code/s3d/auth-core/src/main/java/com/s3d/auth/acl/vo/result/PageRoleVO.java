package com.s3d.auth.acl.vo.result;

import java.io.Serializable;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class PageRoleVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;
    private Integer id;

    private String name;

    private String desc;

    private String category;

    private String creator;

    public PageRoleVO() {

    }

    public PageRoleVO(Integer id, String name, String desc, String category, String creator) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.creator = creator;
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
