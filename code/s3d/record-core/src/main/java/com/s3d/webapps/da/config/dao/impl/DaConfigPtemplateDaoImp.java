package com.s3d.webapps.da.config.dao.impl;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.da.config.dao.IDaConfigPtemplateDao;
import com.s3d.webapps.da.config.persistence.DaConfigPtemplate;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository
public class DaConfigPtemplateDaoImp extends BaseDaoImp implements IDaConfigPtemplateDao {
	@Override
	public String getModelName() {
		return DaConfigPtemplate.class.getName();
	}
}
