package com.s3d.webapps.sys.security.userdetails;

import java.util.ArrayList;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;

import com.s3d.webapps.sys.security.persistence.User;


public class WebAppUser extends org.springframework.security.core.userdetails.User {
	public final static int LOCALE_TYPE_ORG = 0;

	public final static int LOCALE_TYPE_SPEC = 1;

	private UserAuthInfo userAuthInfo;

	private User user;

	private boolean admin;

	private boolean anonymous;

	private Locale locale;

	private String orgTree;

	private String orgTreeName;

	public String getOrgTree() throws Exception {
		return orgTree;
	}

	public void setOrgTree(String orgTree) {
		this.orgTree = orgTree;
	}

	public boolean isAdmin() {
		return admin;
	}

	public WebAppUser(User user, UserAuthInfo userAuthInfo) {
		super(user.getFdLoginName(), StringUtils
				.isEmpty(user.getFdPassword()) ? "0" : user.getFdPassword(),
						user.getFdIsAvailable().booleanValue(), true, true, true,
				new ArrayList<GrantedAuthority>(0));
		// super(username, password, enabled, accountNonExpired,
		// credentialsNonExpired, accountNonLocked, authorities);
		if (user.getFdParent() != null)
			user.getFdParent().getFdName();
		
		this.user = user;
		this.userAuthInfo = userAuthInfo;
		this.admin = userAuthInfo.getAuthRoleAliases()
				.contains("SYSROLE_ADMIN");
		this.anonymous = user.getFdLoginName().equals("anonymous");

		if (StringUtils.isEmpty(user.getFdDefaultLang())) {
			
		}
		this.locale = null;
	}

	public User getUser() {
		return user;
	}
	
	@Override
	public boolean isEnabled() {
		return user.getFdIsAvailable();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}
	
	public UserAuthInfo getUserAuthInfo() {
		return userAuthInfo;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getOrgTreeName() throws Exception {
		return this.orgTreeName;
	}

	public void setOrgTreeName(String orgTreeName) {
		this.orgTreeName = orgTreeName;
	}
}
