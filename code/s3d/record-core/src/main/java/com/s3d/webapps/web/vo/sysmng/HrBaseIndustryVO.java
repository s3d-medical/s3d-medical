package com.s3d.webapps.web.vo.sysmng;

import java.util.Date;

import com.s3d.webapps.web.vo.BaseEntityVO;

public class HrBaseIndustryVO extends BaseEntityVO {
	/**
	 * 名称
	 */
	protected String fdName;
	/**
	 * 编号
	 */
	protected String fdNo;
	/**
	 * 创建时间
	 */
	protected Date fdCreateTime;
	/**
	 * 描述
	 */
	protected String fdDescription;
	/**
	 * 上级分类
	 */
	protected String fdParentId;
	protected String fdParentName;
	
	public String getFdName() {
		return fdName;
	}
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	public String getFdNo() {
		return fdNo;
	}
	public void setFdNo(String fdNo) {
		this.fdNo = fdNo;
	}
	public Date getFdCreateTime() {
		return fdCreateTime;
	}
	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
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
	public String getFdParentName() {
		return fdParentName;
	}
	public void setFdParentName(String fdParentName) {
		this.fdParentName = fdParentName;
	}
}
