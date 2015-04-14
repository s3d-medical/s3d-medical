package com.s3d.webapps.da.customer.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.customer.dao.IDaCustomerPictureDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 图片缩引数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository
public class DaCustomerPictureDaoImp extends BaseDaoImp implements IDaCustomerPictureDao {
	@Override
	public String getModelName() {
		return DaCustomerPicture.class.getName();
	}
}
