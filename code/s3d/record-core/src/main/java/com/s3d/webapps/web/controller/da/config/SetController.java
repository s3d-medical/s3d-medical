package com.s3d.webapps.web.controller.da.config;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.config.ConfigSetConstants;
import com.s3d.webapps.da.config.persistence.DaConfigSet;
import com.s3d.webapps.da.config.service.IDaConfigSetService;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;
import com.s3d.webapps.util.StringUtil;

@Controller
@RequestMapping(value=SetController.RequestMappingPath)
public class SetController extends BaseController<DaConfigSet>{
	public final static String RequestMappingPath = "/da/config/set";
		
	@Autowired
	private IDaConfigSetService daConfigSetService;
	
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daConfigSetService;
	}
	
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;
		String typeId = request.getParameter("type");
		if(StringUtil.isNotNull(typeId)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", "daConfigSet.fdType='"+typeId+"'");
		}		
		return whereBlock;
	}	
	
	@Override
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		String type = request.getParameter("type");
		String[] v = getTypeAttribute(type);
		model.addAttribute("fdType", v[0]);
		model.addAttribute("descName", v[1]);
		model.addAttribute("descCode", v[2]);
		return getRequestMappingPath() + "/add";
	}
	
	@RequestMapping("/edit/{fdId}")
	public String edit(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		EntityObject object = getBaseService().findByPrimaryKey(fdId);
		model.addAttribute("model", object);
		String type = request.getParameter("type");
		String[] v = getTypeAttribute(type);
		model.addAttribute("fdType", v[0]);		
		model.addAttribute("descName", v[1]);
		model.addAttribute("descCode", v[2]);		
		return getRequestMappingPath() + "/edit";
	}
		
	@Override
	@RequestMapping()
	public String index(HttpServletRequest request,Model model) {
		model.addAttribute("now", new Date());
		String type = request.getParameter("type");
		String[] v = getTypeAttribute(type);
		model.addAttribute("fdType", v[0]);
		model.addAttribute("descName", v[1]);
		model.addAttribute("descCode", v[2]);
		return getRequestMappingPath() + "/index";
	}	
	
	
	private String[] getTypeAttribute(String type){
		return ConfigSetConstants.TypeMap.get(type);
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DaConfigSet set) {
		getBaseService().add(set);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@Override
	protected IJSONSerializeConfig listjsonSerializeConfig() {
		return new IJSONSerializeConfigImpl();
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(DaConfigSet vo) {
		DaConfigSet daConfigSet = (DaConfigSet) getBaseService().findByPrimaryKey(vo.getFdId());
		daConfigSet.setFdStatus(vo.getFdStatus());
		daConfigSet.setFdShortcut(vo.getFdShortcut());
		daConfigSet.setFdName(vo.getFdName());
		getBaseService().update(daConfigSet);
		return success(getMessage("msg.operation.success"),true,true);
	}


    class IJSONSerializeConfigImpl implements IJSONSerializeConfig{
        @Override
        public String[] getPropertyFilterNames() {
            return new String[]{"new"};
        }

        @Override
        public Map<String, Object> getAdditionalProperties(Object object) {
            return null;
        }

        @Override
        public String getDateFormat() {
            return "yyyy-MM-dd";
        }
    }
}
