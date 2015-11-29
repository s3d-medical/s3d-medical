package com.s3d.auth.acl.vo;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/7 14:44
 */
public class OrgVO implements Serializable{
    private static final long serialVersionUID = -5159328525146567331L;
    private Integer id;
    private String name;
    private Integer parentId;
    private String code;
    private String key;
    private String remark;
    private Integer active;
    private Integer order;
    private String parentName;

    public OrgVO() {

    }

    /**
     *
     * @param id
     * @param code
     * @param name
     * @param active
     * @param remark
     * @param order
     * @param parentId
     * @param parentName
     */
    public OrgVO(Integer id,  String code, String key, String name, Integer active, String remark, Integer order, Integer parentId, String parentName) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.code = code;
        this.key = key;
        this.remark = remark;
        this.active = active;
        this.order = order;
        this.parentName = parentName;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

}
