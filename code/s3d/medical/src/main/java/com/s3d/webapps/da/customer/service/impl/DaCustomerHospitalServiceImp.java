package com.s3d.webapps.da.customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.customer.dao.IDaCustomerHospitalDao;
import com.s3d.webapps.da.customer.service.IDaCustomerHospitalService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 客户信息业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaCustomerHospitalService.SERVICE_NAME)
public class DaCustomerHospitalServiceImp extends AbstractBaseServiceMgr implements IDaCustomerHospitalService {
	
	@Autowired
	private IDaCustomerHospitalDao daCustomerHospitalDao;
	
	public IBaseDao getBaseDao(){
		return daCustomerHospitalDao;
	}
}
