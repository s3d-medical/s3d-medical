package com.s3d.auth.acl.vo;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/7 14:44
 */
public class OrgVO implements Serializable{
    private Integer id;
    private String name;
    private Integer parentId;
    private String code;
    private String remark;
    private Boolean active;

    public OrgVO() {

    }

    public OrgVO(Integer id, String name, String code, String remark, Boolean active, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.code = code;
        this.remark = remark;
        this.active = active;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
