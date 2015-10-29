package com.s3d.webapps.da.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.config.dao.IDaConfigAreaDao;
import com.s3d.webapps.da.config.service.IDaConfigAreaService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 地区配置业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaConfigAreaService.SERVICE_NAME)
public class DaConfigAreaServiceImp extends AbstractBaseServiceMgr implements IDaConfigAreaService {
	
	@Autowired
	private IDaConfigAreaDao daConfigAreaDao;
	
	public IBaseDao getBaseDao(){
		return daConfigAreaDao;
	}
}
