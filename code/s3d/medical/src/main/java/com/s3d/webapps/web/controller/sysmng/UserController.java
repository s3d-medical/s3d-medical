package com.s3d.webapps.web.controller.sysmng;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.service.BaseServiceMgr;
import com.s3d.webapps.sys.config.enums.Gender;
import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.service.IUserServiceMgr;
import com.s3d.webapps.util.StringUtil;
import com.s3d.webapps.web.vo.sysmng.ChangePwdVO;
import com.s3d.webapps.web.vo.sysmng.UpdateUserVo;

@Controller("sysmng.userController")
@RequestMapping(value=UserController.RequestMappingPath)
public class UserController extends BaseController<User>{
	public final static String RequestMappingPath = "/sysmng/user";
	
	@Resource
	private Md5PasswordEncoder passwordEncoder; 
	
	@Autowired
	private IUserServiceMgr userMgr;
	
	@Override
	protected String getRequestMappingPath() {
		return RequestMappingPath;
	}
	
	@Override
	protected BaseServiceMgr getBaseService() {
		return userMgr;
	}
	
	@Override
	protected String getFindPageWhereBlock(HttpServletRequest request) {
		String whereBlock = null;
		String keywords = request.getParameter("keywords");
		if(StringUtils.isNotEmpty(keywords)){
			whereBlock = StringUtil.linkString(whereBlock, " and ", 
					" (user.fdLoginName='"+keywords+"' or user.fdName like '%"+keywords+"%' or user.fdPhone like '%"+keywords+"%')"
				);
		}
		return whereBlock;
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/sysmng/user/add";
	}
	
	@RequestMapping("/edit/{fdId}")
	public String edit(HttpServletRequest request, Model model,@PathVariable("fdId") String fdId) {
		User user = (User) userMgr.findByPrimaryKey(fdId);

		model.addAttribute("vo", user);
		model.addAttribute("genderList", Gender.values());

		return "/sysmng/user/edit";
	}
	
	@RequestMapping("/changepwd/{fdId}")
	public String changepwd(@PathVariable("fdId") String fdId, Model model) {
		User user = (User) userMgr.findByPrimaryKey(fdId);

		model.addAttribute("vo", user);
		model.addAttribute("genderList", Gender.values());

		return "/sysmng/user/changepwd";
	}
	
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public ModelAndView updatepwd(ChangePwdVO vo) {
		User user = (User) userMgr.findByPrimaryKey(vo.getFdId());
		if(user==null) return ajaxDoneError(getMessage("msg.operation.failure"));
		if(!vo.getFdPassword().equals(vo.getFdConfirmPassword())){
			return ajaxDoneError(getMessage("msg.password.notmatchconfirm"));
		}
		String encodedPwd = passwordEncoder.encodePassword(vo.getFdPassword(), null);
		user.setFdPassword(encodedPwd);
		userMgr.update(user);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(User user) {
		try {
			userMgr.add(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/updatevo", method = RequestMethod.POST)
	public ModelAndView update(UpdateUserVo uservo) {
		User user = (User) userMgr.findByPrimaryKey(uservo.getFdId());
		BeanUtils.copyProperties(uservo, user, new String[]{"fdId"});
		try {
			userMgr.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/delete/{fdId}")
	public ModelAndView delete(HttpServletRequest request,@PathVariable("fdId") String fdId) {
		try {
			userMgr.delete(fdId);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
