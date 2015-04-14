package com.s3d.webapps.sys.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.userdetails.WebAppUser;

public interface IWebAppUserDetailsService extends UserDetailsService {
	public abstract WebAppUser buildWebAppUser(User user)
			throws Exception;

	public WebAppUser loadUserByUserId(String userId)
			throws UsernameNotFoundException;

	public WebAppUser loadUserByUsername(String username)
			throws UsernameNotFoundException;

}
