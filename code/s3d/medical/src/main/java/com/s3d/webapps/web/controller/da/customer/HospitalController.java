package com.s3d.webapps.web.controller.da.customer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.da.customer.persistence.DaCustomerHospital;
import com.s3d.webapps.da.customer.service.IDaCustomerHospitalService;
import com.s3d.webapps.da.customer.service.IDaCustomerLabelService;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.util.HospitalHQLUtil;
import com.s3d.webapps.web.vo.da.customer.DaCustomerHospitalVo;

@Controller
@RequestMapping(value=HospitalController.RequestMappingPath)
@RequestMappingAuthority(roles={"SYSROLE_USER"},antPath={HospitalController.RequestMappingPath+"**"})
public class HospitalController extends BaseController<DaCustomerHospital>{
	public final static String RequestMappingPath = "/da/customer/hospital";
		
	@Autowired
	private IDaCustomerHospitalService daCustomerHospitalService;
	
	@Autowired
	private IDaCustomerLabelService daCustomerLabelService;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daCustomerHospitalService;
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;

		return whereBlock;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DaCustomerHospitalVo vo) {
		DaCustomerHospital daCustomerHospital = new DaCustomerHospital();
		daCustomerHospital.setDocCreateTime(new Date());
		daCustomerHospital.setFdCode(vo.getFdCode());
		daCustomerHospital.setFdDescription(vo.getFdDescription());
		daCustomerHospital.setFdName(vo.getFdName());
		daCustomerHospital.setFdOrgType(HospitalOrgConstant.HSP_TYPE_HOSPITAL);
		if(StringUtils.isNotBlank(vo.getFdParentId())){
			DaCustomerHospital parent = (DaCustomerHospital) getBaseService().findByPrimaryKey(vo.getFdParentId());
			daCustomerHospital.setFdParent(parent);
		}
		getBaseService().add(daCustomerHospital);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(DaCustomerHospitalVo vo) {
		DaCustomerHospital daCustomerHospital = (DaCustomerHospital) getBaseService().findByPrimaryKey(vo.getFdId());
		daCustomerHospital.setFdCode(vo.getFdCode());
		daCustomerHospital.setFdDescription(vo.getFdDescription());
		daCustomerHospital.setFdName(vo.getFdName());
		daCustomerHospital.setFdAlterTime(new Date());
		getBaseService().update(daCustomerHospital);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@RequestMapping(value = "/listchildrenjson")
	public ModelAndView listchildrenjson(HttpServletRequest request,
			HttpServletResponse response) {

		boolean isNullNode = false;
		boolean isBaseNode = false;
		
		HQLInfo hqlInfo = new HQLInfo();
		String parent = request.getParameter("id");
		String whereBlock = "";
		if(StringUtils.isBlank(parent)){
			isBaseNode = true;
			whereBlock = "daCustomerHospital.hbmParent is null ";
		} else if (parent.equals("null")) {
			whereBlock = "daCustomerHospital.hbmParent is null ";
			isNullNode = true;
		}else{
			whereBlock = "daCustomerHospital.hbmParent.fdId=:hbmParentFdId ";
			hqlInfo.setParameter("hbmParentFdId", parent);
		}
		
		if(isNullNode || isBaseNode){
			String initializeId = request.getParameter("initializeId");
			if(StringUtils.isNotBlank(initializeId)){
				List IdList = getBaseService().findValue("daCustomerHospital.fdHierarchyId", "daCustomerHospital.fdId='"+initializeId+"'", null);
				if(!IdList.isEmpty()){
					String hierarchyid = IdList.get(0).toString();
					String arr[]=StringUtils.split(hierarchyid,"x");
					whereBlock = "("+ whereBlock + ") or (daCustomerHospital.fdId in('"+StringUtils.join(arr, "','")+"'))";
				}
			}
		}
		
		int orgType = HospitalOrgConstant.HSP_TYPE_HOSORPRO;
		String para = request.getParameter("orgType");
		if (para != null && !para.equals("")) {
			try {
				orgType = Integer.parseInt(para);
			} catch (NumberFormatException e) {
			}
		}
		int treeOrgType = orgType;
		if ((treeOrgType & HospitalOrgConstant.HSP_TYPE_PROJECT) == HospitalOrgConstant.HSP_TYPE_PROJECT)
			// 若需要选择项目，医院必须出现
			treeOrgType |= HospitalOrgConstant.HSP_TYPE_HOSPITAL;
		if (isBaseNode) {
			// 
		} else if (isNullNode) {
			treeOrgType &= ~HospitalOrgConstant.HSP_TYPE_HOSORPRO;
		}
		
		hqlInfo.setWhereBlock(HospitalHQLUtil.buildWhereBlock(treeOrgType,
						whereBlock, "daCustomerHospital"));
		
		hqlInfo.setOrderBy("daCustomerHospital.fdOrgType desc, daCustomerHospital.fdName");
		
		List<DaCustomerHospital> list = getBaseService().findList(hqlInfo);
		
		OutputJson(list,new IJSONSerializeConfig() {
			
			@Override
			public String[] getPropertyFilterNames() {
				return new String[]{"fdParent","hbmParent","new","fdHierarchyId"};
			}
			
			@Override
			public Map<String, Object> getAdditionalProperties(Object object) {
				if (object instanceof DaCustomerHospital) {
					DaCustomerHospital hospital = (DaCustomerHospital) object;
					Map<String, Object> map = new HashMap<String, Object>();
					
					map.put("cls", "icon-org"+hospital.getFdOrgType());
					if((HospitalOrgConstant.HSP_TYPE_HOSORPRO | hospital.getFdOrgType()) == HospitalOrgConstant.HSP_TYPE_HOSORPRO){
						map.put("leaf", false);
					}
					if(hospital.getFdParent()!=null){
						map.put("fdParentId", hospital.getFdParent().getFdId());
					}
					
					if(HospitalOrgConstant.HSP_TYPE_LABEL == hospital.getFdOrgType()){ //计算盘号 未识别分类的数量  未识别病案号的数量 
						Long fileNoNullCount = daCustomerLabelService.getFileNoNullCount(hospital.getFdId());
						map.put("fileNoNullCount", fileNoNullCount );
						Long categoryNullCount = daCustomerLabelService.getCategoryNullCount(hospital.getFdId());
						map.put("categoryNullCount", categoryNullCount);
						
						if(fileNoNullCount!=null && categoryNullCount!=null){
							if(fileNoNullCount==0 && categoryNullCount == 0) {
								map.put("noFillIndexPageCount", daCustomerLabelService.getNoFillIndexPageCount(hospital.getFdId()));
							}
						}
					}
					
					return map;
				}
				
				return null;
			}

			@Override
			public String getDateFormat() {
				return "yyyy-MM-dd";
			}
		},response);
		
		return null;
	}
}
