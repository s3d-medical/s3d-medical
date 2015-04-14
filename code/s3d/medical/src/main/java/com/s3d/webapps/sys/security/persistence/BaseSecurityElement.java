package com.s3d.webapps.sys.security.persistence;

import java.util.Date;

import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.util.ModelUtil;
import com.s3d.webapps.util.ObjectUtil;

/**
 * 人员组织基类
 * 
 * @author 
 * @version 1.0 2013-05-05
 */
public class BaseSecurityElement extends BaseEntityObject {
	protected String fdName; //名称
	protected Integer fdOrgType; //类型
	protected Boolean fdIsAvailable; //是否有效
	protected String fdHierarchyId; //层级ID
	protected Date fdCreateTime; //创建时间
	protected Date fdAlterTime; //最后修改时间
	protected String fdParentId; //上级分类ID
	protected BaseSecurityElement fdParent;
	/**
	 * @return 名称
	 */
	public String getFdName() {
		return fdName;
	}
	
	/**
	 * @param fdName 名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
		
	/**
	 * @return 类型
	 */
	public Integer getFdOrgType() {
		return fdOrgType;
	}
	
	/**
	 * @param fdOrgType 类型
	 */
	public void setFdOrgType(Integer fdOrgType) {
		this.fdOrgType = fdOrgType;
	}
	
	/**
	 * @return 是否有效
	 */
	public Boolean getFdIsAvailable() {
		return fdIsAvailable;
	}
	
	/**
	 * @param fdIsAvailable 是否有效
	 */
	public void setFdIsAvailable(Boolean fdIsAvailable) {
		this.fdIsAvailable = fdIsAvailable;
	}
	
	/**
	 * @return 层级ID
	 */
	public String getFdHierarchyId() {
		return fdHierarchyId;
	}
	
	/**
	 * @param fdHierarchyId 层级ID
	 */
	public void setFdHierarchyId(String fdHierarchyId) {
		this.fdHierarchyId = fdHierarchyId;
	}

	/**
	 * @return 创建时间
	 */
	public Date getFdCreateTime() {
		return fdCreateTime;
	}
	
	/**
	 * @param fdCreateTime 创建时间
	 */
	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}

	/**
	 * @return 最后修改时间
	 */
	public Date getFdAlterTime() {
		return fdAlterTime;
	}
	
	/**
	 * @param fdAlterTime 最后修改时间
	 */
	public void setFdAlterTime(Date fdAlterTime) {
		this.fdAlterTime = fdAlterTime;
	}

    public String getFdParentId() {
        return fdParentId;
    }

    public void setFdParentId(String fdParentId) {
        this.fdParentId = fdParentId;
    }

    public BaseSecurityElement getFdParent() {
		return getHbmParent();
	}

	public void setFdParent(BaseSecurityElement parent) {
		if (!ObjectUtil.equals(getHbmParent(), parent)) {
			ModelUtil.checkTreeCycle(this, parent, "fdParent");
			setHbmParent(parent);
		}
	}

	public BaseSecurityElement getHbmParent() {
		return fdParent;
	}

	public void setHbmParent(BaseSecurityElement parent) {
		this.fdParent = parent;
	}
}
