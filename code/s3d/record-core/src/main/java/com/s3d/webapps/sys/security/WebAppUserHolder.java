package com.s3d.webapps.sys.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.s3d.webapps.sys.security.userdetails.WebAppUser;

public class WebAppUserHolder {
	public static WebAppUser getAuthenticatedUser() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof WebAppUser) {
			return (WebAppUser) principal;
		}
		return null;
	}
}
