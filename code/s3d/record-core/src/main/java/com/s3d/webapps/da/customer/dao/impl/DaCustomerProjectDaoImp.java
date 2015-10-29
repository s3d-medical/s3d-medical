package com.s3d.webapps.da.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.da.customer.dao.IDaCustomerProjectDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerProject;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 项目信息数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="daCustomerHospitalDao")
@Repository
public class DaCustomerProjectDaoImp extends DaCustomerHospitalDaoImp implements IDaCustomerProjectDao {
	@Override
	public String getModelName() {
		return DaCustomerProject.class.getName();
	}
}
