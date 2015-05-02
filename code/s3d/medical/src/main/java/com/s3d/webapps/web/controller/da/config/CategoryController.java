package com.s3d.webapps.web.controller.da.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.da.config.persistence.DaConfigCategory;
import com.s3d.webapps.da.config.service.IDaConfigCategoryService;
import com.s3d.webapps.framework.spring.annotation.RequestMappingAuthority;

@Controller
@RequestMapping(value=CategoryController.RequestMappingPath)
public class CategoryController extends BaseController<DaConfigCategory>{
	public final static String RequestMappingPath = "/da/config/category";
		
	@Autowired
	private IDaConfigCategoryService daConfigCategoryService;
	
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return daConfigCategoryService;
	}
	
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;

		return whereBlock;
	}	
	
	@Override
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		
		return getRequestMappingPath() + "/add";
	}
	
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(DaConfigCategory category) {
		
		
		getBaseService().add(category);
		return success(getMessage("msg.operation.success"),true,true);
	}
	
	@Override
	protected IJSONSerializeConfig listjsonSerializeConfig() {
		return new IJSONSerializeConfigImpl() ;
	}
	
	@RequestMappingAuthority(roles={"SYSROLE_ADMIN"})
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(DaConfigCategory vo) {
		DaConfigCategory daConfigCategory = getBaseService().findByPrimaryKey(vo.getFdId());
		daConfigCategory.setFdStatus(vo.getFdStatus());
		daConfigCategory.setFdShortcut(vo.getFdShortcut());
		daConfigCategory.setFdName(vo.getFdName());
		getBaseService().update(daConfigCategory);
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
