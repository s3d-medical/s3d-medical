package com.s3d.webapps.da.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.customer.dao.IDaCustomerProjectDao;
import com.s3d.webapps.da.customer.service.IDaCustomerProjectService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 项目信息业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaCustomerProjectService.SERVICE_NAME)
public class DaCustomerProjectServiceImp extends AbstractBaseServiceMgr implements IDaCustomerProjectService {
	@Autowired
	private IDaCustomerProjectDao daCustomerProjectDao;
	
	public IBaseDao getBaseDao(){
		return daCustomerProjectDao;
	}
}
