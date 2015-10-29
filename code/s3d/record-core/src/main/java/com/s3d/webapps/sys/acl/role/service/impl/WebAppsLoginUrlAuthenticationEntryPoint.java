package com.s3d.webapps.sys.acl.role.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class WebAppsLoginUrlAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint{
	//需要回调的URL 自定义参数  
    public static final String SPRING_SECURITY_FORM_REDERICT_KEY = "redirectTo"; 
    
	private String redirectParameter = SPRING_SECURITY_FORM_REDERICT_KEY;  
	
	@Override
	public void commence(
			HttpServletRequest request,
			HttpServletResponse response,
			org.springframework.security.core.AuthenticationException authException)
			throws IOException, ServletException {
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        } else {
        	String targetUrl = request.getServletPath();
    		if (targetUrl != null) {
    			request.getSession().setAttribute(redirectParameter,targetUrl);
    		}
    		super.commence(request, response, authException);
        }
	}
}
