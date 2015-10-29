package com.s3d.webapps.da.customer.persistence;

import java.util.Date;

import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.util.ModelUtil;
import com.s3d.webapps.util.ObjectUtil;

/**
 * 客户信息
 * 
 * @author
 * @version 1.0 2014-08-15
 */
public class DaCustomerHospital extends BaseEntityObject {

	/**
	 * 编码
	 */
	protected String fdCode;

	/**
	 * @return 编码
	 */
	public String getFdCode() {
		return fdCode;
	}

	/**
	 * @param fdCode
	 *            编码
	 */
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}

	/**
	 * 名称
	 */
	protected String fdName;

	/**
	 * @return 名称
	 */
	public String getFdName() {
		return fdName;
	}

	/**
	 * @param fdName
	 *            名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}

	/**
	 * 描述
	 */
	protected String fdDescription;

	/**
	 * @return 描述
	 */
	public String getFdDescription() {
		return fdDescription;
	}

	/**
	 * @param fdDescription
	 *            描述
	 */
	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
	}

	/**
	 * 创建时间
	 */
	protected Date docCreateTime;

	/**
	 * @return 创建时间
	 */
	public Date getDocCreateTime() {
		return docCreateTime;
	}

	/**
	 * @param docCreateTime
	 *            创建时间
	 */
	public void setDocCreateTime(Date docCreateTime) {
		this.docCreateTime = docCreateTime;
	}

	protected Integer fdOrgType = HospitalOrgConstant.HSP_TYPE_HOSPITAL; // 类型
	protected String fdHierarchyId; // 层级ID
	protected DaCustomerHospital fdParent;

	public Integer getFdOrgType() {
		return fdOrgType;
	}

	public void setFdOrgType(Integer fdOrgType) {
		this.fdOrgType = fdOrgType;
	}

	public String getFdHierarchyId() {
		return fdHierarchyId;
	}

	public void setFdHierarchyId(String fdHierarchyId) {
		this.fdHierarchyId = fdHierarchyId;
	}

	public DaCustomerHospital getFdParent() {
		return getHbmParent();
	}

	public void setFdParent(DaCustomerHospital parent) {
		if (!ObjectUtil.equals(getHbmParent(), parent)) {
			ModelUtil.checkTreeCycle(this, parent, "fdParent");
			setHbmParent(parent);
		}
	}

	public DaCustomerHospital getHbmParent() {
		return fdParent;
	}

	public void setHbmParent(DaCustomerHospital parent) {
		this.fdParent = parent;
	}
	
	protected Date fdAlterTime; //最后修改时间

	public Date getFdAlterTime() {
		return fdAlterTime;
	}

	public void setFdAlterTime(Date fdAlterTime) {
		this.fdAlterTime = fdAlterTime;
	}
	
	
}
