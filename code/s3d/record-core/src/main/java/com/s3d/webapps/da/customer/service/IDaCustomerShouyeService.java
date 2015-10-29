package com.s3d.webapps.da.customer.service;

import javax.servlet.http.HttpServletRequest;

import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;

public interface IDaCustomerShouyeService extends BaseServiceMgr{
	String SERVICE_NAME = "daCustomerShouyeService";
	
	String genarateEditingShouyeHTML(DaCustomerPicture picture);
	
	void updateShouye(HttpServletRequest request,DaCustomerPicture picture);
}
