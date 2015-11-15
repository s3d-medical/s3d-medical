package com.s3d.auth.acl.vo;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/7 14:44
 */
public class OrgExtVO extends OrgVO{

    private Integer order;
    private String parentName;

    public OrgExtVO() {

    }

    /**
     *
     * @param id
     * @param name
     * @param code
     * @param remark
     * @param active
     * @param parentId
     * @param parentName
     * @param order
     */
    public OrgExtVO(Integer id, String name, String code, String remark, Boolean active, Integer parentId,
                   String parentName, Integer order) {
        super(id, name, code, remark, active, parentId);
        this.parentName = parentName;
        this.order = order;
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
