package com.s3d.webapps.da.config.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.config.dao.IDaConfigAreaDao;
import com.s3d.webapps.da.config.persistence.DaConfigArea;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 地区配置数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository
public class DaConfigAreaDaoImp extends BaseDaoImp implements IDaConfigAreaDao {
	
	@Override
	public String getModelName() {
		return DaConfigArea.class.getName();
	}
}
