package com.s3d.webapps.da.config.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.component.forms.DataDictionary;
import com.s3d.webapps.component.forms.provider.DictionaryProvider;
import com.s3d.webapps.da.config.dao.IDaConfigSetDao;
import com.s3d.webapps.da.config.service.IDaConfigSetService;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 数据字典业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaConfigSetService.SERVICE_NAME)
public class DaConfigSetServiceImp extends AbstractBaseServiceMgr implements IDaConfigSetService ,DictionaryProvider{
	
	@Autowired
	private IDaConfigSetDao daConfigSetDao;
	

	public IBaseDao getBaseDao(){
		return daConfigSetDao;
	}


	@Override
	public List<DataDictionary> getDataDictionary(Object contextData,
			String type) throws Exception {
		DaCustomerPicture picture = (DaCustomerPicture) contextData;

		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock("daConfigSet.fdType=:type and daConfigSet.fdStatus=1");
		hqlInfo.setParameter("type", type);
		
		if(picture!=null){
			//TODO fdExclusive
		}
		
		List rtnList = findList(hqlInfo);
		return rtnList;
	}
}
