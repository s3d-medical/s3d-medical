package com.s3d.webapps.da.customer.service;

import com.s3d.webapps.common.service.BaseServiceMgr;

/**
 * 盘号信息业务对象接口
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
public interface IDaCustomerLabelService extends BaseServiceMgr{
	String SERVICE_NAME = "daCustomerLabelService";
	
	Long getFileNoNullCount(String labelId);
	
	Long getCategoryNullCount(String labelId);
	
	Long getNoFillIndexPageCount(String labelId);
}
