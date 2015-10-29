package com.s3d.webapps.web.controller.da.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.web.vo.BaseConditionVO;

@Controller("da.customer.indexController")
@RequestMapping(IndexController.RequestMappingPath)
@RequestMappingAuthority(roles={"SYSROLE_ADMIN"},antPath={IndexController.RequestMappingPath+"*"})
public class IndexController extends BaseController{
	public final static String RequestMappingPath = "/da/customer";
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return null;
	}

	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		return null;
	}

	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}	
}