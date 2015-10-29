package com.s3d.webapps.web.controller.sysmng;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.sys.acl.role.persistence.SysRole;
import com.s3d.webapps.sys.acl.role.service.SysRoleServiceMgr;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.web.vo.BaseConditionVO;

@Controller("sysmng.roleController")
@RequestMapping(value=RoleController.RequestMappingPath)
public class RoleController extends BaseController<SysRole>{
	public final static String RequestMappingPath = "/sysmng/role";
	
	@Autowired
	private SysRoleServiceMgr sysRoleServiceMgr;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}

	@Override
	protected BaseServiceMgr getBaseService() {
		return sysRoleServiceMgr;
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;
		String keywords = request.getParameter("keywords");
		if(StringUtils.isNotEmpty(keywords)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", 
					" (sysRole.fdName='"+keywords+"' or sysRole.fdDescription like '%"+keywords+"%')"
				);
		}
		return whereBlock;
	}
}
