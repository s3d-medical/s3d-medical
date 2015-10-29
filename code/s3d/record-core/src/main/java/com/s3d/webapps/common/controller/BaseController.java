package com.s3d.webapps.common.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.entity.BaseEntityObject;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.component.db.Page;
import com.s3d.webapps.constant.Constants;
import com.s3d.webapps.framework.AppConfiguration;
import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.util.UserUtil;
import com.s3d.webapps.web.editor.DateEditor;
import com.s3d.webapps.web.editor.DoubleEditor;
import com.s3d.webapps.web.editor.IntegerEditor;
import com.s3d.webapps.web.editor.LongEditor;
import com.s3d.webapps.web.vo.BaseConditionVO;

public abstract class BaseController<T extends BaseEntityObject>{
	private static final String _SUCCESS_PAGE_AUTO_CLOSE = "SUCCESS_PAGE_AUTO_CLOSE";
	private static final String _SUCCESS_PAGE_RELOAD_OPENER = "SUCCESS_PAGE_RELOAD_OPENER";
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ResourceBundleMessageSource _res;
	
//	@Autowired
//	protected SpringContextHolder _contextHolder;
	protected abstract String getFindPageWhereBlock(HttpServletRequest request);
	
	protected abstract String getRequestMappingPath();
	
	protected abstract BaseServiceMgr getBaseService();
	
	protected void changeFindPageHQLInfo(HttpServletRequest request, HQLInfo hqlInfo) {
		hqlInfo.setWhereBlock(getFindPageWhereBlock(request));
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		return getRequestMappingPath() + "/add";
	}
			
	@RequestMapping("/edit/{fdId}")
	public String edit(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		EntityObject object = getBaseService().findByPrimaryKey(fdId);
		model.addAttribute("model", object);
		return getRequestMappingPath() + "/edit";
	}
	
	@RequestMapping("/delete/{fdId}")
	public ModelAndView delete(HttpServletRequest request,@PathVariable("fdId") String fdId) {
		try {
			getBaseService().delete(fdId);
		} catch (Exception e) {
			e.printStackTrace();
			if(isAjax(request))
				return ajaxDoneError(e.getMessage());
			else
				return error(e.getMessage());
		}
		if(isAjax(request))
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		else
			return success(getMessage("msg.operation.success"), true, true);
	}
	
	/**
	 * 自动发送的数据格式：
	 *  1. start: 开始记录的起始数，如第 20 条,从0开始
	 *  2. limit : 单页多少条记录
	 *  3. pageIndex : 第几页  从0开始，同start参数重复，可以选择其中一个使用
	 *
	 * 返回的数据格式：
	 *  {
	 *     "rows" : [{},{}], //数据集合
	 *     "results" : 100, //记录总数
	 *     "hasError" : false, //是否存在错误
	 *     "error" : "" // 仅在 hasError : true 时使用
	 *   }
	 * 
	 */
	@RequestMapping(value = "/listjson")
	public ModelAndView listjson(HttpServletRequest request,
			HttpServletResponse response,BaseConditionVO vo) {
		
		List<BaseEntityObject> entityist = new ArrayList<BaseEntityObject>(0);
		Integer totalCount = 0;

		try {
			int pageno = vo.getPageIndex()+1; //因为bui传过来的pageno是从0开始算的
			int rowsize = vo.getLimit();
			String orderby = vo.getOrderField();
			String ordertype = vo.getOrderDirection();
			boolean isReserve = false;
			if (ordertype != null && ordertype.equalsIgnoreCase("down")) {
				isReserve = true;
			}
			if (isReserve)
				orderby += " desc";
			HQLInfo hqlInfo = new HQLInfo();
			hqlInfo.setOrderBy(orderby);
			hqlInfo.setPageNo(pageno);
			hqlInfo.setRowSize(rowsize);
			changeFindPageHQLInfo(request, hqlInfo);
			Page page = getBaseService().findPage(hqlInfo);
			entityist = page.getList();
			totalCount=page.getTotalrows();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("rows", entityist);
		result.put("results", totalCount);
		result.put("hasError", false);
		
		toJson(result, listjsonSerializeConfig(), response);
		
		return null;
	}
	
	protected IJSONSerializeConfig listjsonSerializeConfig() {
		return null;
	}
	
	@RequestMapping()
	public String index(HttpServletRequest request,Model model) {
		model.addAttribute("now", new Date());
		return getRequestMappingPath() + "/index";
	}
	
	
	protected ModelAndView error(String message) {
		ModelAndView mav = new ModelAndView("error/error");
		mav.addObject("message", message);
		return mav;
	}
	
	/**
	 * 
	 * @param message 返回信息
	 * @param autoClosepage 是否自动关闭页面
	 * @param reloadOpener 是否刷新父页面
	 * @return
	 */
	protected ModelAndView success(String message,boolean autoClosepage,boolean reloadOpener) {
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("message", message);
		mav.addObject(_SUCCESS_PAGE_AUTO_CLOSE,autoClosepage);
		mav.addObject(_SUCCESS_PAGE_RELOAD_OPENER,reloadOpener);
		return mav;
	}
	
	protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
		ModelAndView mav = new ModelAndView("ajaxDone");
		mav.addObject("statusCode", statusCode);
		mav.addObject("message", message);
		mav.addObject("forwardUrl", forwardUrl);
		return mav;
//		Map<String, Object> json = new HashMap<String, Object>();
//		json.put("statusCode", statusCode);
//		json.put("message", message);
//		json.put("forwardUrl", forwardUrl);
//		toJson(json, null, response);
//		
//		return null;
	}
	
