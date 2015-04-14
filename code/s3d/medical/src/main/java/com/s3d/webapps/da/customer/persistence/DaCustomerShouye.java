package com.s3d.webapps.da.customer.persistence;

import java.util.Date;

import net.sf.cglib.transform.impl.InterceptFieldEnabled;

import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.da.config.persistence.DaConfigPtemplate;

/**
 * 数字首页
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaCustomerShouye extends BaseEntityObject implements InterceptFieldEnabled {
	
	/**
	 * 录入时间
	 */
	protected Date fdCreateTime;
	
	/**
	 * @return 录入时间
	 */
	public Date getFdCreateTime() {
		return fdCreateTime;
	}
	
	/**
	 * @param fdCreateTime 录入时间
	 */
	public void setFdCreateTime(Date fdCreateTime) {
		this.fdCreateTime = fdCreateTime;
	}
	
	/**
	 * 更新时间
	 */
	protected Date fdLastModifiedTime;
	
	/**
	 * @return 更新时间
	 */
	public Date getFdLastModifiedTime() {
		return fdLastModifiedTime;
	}
	
	/**
	 * @param fdLastModifiedTime 更新时间
	 */
	public void setFdLastModifiedTime(Date fdLastModifiedTime) {
		this.fdLastModifiedTime = fdLastModifiedTime;
	}
	
	/**
	 * 病案号
	 */
	protected String fdFileNo;
	
	/**
	 * @return 病案号
	 */
	public String getFdFileNo() {
		return fdFileNo;
	}
	
	/**
	 * @param fdFileNo 病案号
	 */
	public void setFdFileNo(String fdFileNo) {
		this.fdFileNo = fdFileNo;
	}
	
	/**
	 * 盘号
	 */
	protected DaCustomerLabel fdLabel;
	
	
	public DaCustomerLabel getFdLabel() {
		return fdLabel;
	}

	public void setFdLabel(DaCustomerLabel fdLabel) {
		this.fdLabel = fdLabel;
	}

	/**
	 * 图片
	 */
	protected DaCustomerPicture fdPicture;

	public DaCustomerPicture getFdPicture() {
		return fdPicture;
	}

	public void setFdPicture(DaCustomerPicture fdPicture) {
		this.fdPicture = fdPicture;
	}
	
	protected DaConfigPtemplate fdTemplate;

	public DaConfigPtemplate getFdTemplate() {
		return fdTemplate;
	}

	public void setFdTemplate(DaConfigPtemplate fdTemplate) {
		this.fdTemplate = fdTemplate;
	}
}
