package com.s3d.webapps.sys.acl.role.dao;

import java.util.List;

import com.s3d.webapps.common.dao.IBaseDao;

public interface ISysRoleDao  extends IBaseDao{

	List<String> getRoleAliasesByOrgIds(List<String> orgIds);
		
}
