package com.s3d.webapps.da.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.config.dao.IDaConfigPtemplateDao;
import com.s3d.webapps.da.config.persistence.DaConfigPtemplate;
import com.s3d.webapps.da.config.service.IDaConfigPtemplateService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaConfigPtemplateService.SERVICE_NAME)
public class DaConfigPtemplateServiceImp extends AbstractBaseServiceMgr implements IDaConfigPtemplateService{
	
	@Autowired
	private IDaConfigPtemplateDao DaConfigPtemplateDao;
	

	public IBaseDao getBaseDao(){
		return DaConfigPtemplateDao;
	}


	@Override
	public DaConfigPtemplate getTemplateByName(String name) {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock("daConfigPtemplate.fdName=:name");
		hqlInfo.setOrderBy("daConfigPtemplate.fdVersion desc");
		hqlInfo.setParameter("name", name);
		
		List rtnList = findList(hqlInfo);
		if (rtnList.isEmpty())
			return null;
		else
			return (DaConfigPtemplate) rtnList.get(0);
	}

}
