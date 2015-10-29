package com.s3d.webapps.sys.acl.role.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.s3d.webapps.cache.ehcache.WebAppCache;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.acl.role.dao.ISysRoleDao;
import com.s3d.webapps.sys.acl.role.persistence.SysRole;
import com.s3d.webapps.sys.acl.role.service.SysRoleServiceMgr;

@Transactional(rollbackFor = Exception.class)
@ChildOf(parent="BaseService")
@Service(SysRoleServiceMgr.SERVICE_NAME)
public class SysRoleServiceMgrImpl extends AbstractBaseServiceMgr
		implements SysRoleServiceMgr {
	
	@Autowired
	private ISysRoleDao sysRoleDao;
	
	public IBaseDao getBaseDao(){
		return sysRoleDao;
	}
	
	public void delete(EntityObject modelObj){
		SysRole role = (SysRole) modelObj;
		super.delete(modelObj);
		new WebAppCache(SysRole.class).clear();
	}
	
	public SysRole getRoleByAlias(String alias)  {
		List<SysRole> roles = findList("sysRole.fdAlias='" + alias + "'", null);
		if (roles.isEmpty())
			return null;
		return (SysRole) roles.get(0);
	}

	public List getRoleAliasesByOrgIds(List orgIds) {
		return ((ISysRoleDao)getBaseDao()).getRoleAliasesByOrgIds(orgIds);
	}
}
