package com.s3d.webapps.sys.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

public interface ILTPATokenHandler extends LogoutHandler {
	String getUserName(HttpServletRequest request);
	
	void loginFail(HttpServletRequest request, HttpServletResponse response);

    void loginSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication successfulAuthentication);
}
