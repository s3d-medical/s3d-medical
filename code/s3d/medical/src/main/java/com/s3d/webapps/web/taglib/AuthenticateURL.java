package com.s3d.webapps.web.taglib;

import javax.servlet.jsp.tagext.BodyTagSupport;

import com.s3d.webapps.util.UserUtil;

public class AuthenticateURL extends BodyTagSupport {
	private String requestURL;

	public int doStartTag() {
		if (UserUtil.checkAuthentication(getRequestURL()))
			return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}
	
	public String getRequestURL() {
		return requestURL;
	}

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
}
