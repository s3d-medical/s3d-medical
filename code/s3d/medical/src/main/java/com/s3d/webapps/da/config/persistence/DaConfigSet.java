package com.s3d.webapps.da.config.persistence;

import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.component.forms.DataDictionary;

/**
 * 数据字典
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public class DaConfigSet extends BaseEntityObject implements DataDictionary{

	/**
	 * 数据类型
	 */
	protected String fdType;
	
	/**
	 * @return 数据类型
	 */
	public String getFdType() {
		return fdType;
	}
	
	/**
	 * @param fdType 数据类型
	 */
	public void setFdType(String fdType) {
		this.fdType = fdType;
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

	@Override
	public String getValue() {
		return getFdCode();
	}

	@Override
	public String getText() {
		return getFdName();
	}

	@Override
	public String getShortcut() {
		return getFdShortcut();
	}
}
