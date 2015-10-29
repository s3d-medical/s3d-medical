package com.s3d.webapps.da.config.persistence;

import com.s3d.webapps.common.entity.BaseEntityObject;

/**
 * 病案分类
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaConfigCategory extends BaseEntityObject {

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
	
	/**
	 * 快捷键
	 */
	protected String fdShortcut;
	
	/**
	 * @return 快捷键
	 */
	public String getFdShortcut() {
		return fdShortcut;
	}
	
	/**
	 * @param fdShortcut 快捷键
	 */
	public void setFdShortcut(String fdShortcut) {
		this.fdShortcut = fdShortcut;
	}
	
	/**
	 * 所属客户或项目
	 */
	protected String fdExclusive;
	
	/**
	 * @return 所属客户或项目
	 */
	public String getFdExclusive() {
		return fdExclusive;
	}
	
	/**
	 * @param fdExclusive 所属客户或项目
	 */
	public void setFdExclusive(String fdExclusive) {
		this.fdExclusive = fdExclusive;
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
	
	/**
	 * 类型
	 */
	protected Integer fdType;

	public Integer getFdType() {
		return fdType;
	}

	public void setFdType(Integer fdType) {
		this.fdType = fdType;
	}
	
}
