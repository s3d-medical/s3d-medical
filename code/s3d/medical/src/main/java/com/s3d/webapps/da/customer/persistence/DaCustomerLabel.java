package com.s3d.webapps.da.customer.persistence;

import java.util.Date;

import com.s3d.webapps.constant.HospitalOrgConstant;

/**
 * 盘号信息
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaCustomerLabel extends DaCustomerHospital {
	public DaCustomerLabel() {
		super();
		setFdOrgType(new Integer(HospitalOrgConstant.HSP_TYPE_LABEL));
	}
	/**
	 * 盘号
	 */
	protected String fdName;
	
	/**
	 * @return 盘号
	 */
	public String getFdName() {
		return fdName;
	}
	
	/**
	 * @param fdName 盘号
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 存档日期
	 */
	protected Date fdCreateTime;
	
	/**
	 * @return 存档日期
	 */
	public Date getFdCreateTime() {
		return fdCreateTime;
	}
	
	/**
	 * @param fdCreateTime 存档日期
	 */
	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}
	
	/**
	 * 文件数
	 */
	protected Integer fdFileCount;
	
	/**
	 * @return 文件数
	 */
	public Integer getFdFileCount() {
		return fdFileCount;
	}
	
	/**
	 * @param fdFileCount 文件数
	 */
	public void setFdFileCount(Integer fdFileCount) {
		this.fdFileCount = fdFileCount;
	}
	
	/**
	 * 最小光点数
	 */
	protected String fdFrom;
	
	/**
	 * @return 最小光点数
	 */
	public String getFdFrom() {
		return fdFrom;
	}
	
	/**
	 * @param fdFrom 最小光点数
	 */
	public void setFdFrom(String fdFrom) {
		this.fdFrom = fdFrom;
	}
	
	/**
	 * 最大光点数
	 */
	protected String fdTo;
	
	/**
	 * @return 最大光点数
	 */
	public String getFdTo() {
		return fdTo;
	}
	
	/**
	 * @param fdTo 最大光点数
	 */
	public void setFdTo(String fdTo) {
		this.fdTo = fdTo;
	}
	
	/**
	 * 状态
	 */
	protected Integer fdStatus;
	
	/**
	 * @return 状态
	 */
	public Integer getFdStatus() {
		return fdStatus;
	}
	
	/**
	 * @param fdStatus 状态
	 */
	public void setFdStatus(Integer fdStatus) {
		this.fdStatus = fdStatus;
	}
}
