package com.s3d.webapps.da.config.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.config.dao.IDaConfigSetDao;
import com.s3d.webapps.da.config.persistence.DaConfigSet;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 数据字典数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository
public class DaConfigSetDaoImp extends BaseDaoImp implements IDaConfigSetDao {
	@Override
	public String getModelName() {
		return DaConfigSet.class.getName();
	}
}
