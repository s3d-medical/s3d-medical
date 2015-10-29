package com.s3d.webapps.da.config.persistence;

import com.s3d.webapps.common.entity.BaseEntityObject;

/**
 * OCR规则
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaConfigOcrRule extends BaseEntityObject {

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
	 * 优先级
	 */
	protected Integer fdOrder;
	
	/**
	 * @return 优先级
	 */
	public Integer getFdOrder() {
		return fdOrder;
	}
	
	/**
	 * @param fdOrder 优先级
	 */
	public void setFdOrder(Integer fdOrder) {
		this.fdOrder = fdOrder;
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
	 * 关键字
	 */
	protected String fdKeyword;
	
	/**
	 * @return 关键字
	 */
	public String getFdKeyword() {
		return fdKeyword;
	}
	
	/**
	 * @param fdKeyword 关键字
	 */
	public void setFdKeyword(String fdKeyword) {
		this.fdKeyword = fdKeyword;
	}
	
	/**
	 * 是否正则表达式
	 */
	protected Boolean fdIsRegex;
	
	/**
	 * @return 是否正则表达式
	 */
	public Boolean getFdIsRegex() {
		return fdIsRegex;
	}
	
	/**
	 * @param fdIsRegex 是否正则表达式
	 */
	public void setFdIsRegex(Boolean fdIsRegex) {
		this.fdIsRegex = fdIsRegex;
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
	 * 病案分类
	 */
	protected DaConfigCategory fdCategory;
	
	/**
	 * @return 病案分类
	 */
	public DaConfigCategory getFdCategory() {
		return fdCategory;
	}
	
	/**
	 * @param fdCategory 病案分类
	 */
	public void setFdCategory(DaConfigCategory fdCategory) {
		this.fdCategory = fdCategory;
	}
}
