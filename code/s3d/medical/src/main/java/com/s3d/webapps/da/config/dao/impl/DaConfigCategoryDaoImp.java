package com.s3d.webapps.da.config.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.config.dao.IDaConfigCategoryDao;
import com.s3d.webapps.da.config.persistence.DaConfigCategory;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 病案分类数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository
public class DaConfigCategoryDaoImp extends BaseDaoImp implements IDaConfigCategoryDao {
	@Override
	public String getModelName() {
		return DaConfigCategory.class.getName();
	}
}
