package com.s3d.webapps.web.controller.da.customer;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.da.customer.persistence.DaCustomerHospital;
import com.s3d.webapps.da.customer.persistence.DaCustomerProject;
import com.s3d.webapps.da.customer.service.IDaCustomerHospitalService;
import com.s3d.webapps.da.customer.service.IDaCustomerProjectService;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.web.vo.BaseConditionVO;
import com.s3d.webapps.web.vo.da.customer.DaCustomerHospitalVo;

@Controller
@RequestMapping(value=ProjectController.RequestMappingPath)
public class ProjectController extends BaseController<DaCustomerProject>{
	public final static String RequestMappingPath = "/da/customer/project";
		
	@Autowired
	private IDaCustomerProjectService daCustomerProjectService;
	
	@Autowired
	private IDaCustomerHospitalService daCustomerHospitalService;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daCustomerProjectService;
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;

		return whereBlock;
	}
	
	@Override
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		String parentId = request.getParameter("parent");
		DaCustomerHospital parent = null;
		if(StringUtil.isNotNull(parentId)){
			parent = (DaCustomerHospital) daCustomerHospitalService.findByPrimaryKey(parentId);
		}
		if(parent==null || parent.getFdOrgType()!=HospitalOrgConstant.HSP_TYPE_HOSPITAL)
			throw new RuntimeException("必须在客户下面创建项目");
		
		model.addAttribute("parent", parent);
		
		return getRequestMappingPath() + "/add";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DaCustomerHospitalVo vo) {
		DaCustomerProject daCustomerProject = new DaCustomerProject();
		daCustomerProject.setDocCreateTime(new Date());
		daCustomerProject.setFdCode(vo.getFdCode());
		daCustomerProject.setFdDescription(vo.getFdDescription());
		daCustomerProject.setFdName(vo.getFdName());
		
		DaCustomerHospital parent = (DaCustomerHospital) daCustomerHospitalService.findByPrimaryKey(vo.getFdParentId());
		if(parent==null || parent.getFdOrgType()!=HospitalOrgConstant.HSP_TYPE_HOSPITAL){
			throw new RuntimeException("必须在客户下面创建项目");
		}
		daCustomerProject.setFdParent(parent);
		
		getBaseService().add(daCustomerProject);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(DaCustomerHospitalVo vo) {
		DaCustomerProject daCustomerProject = (DaCustomerProject) getBaseService().findByPrimaryKey(vo.getFdId());
		daCustomerProject.setFdCode(vo.getFdCode());
		daCustomerProject.setFdDescription(vo.getFdDescription());
		daCustomerProject.setFdName(vo.getFdName());
		daCustomerProject.setFdAlterTime(new Date());
		getBaseService().update(daCustomerProject);
		return success(getMessage("msg.operation.success"),true,true);
	}
}
