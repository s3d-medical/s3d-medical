package com.s3d.webapps.sys.acl.role.service;

import java.util.List;

import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.sys.acl.role.persistence.SysRole;

public interface SysRoleServiceMgr extends BaseServiceMgr {
	String SERVICE_NAME = "sysRoleServiceMgr";
	/**
	 * 获取orgIds对应的角色别名列表
	 * 
	 * @param orgIds
	 * @return
	 * @throws Exception
	 */
	public abstract List<String> getRoleAliasesByOrgIds(List<String> orgIds);

	public abstract SysRole getRoleByAlias(String alias);
}
