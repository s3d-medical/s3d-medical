package com.s3d.webapps.web.controller.da.customer;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.da.customer.constant.Constants;
import com.s3d.webapps.da.customer.persistence.DaCustomerHospital;
import com.s3d.webapps.da.customer.persistence.DaCustomerLabel;
import com.s3d.webapps.da.customer.persistence.DaCustomerPicture;
import com.s3d.webapps.da.customer.service.IDaCustomerHospitalService;
import com.s3d.webapps.da.customer.service.IDaCustomerLabelService;
import com.s3d.webapps.da.customer.service.IDaCustomerPictureService;
import com.s3d.webapps.da.customer.service.IDaCustomerShouyeService;
import com.s3d.webapps.da.customer.service.impl.LabelScanServiceImp;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.web.vo.da.customer.DaCustomerLabelVo;

@Controller
@RequestMapping(value=LabelController.RequestMappingPath)
public class LabelController extends BaseController<DaCustomerLabel>{
	public final static String RequestMappingPath = "/da/customer/label";
	
	@Autowired
	private IDaCustomerShouyeService daCustomerShouyeService;
	
	@Autowired
	private IDaCustomerLabelService daCustomerLabelService;
	
	@Autowired
	private IDaCustomerPictureService daCustomerPictureService;
	
	@Autowired
	private IDaCustomerHospitalService daCustomerHospitalService;
	
	@Autowired
	private LabelScanServiceImp labelScanService;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daCustomerLabelService;
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;

		return whereBlock;
	}	
	
	@RequestMapping("/shouye")
	public String shouye(HttpServletRequest request,Model model) {
		model.addAttribute("now", new Date());
		return getRequestMappingPath() + "/shouye";
	}
	
	@Override
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		String parentId = request.getParameter("parent");
		DaCustomerHospital parent = null;
		if(StringUtil.isNotNull(parentId)){
			parent = (DaCustomerHospital) daCustomerHospitalService.findByPrimaryKey(parentId);
		}
		
		if(parent==null || parent.getFdOrgType()!=HospitalOrgConstant.HSP_TYPE_PROJECT)
			throw new RuntimeException("必须在项目下面创建盘号");
		
		model.addAttribute("parent", parent);
		
		return getRequestMappingPath() + "/add";
	}
	
	@RequestMapping("/scanpicture")
	public ModelAndView scan(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("id");
		
		if(StringUtil.isNotNull(id))
			labelScanService.scan(id);
		else
			throw new RuntimeException("必须选择一个盘号");
		
		return ajaxDoneSuccess("正在开始扫描");
	}
	
	@RequestMapping(value = { "/editfileindex/updatepic/{fdId}" }, method = RequestMethod.POST)
	public ModelAndView updateFileIndex(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		DaCustomerPicture picture = (DaCustomerPicture) daCustomerPictureService.findByPrimaryKey(fdId);
		daCustomerShouyeService.updateShouye(request, picture);
		return ajaxDoneSuccess("ok");
	}
	
	@RequestMapping("/editfileindex/{fdId}")
	public String editFileIndex(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		EntityObject object = getBaseService().findByPrimaryKey(fdId);
		model.addAttribute("model", object);
		return getRequestMappingPath() + "/editfileindex";
	}
	
	@RequestMapping("/editcategory/{fdId}")
	public String editcategory(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		EntityObject object = getBaseService().findByPrimaryKey(fdId);
		model.addAttribute("model", object);
		return getRequestMappingPath() + "/editcategory";
	}
	
	/**
	 * 查询建档信息
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editcategory",method = RequestMethod.POST)
	public String editcategory(HttpServletRequest request, Model model) {
		String fdId = request.getParameter("fdId");
		EntityObject object = getBaseService().findByPrimaryKey(fdId);
		model.addAttribute("model", object);
		return getRequestMappingPath() + "/editcategory";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DaCustomerLabelVo vo) {
		DaCustomerLabel daCustomerLabel = new DaCustomerLabel();
		daCustomerLabel.setDocCreateTime(new Date());
		daCustomerLabel.setFdCreateTime(vo.getFdCreateTime());
		daCustomerLabel.setFdCode(vo.getFdCode());
		daCustomerLabel.setFdDescription(vo.getFdDescription());
		daCustomerLabel.setFdName(vo.getFdName());
		daCustomerLabel.setFdStatus(Constants.DaCustomerLabel_Status_UnProcess);
		DaCustomerHospital parent = (DaCustomerHospital) daCustomerHospitalService.findByPrimaryKey(vo.getFdParentId());
		if(parent==null || parent.getFdOrgType()!=HospitalOrgConstant.HSP_TYPE_PROJECT){
			throw new RuntimeException("必须在项目下面创建盘号");
		}
		daCustomerLabel.setFdParent(parent);
		
		getBaseService().add(daCustomerLabel);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(DaCustomerLabelVo vo) {
		DaCustomerLabel daCustomerLabel = (DaCustomerLabel) getBaseService().findByPrimaryKey(vo.getFdId());
		daCustomerLabel.setFdDescription(vo.getFdDescription());
		daCustomerLabel.setFdAlterTime(new Date());
		getBaseService().update(daCustomerLabel);
		return success(getMessage("msg.operation.success"),true,true);
	}
}
