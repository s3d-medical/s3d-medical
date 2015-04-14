package com.s3d.webapps.da.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.config.dao.IDaConfigCategoryDao;
import com.s3d.webapps.da.config.service.IDaConfigCategoryService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 病案分类业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaConfigCategoryService.SERVICE_NAME)
public class DaConfigCategoryServiceImp extends AbstractBaseServiceMgr implements IDaConfigCategoryService {
	
	@Autowired
	private IDaConfigCategoryDao daConfigCategoryDao;
	
	public IBaseDao getBaseDao(){
		return daConfigCategoryDao;
	}
}
