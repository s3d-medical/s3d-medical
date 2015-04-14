package com.s3d.webapps.da.config.persistence;

import java.util.Date;

import com.s3d.webapps.common.entity.BaseEntityObject;

/**
 * 首页模版
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaConfigPtemplate extends BaseEntityObject {
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
	 * @param fdName 名称
	 */
	public void setFdName(String fdName) {
		this.fdName = fdName;
	}
	
	/**
	 * 版本
	 */
	protected Integer fdVersion;
		
	public Integer getFdVersion() {
		return fdVersion;
	}

	public void setFdVersion(Integer fdVersion) {
		this.fdVersion = fdVersion;
	}

	/**
	 * HTML模版内容
	 */
	protected String fdHTMLContent;	

	public String getFdHTMLContent() {
		return (String) readLazyField("fdHTMLContent", fdHTMLContent);
	}

	public void setFdHTMLContent(String fdHTMLContent) {
		this.fdHTMLContent = (String) writeLazyField("fdHTMLContent",
				this.fdHTMLContent, fdHTMLContent);
	}

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
	
	
}
