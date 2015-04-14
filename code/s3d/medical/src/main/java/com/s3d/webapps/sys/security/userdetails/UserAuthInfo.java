package com.s3d.webapps.sys.security.userdetails;

import java.io.Serializable;
import java.util.List;

public class UserAuthInfo implements Serializable {
	private List authOrgIds;

	private List authRoleAliases;

	private List directParentIds;

	private List directParentorgIds;


	/**
	 * @return 跟当前用户相关的组织架构ID列表
	 */
	public List getAuthOrgIds() {
		return authOrgIds;
	}

	/**
	 * @return 跟当前用户相关的角色别名列表
	 */
	public List getAuthRoleAliases() {
		return authRoleAliases;
	}

	/**
	 * @return 当前用户的所有上级部门ID列表
	 */
	public List getDirectParentIds() {
		return directParentIds;
	}

	/**
	 * @return 当前用户的所有上级机构ID列表
	 */
	public List getDirectParentorgIds() {
		return directParentorgIds;
	}

	public void setAuthOrgIds(List authOrgIds) {
		this.authOrgIds = authOrgIds;
	}

	public void setAuthRoleAliases(List authRoleAliases) {
		this.authRoleAliases = authRoleAliases;
	}

	public void setDirectParentIds(List directParentIds) {
		this.directParentIds = directParentIds;
	}

	public void setDirectParentOrgIds(List directParentorgIds) {
		this.directParentorgIds = directParentorgIds;
	}
}
