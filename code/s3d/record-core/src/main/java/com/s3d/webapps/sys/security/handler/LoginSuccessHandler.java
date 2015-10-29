package com.s3d.webapps.sys.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibaba.fastjson.JSONObject;
import com.s3d.webapps.sys.security.service.SecurityElementServiceMgr;
import com.s3d.webapps.sys.security.userdetails.WebAppUser;
import com.s3d.webapps.util.UserUtil;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private SecurityElementServiceMgr securityElementService;

	private String indexUrl; // 登陆成功跳转路径

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		WebAppUser user = UserUtil.getWebAppUser((HttpServletRequest) request,authentication);
		System.out.println(user.getUsername() +" 登陆成功");		

		boolean status = true;
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		JSONObject json=new JSONObject();
		json.put("status", status);
		response.getWriter().print(json.toJSONString());
		
	}

}
