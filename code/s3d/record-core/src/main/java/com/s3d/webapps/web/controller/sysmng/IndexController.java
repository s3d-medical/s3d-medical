package com.s3d.webapps.web.controller.sysmng;

//import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.ConfigurationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.config.DASysProperties;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;

@Controller("sysmng.indexController")
@RequestMapping("/sysmng")
@RequestMappingAuthority(roles={"SYSROLE_ADMIN"},antPath={"/sysmng*"})
public class IndexController extends BaseController{
	public final static String RequestMappingPath = "/sysmng";
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"},antPath={"/sysmng/properties"})
	@RequestMapping("/properties")
	public String menu(Model model) {
		model.addAllAttributes(DASysProperties.getMap());
		return "/sysmng/properties";
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProperty(HttpServletRequest request) {
		
		String p_datafilepath = request.getParameter("p_datafilepath");
		try {
			DASysProperties.saveConfiguration("p_datafilepath", p_datafilepath);
		} catch (ConfigurationException e) {
			e.printStackTrace();
			return error(e.getMessage());
		}
		
		return success(getMessage("msg.operation.success"),false,false);
	}

	@Override
	protected BaseServiceMgr getBaseService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}	
}