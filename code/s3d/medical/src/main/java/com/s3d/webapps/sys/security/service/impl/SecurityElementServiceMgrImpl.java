package com.s3d.webapps.sys.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.security.dao.ISecurityElementDao;
import com.s3d.webapps.sys.security.service.SecurityElementServiceMgr;

@ChildOf(parent="BaseService")
@Service(SecurityElementServiceMgr.SERVICE_NAME)
public class SecurityElementServiceMgrImpl extends AbstractBaseServiceMgr implements SecurityElementServiceMgr {

	private ISecurityElementDao securityElementDao;
	
	@Autowired
	public void setSecurityElementDao(ISecurityElementDao securityElementDao) {
		this.securityElementDao = securityElementDao;
	}


	public IBaseDao getBaseDao(){
		return securityElementDao;
	}
}
