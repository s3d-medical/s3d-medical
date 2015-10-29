package com.s3d.webapps.da.config.service;

import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.config.persistence.DaConfigPtemplate;

/**
 * 
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public interface IDaConfigPtemplateService extends BaseServiceMgr {
	String SERVICE_NAME = "DaConfigPtemplateService";
	
	DaConfigPtemplate getTemplateByName(String name);
}
