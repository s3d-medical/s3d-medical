package com.s3d.webapps.da.config.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.config.dao.IDaConfigOcrRuleDao;
import com.s3d.webapps.da.config.service.IDaConfigOcrRuleService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * OCR规则业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaConfigOcrRuleService.SERVICE_NAME)
public class DaConfigOcrRuleServiceImp extends AbstractBaseServiceMgr implements IDaConfigOcrRuleService {
	@Autowired
	private IDaConfigOcrRuleDao daConfigOcrRuleDao;
	
	public IBaseDao getBaseDao(){
		return daConfigOcrRuleDao;
	}
}
