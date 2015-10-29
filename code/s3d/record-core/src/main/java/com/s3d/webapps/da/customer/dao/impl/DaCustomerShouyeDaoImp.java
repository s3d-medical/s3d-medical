package com.s3d.webapps.da.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.customer.dao.IDaCustomerShouyeDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerShouye;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

@ChildOf(parent="BaseDao")
@Repository
public class DaCustomerShouyeDaoImp extends BaseDaoImp implements IDaCustomerShouyeDao {
	@Override
	public String getModelName() {
		return DaCustomerShouye.class.getName();
	}
}
