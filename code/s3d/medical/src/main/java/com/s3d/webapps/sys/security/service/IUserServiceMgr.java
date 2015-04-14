package com.s3d.webapps.sys.security.service;

import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.userdetails.UserAuthInfo;


public interface IUserServiceMgr extends SecurityElementServiceMgr {
	String SERVICE_NAME = "userService";
	
	public User findByLoginName(String username);
	
	public User createAnonymousUser();
	
	public UserAuthInfo getOrgsUserAuthInfo(User user);
}