	protected ModelAndView ajaxDoneSuccess(String message) {
		return ajaxDone(200, message, "");
	}

	protected ModelAndView ajaxDoneError(String message) {
		return ajaxDone(300, message, "");
	}
	protected String getMessage(String code) {
		return this.getMessage(code, new Object[] {});
	}

	protected String getMessage(String code, Object arg0) {
		return getMessage(code, new Object[] { arg0 });
	}

	protected String getMessage(String code, Object arg0, Object arg1) {
		return getMessage(code, new Object[] { arg0, arg1 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2) {
		return getMessage(code, new Object[] { arg0, arg1, arg2 });
	}

	protected String getMessage(String code, Object arg0, Object arg1,
			Object arg2, Object arg3) {
		return getMessage(code, new Object[] { arg0, arg1, arg2, arg3 });
	}

	protected String getMessage(String code, Object[] args) {
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		Locale locale = localeResolver.resolveLocale(request);

		return _res.getMessage(code, args, locale);
	}
	
	protected AppConfiguration getAppConfig() {
		return AppConfiguration.getInstance();
	}
	
	protected boolean verifyValidationCode(
			String validationCode) {

		boolean enableVerify = getAppConfig()
				.getBoolean("validation-code.validation-code-enable");

		if (enableVerify) {
			if (validationCode == null)
				return false;

			String randomCode = null;
			try {
				randomCode = (String) request.getSession().getAttribute(
						Constants.VALIDATION_CODE);
				System.out.println(randomCode + " : " + validationCode);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (randomCode == null)
				return false;
			else if (!randomCode.equalsIgnoreCase(validationCode.trim()))
				return false;
		}
		return true;
	}
	
	
	@ModelAttribute("contextUser")
	public User getContextUser() {
		return UserUtil.getUser();
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e, HttpServletRequest request) {
		e.printStackTrace();
		
		request.setAttribute("exception", e);
		
		if (isAjax(request) || request.getParameter("ajax") != null) {
			return ajaxDoneError(e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView("error/error");
		mav.addObject("statusCode", 300);
		mav.addObject("message", e.getMessage());
		
		return mav;
	}
		
	protected static boolean isAjax(HttpServletRequest request) {
		if (request != null
				&& "XMLHttpRequest".equalsIgnoreCase(request
						.getHeader("X-Requested-With")))
			return true;
		return false;
	}
	
	protected void toJson(Object object,final IJSONSerializeConfig config,HttpServletResponse httpServletResponse) {
		PrintWriter out = null;
		httpServletResponse.setContentType("application/json");
		httpServletResponse.setCharacterEncoding("utf-8");
		String json=null;
		try {
			out = httpServletResponse.getWriter();
			
			SerializeWriter outJson = new SerializeWriter();
	        try {
	            JSONSerializer serializer = new JSONSerializer(outJson);
	            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
	            
	            if(config!=null){
	            	if(StringUtil.isNotNull(config.getDateFormat())){
		            	serializer.setDateFormat(config.getDateFormat());
		            }else
		            	serializer.setDateFormat("yyyy-MM-dd HH:mm:ss");
	            	
	            	PropertyFilter propertyFilter = new PropertyFilter() {
	    				public boolean apply(Object object, String name, Object value) {
	    					if(config.getPropertyFilterNames()!=null){
	    						if(ArrayUtils.indexOf(config.getPropertyFilterNames(), name)!=-1){
	    							return false;
	    						}	
	    					}
	    					return true;
	    				}
	    			};
	    			
	    			serializer.getPropertyFilters().add(propertyFilter);
	    			
	    			BeforeFilter beforefilter = new BeforeFilter() {
					    public void writeBefore(Object object) {
				    		Map<String, Object> additionalInfo =  config.getAdditionalProperties(object);
				    		if(additionalInfo!=null){
				    			for (Entry<String, Object> entry : additionalInfo.entrySet()) {
    				    			writeKeyValue(entry.getKey(), entry.getValue());
    				    		}
				    		}
					    	if (EntityObject.class.isAssignableFrom(object.getClass())) {
					    		EntityObject basemodel = (EntityObject) object;
					    		writeKeyValue("id", basemodel.getFdId());
					    	}			    	
					    }
					};
					serializer.getBeforeFilters().add(beforefilter);
	            }
            	
    			
	            serializer.write(object);
	            json =  outJson.toString();
	        } finally {
	        	outJson.close();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(json);
		out.close();
	}
}
