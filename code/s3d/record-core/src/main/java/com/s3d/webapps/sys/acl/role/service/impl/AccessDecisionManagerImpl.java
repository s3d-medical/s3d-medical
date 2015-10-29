package com.s3d.webapps.sys.acl.role.service.impl;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;

import com.s3d.webapps.sys.security.userdetails.WebAppUser;
import com.s3d.webapps.util.UserUtil;

public class AccessDecisionManagerImpl implements AccessDecisionManager {

	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (null == attributes)
			return;
		WebAppUser user = null;
		if (authentication.getPrincipal() instanceof WebAppUser) {
			user = (WebAppUser) authentication.getPrincipal();
			if(user.isAdmin()) return; 
		}
		
		for (ConfigAttribute attribute : attributes) {
			String needRole = ((SecurityConfig) attribute).getAttribute();
			if(UserUtil.checkRole(user,needRole))
				return;
		}
		throw new AccessDeniedException("权限不足!");
	}

	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
}