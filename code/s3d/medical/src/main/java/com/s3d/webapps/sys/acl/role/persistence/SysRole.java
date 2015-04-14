package com.s3d.webapps.sys.acl.role.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.s3d.webapps.cache.ehcache.WebAppCache;
import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.sys.security.persistence.BaseSecurityElement;

public class SysRole extends BaseEntityObject{
	
	private String fdName;
	
	private Boolean fdIsSysRole;
	/*
	 * 别名
	 */
	private String fdAlias;
	/*
	 * 描述
	 */
	private String fdDescription;
	/*
	 * 模块
	 */
	private String fdModulePath;
	/*
	 * 具有该角色的组织架构元素
	 */
	private List<BaseSecurityElement> fdOrgElements;
	/*
	 * 我继承的角色
	 */
	private List<SysRole> fdInhRoles;
	/*
	 * 继承我的角色
	 */
	private List<SysRole> fdRolesInh;
		
	public String getFdName() {
		return fdName;
	}

	public void setFdName(String fdName) {
		this.fdName = fdName;
	}

	public String getFdAlias() {
		return fdAlias;
	}

	public void setFdAlias(String fdAlias) {
		this.fdAlias = fdAlias;
	}

	public String getFdDescription() {
		return fdDescription;
	}

	public void setFdDescription(String fdDescription) {
		this.fdDescription = fdDescription;
	}

	public String getFdModulePath() {
		return fdModulePath;
	}

	public void setFdModulePath(String fdModulePath) {
		this.fdModulePath = fdModulePath;
	}
	
	public List<BaseSecurityElement> getHbmOrgElements() {
		return fdOrgElements;
	}

	public void setHbmOrgElements(List<BaseSecurityElement> orgElements) {
		this.fdOrgElements = orgElements;
	}
	
	public List<BaseSecurityElement> getFdOrgElements() {
		List<BaseSecurityElement> rtnVal = new ArrayList<BaseSecurityElement>();
		if (getHbmOrgElements() != null)
			rtnVal.addAll(getHbmOrgElements());
		return rtnVal;
	}

	public void setFdOrgElements(List<BaseSecurityElement> orgelements) {
		new WebAppCache(SysRole.class).clear();
		if (this.fdOrgElements == null)
			this.fdOrgElements = new ArrayList<BaseSecurityElement>();
		else
			this.fdOrgElements.clear();
		if (orgelements != null)
			this.fdOrgElements.addAll(orgelements);
	}
	
	public List<SysRole> getHbmInhRoles() {
		return fdInhRoles;
	}

	public void setHbmInhRoles(List<SysRole> inhRoles) {
		this.fdInhRoles = inhRoles;
	}
	
	public List<SysRole> getFdInhRoles() {
		List<SysRole> rtnVal = new ArrayList<SysRole>();
		if (getHbmInhRoles() != null)
			rtnVal.addAll(getHbmInhRoles());
		return rtnVal;
	}

	public void setFdInhRoles(List<SysRole> inhroles) {
		new WebAppCache(SysRole.class).clear();
		if (this.fdInhRoles == null)
			this.fdInhRoles = new ArrayList<SysRole>();
		else
			this.fdInhRoles.clear();
		if (inhroles != null)
			this.fdInhRoles.addAll(inhroles);
	}
	
	public List<SysRole> getHbmRolesInh() {
		return fdRolesInh;
	}
	
	public void setHbmRolesInh(List<SysRole> rolesInh) {
		this.fdRolesInh = rolesInh;
	}
	
	public List<SysRole> getFdRolesInh() {
		List<SysRole> rtnVal = new ArrayList<SysRole>();
		if (getHbmRolesInh() != null)
			rtnVal.addAll(getHbmRolesInh());
		return rtnVal;
	}

	public void setFdRolesInh(List<SysRole> fdRolesInh) {
		this.fdRolesInh = fdRolesInh;
	}
	
	public Boolean getFdIsSysRole() {
		return fdIsSysRole;
	}

	public void setFdIsSysRole(Boolean fdIsSysRole) {
		this.fdIsSysRole = fdIsSysRole;
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFdId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysRole == false) return false;
		if(this == obj) return true;
		SysRole other = (SysRole)obj;
		return new EqualsBuilder()
			.append(getFdId(),other.getFdId())
			.isEquals();
	}
}

