package com.s3d.webapps.web.vo.da.customer;

import com.s3d.webapps.web.vo.BaseEntityVO;

public class DaCustomerHospitalVo extends BaseEntityVO{
	protected String fdName;
	protected String fdCode;
	protected String fdDescription;
	protected String fdParentId;
	public String getFdName() {
		return fdName;
	}
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	public String getFdCode() {
		return fdCode;
	}
	public void setFdCode(String fdCode) {
		this.fdCode = fdCode;
	}
	public String getFdDescription() {
		return fdDescription;
	}
	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
	}
	public String getFdParentId() {
		return fdParentId;
	}
	public void setFdParentId(String fdParentId) {
		this.fdParentId = fdParentId;
	}
	
}
