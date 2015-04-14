package com.s3d.webapps.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

public class SiteMeshWrapperFilter extends SiteMeshFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if (isAjax(request)) {
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}

	}

	private boolean isAjax(HttpServletRequest request) {
		if (request != null && ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")) || request.getParameter("ajax") != null))
			return true;
		return false;
	}
}
