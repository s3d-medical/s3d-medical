package com.s3d.webapps.sys.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import com.alibaba.fastjson.JSONObject;
import com.s3d.webapps.sys.security.exception.MethodErrorException;
import com.s3d.webapps.sys.security.exception.ValidateCodeException;

public class LoginFailureHandler implements AuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		boolean status = false;
		String message = null;
		if (ex instanceof UsernameNotFoundException) {
			// 账号错误
			message = ex.getMessage();
		} else if (ex instanceof BadCredentialsException) {
			// 密码错误
			message = "用户/密码错误,请重新输入!";
		} else if (ex instanceof ValidateCodeException) {
			// 验证码错误
			message = ex.getMessage();
		} else if (ex instanceof MethodErrorException) {
			// 请求方法错误
			message = ex.getMessage();
		} else if (ex instanceof SessionAuthenticationException) {
			// 登陆超时错误
			response.sendRedirect(request.getContextPath() + "/server/error/timeout.jsp");
			return;
		} else {
			// 未知异常错误
			message = "未知异常错误,请联系相关技术人员!";
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		JSONObject json=new JSONObject();
		json.put("status", status);
		json.put("message", message);
		response.getWriter().print(json.toJSONString());
	}
}
