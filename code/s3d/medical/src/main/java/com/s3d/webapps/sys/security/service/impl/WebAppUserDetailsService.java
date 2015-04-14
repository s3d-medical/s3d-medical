package com.s3d.webapps.sys.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.s3d.webapps.common.exception.WebAppsRuntimeException;
import com.s3d.webapps.sys.acl.role.persistence.SysRole;
import com.s3d.webapps.sys.acl.role.service.SysRoleServiceMgr;
import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.service.IUserServiceMgr;
import com.s3d.webapps.sys.security.service.IWebAppUserDetailsService;
import com.s3d.webapps.sys.security.userdetails.UserAuthInfo;
import com.s3d.webapps.sys.security.userdetails.WebAppUser;
import com.s3d.webapps.util.UserUtil;

public class WebAppUserDetailsService implements IWebAppUserDetailsService,
		InitializingBean {

	private static Log log = LogFactory.getLog(WebAppUserDetailsService.class);

	
	private IUserServiceMgr userService;
		
	
	private SysRoleServiceMgr sysRoleServiceMgr;

	@Autowired
	public void setUserService(IUserServiceMgr userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setSysRoleServiceMgr(SysRoleServiceMgr sysRoleServiceMgr) {
		this.sysRoleServiceMgr = sysRoleServiceMgr;
	}

	public WebAppUser buildWebAppUser(User user) throws Exception {
		if (user == null || !user.getFdIsAvailable().booleanValue())
			throw new UsernameNotFoundException("User not found");
		UserAuthInfo authInfo = userService.getOrgsUserAuthInfo(user);
		List aliases = sysRoleServiceMgr.getRoleAliasesByOrgIds(authInfo
				.getAuthOrgIds());

		if (!user.isAnonymous())
			aliases.add("SYSROLE_USER");
		authInfo.setAuthRoleAliases(aliases);
		WebAppUser webappuser = new WebAppUser(user, authInfo);
		
		return webappuser;
	}

	public WebAppUser loadUserByUserId(String userId)
			throws UsernameNotFoundException {
		try {
			User user = (User) userService.findByPrimaryKey(userId);
			if (user != null) {
				log.debug("loadUserByUserKeyword person Name:"+ user.getFdName());
			} else {
				log.debug("loadUserByUserKeyword person is null.");
			}
			return buildWebAppUser(user);
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new WebAppsRuntimeException(e);
		}
	}

	public WebAppUser loadUserByUsername(String username)
			throws UsernameNotFoundException {
		try {
			User user = userService.findByLoginName(username);
			if (user != null) {
				log.debug("loadUserByUserKeyword person Name:"
						+ user.getFdName());
			} else {
				log.debug("loadUserByUserKeyword person is null.");
			}
			return buildWebAppUser(user);
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Exception e) {
			throw new WebAppsRuntimeException(e);
		}
	}

	private void initAdminAndRole() throws Exception {
		User adminuser = initAdmin();
		initRole(adminuser);
	}
	
	private User initAdmin() throws Exception {
		User adminuser = (User) this.userService
				.findByPrimaryKey("c81e728d9d4c2f636f067f89cc14862c", null,
						true);
		if (adminuser == null) {
			adminuser = new User();
			adminuser.setFdId("c81e728d9d4c2f636f067f89cc14862c");
			adminuser.setFdName("管理员");
			adminuser.setFdLoginName("admin");
			adminuser.setFdPassword("d437df002f7a5c8555c107af8a643977");
			adminuser.setFdIsAvailable(new Boolean(true));
			this.userService.add(adminuser);
		}
		return adminuser;
	}

	private void initRole(User adminPerson) throws Exception {
		List rtnList = this.sysRoleServiceMgr.findList(
				"sysRole.fdAlias = 'SYSROLE_ADMIN'", null);
		if (rtnList.isEmpty()) {
			List elements = new ArrayList();
			elements.add(adminPerson);
			SysRole adminAuthRole = new SysRole();
			adminAuthRole.setFdId("13f0922fa3ee00e4b1dc9d44e3c9a4ff");
			adminAuthRole.setFdName("SYSROLE_ADMIN");
			adminAuthRole.setFdAlias("SYSROLE_ADMIN");
			adminAuthRole.setFdDescription("系统超级管理员_系统所有权限");
			adminAuthRole.setFdOrgElements(elements);
			adminAuthRole.setFdIsSysRole(true);
			this.sysRoleServiceMgr.add(adminAuthRole);
		}
	}
	
	public void afterPropertiesSet() throws Exception {
		initAdminAndRole();
		UserUtil.setAnonymousUser(buildWebAppUser(userService.createAnonymousUser()));
	}	
}
