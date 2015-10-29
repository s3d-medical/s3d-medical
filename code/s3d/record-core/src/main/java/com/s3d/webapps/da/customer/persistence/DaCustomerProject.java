package com.s3d.webapps.da.customer.persistence;

import com.s3d.webapps.constant.HospitalOrgConstant;


/**
 * 项目信息
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaCustomerProject extends DaCustomerHospital {
	public DaCustomerProject() {
		super();
		setFdOrgType(new Integer(HospitalOrgConstant.HSP_TYPE_PROJECT));
	}
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
	 * @param fdCode 编码
	 */
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}
}
