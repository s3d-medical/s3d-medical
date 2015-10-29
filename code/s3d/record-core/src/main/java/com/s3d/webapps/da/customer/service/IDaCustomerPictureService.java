package com.s3d.webapps.da.customer.service;

import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;

/**
 * 图片缩引业务对象接口
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public interface IDaCustomerPictureService extends BaseServiceMgr{
	String SERVICE_NAME = "daCustomerPictureService";
	
	DaCustomerPicture getPictureByMd5Hash(String md5); 
}
