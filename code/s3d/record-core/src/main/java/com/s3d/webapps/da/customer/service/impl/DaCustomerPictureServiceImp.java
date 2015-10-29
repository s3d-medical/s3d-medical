package com.s3d.webapps.da.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.customer.dao.IDaCustomerPictureDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.service.IDaCustomerPictureService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 图片缩引业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaCustomerPictureService.SERVICE_NAME)
public class DaCustomerPictureServiceImp extends AbstractBaseServiceMgr implements IDaCustomerPictureService {
	@Autowired
	private IDaCustomerPictureDao daCustomerPictureDao;
	

	public IBaseDao getBaseDao(){
		return daCustomerPictureDao;
	}


	@Override
	public DaCustomerPicture getPictureByMd5Hash(String md5) {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock("daCustomerPicture.fdMd5Hash=:md5");
		
		hqlInfo.setParameter("md5", md5);
		
		List rtnList = findList(hqlInfo);
		if (rtnList.isEmpty())
			return null;
		else
			return (DaCustomerPicture) rtnList.get(0);
		
	}
}
