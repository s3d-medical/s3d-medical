package com.s3d.webapps.da.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.da.customer.dao.IDaCustomerLabelDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerLabel;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 盘号信息数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="daCustomerHospitalDao")
@Repository
public class DaCustomerLabelDaoImp extends DaCustomerHospitalDaoImp implements IDaCustomerLabelDao {
	@Override
	public String getModelName() {
		return DaCustomerLabel.class.getName();
	}
}
