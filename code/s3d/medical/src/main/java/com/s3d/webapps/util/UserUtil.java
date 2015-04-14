package com.s3d.webapps.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;

import com.s3d.webapps.framework.spring.SpringContextHolder;
import com.s3d.webapps.sys.acl.role.service.SecurityMetadataSourceExtend;
import com.s3d.webapps.sys.security.WebAppUserHolder;
import com.s3d.webapps.sys.security.persistence.BaseSecurityElement;
import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.userdetails.WebAppUser;

public class UserUtil {

	private static WebAppUser anonymousUser;

	/**
	 * 校验当前用户是否具有某个指定资源的权限
	 * 
	 * @param url
	 * @return true有权限
	 */
	public static boolean checkAuthentication(String url) {
		WebAppUser user = getWebAppUser();
		if (user.isAdmin())
			return true;
		
		Collection<ConfigAttribute> rolelist = getSecurityMetadataSource().getAttributesByAntPath(url);
		if(rolelist==null) return true;
		
		List roles = user.getUserAuthInfo().getAuthRoleAliases();				
		for (Iterator iterator = rolelist.iterator(); iterator.hasNext();) {
			ConfigAttribute role = (ConfigAttribute) iterator.next();
			if (roles.contains(role))
				return true;
		}
		return false;
	}

	/**
	 * 判断当前用户是否属于某个ID
	 * 
	 * @param id
	 *            id，可以为个人、岗位、部门、机构、常用群组的ID
	 * @return
	 */
	public static boolean checkUserId(String id) {
		return getWebAppUser().getUserAuthInfo().getAuthOrgIds().contains(id);
	}

	/**
	 * 判断当前用户是否属于id列表中的一个
	 * 
	 * @param ids
	 *            id列表，可以为个人、岗位、部门、机构、常用群组的ID
	 * @return
	 */
	public static boolean checkUserIds(List ids) {
		return ArrayUtils.isListIntersect(ids, getWebAppUser().getUserAuthInfo()
				.getAuthOrgIds());
	}

	/**
	 * 判断当前用户是否属于某个组织架构
	 * 
	 * @param element
	 * @return
	 */
	public static boolean checkUserModel(BaseSecurityElement element) {
		return getWebAppUser().getUserAuthInfo().getAuthOrgIds().contains(
				element.getFdId());
	}

	/**
	 * 判断当前用户是否属于组织架构列表中的一个
	 * 
	 * @param elements
	 * @return
	 */
	public static boolean checkUserModels(List elements) {
		List ids = new ArrayList();
		for (int i = 0; i < elements.size(); i++)
			ids.add(((BaseSecurityElement) elements.get(i)).getFdId());
		return ArrayUtils.isListIntersect(ids, getWebAppUser().getUserAuthInfo()
				.getAuthOrgIds());
	}
	
	/**
	 * 判断当前用户是否具有某个角色
	 * 
	 * @param role
	 * @return
	 */
	public static boolean checkRole(WebAppUser user,String role) {
		if(null==user) user = getWebAppUser();
		if (user.isAdmin())
			return true;
		return user.getUserAuthInfo().getAuthRoleAliases().contains(role);
	}
	
	/**
	 * 判断当前用户是否具有某个角色
	 * 
	 * @param role
	 * @return
	 */
	public static boolean checkRole(String role) {
		WebAppUser user = getWebAppUser();
		return checkRole(user, role);
	}

	public static boolean checkRoles(Collection roles) {
		WebAppUser user = getWebAppUser();
		if (user.isAdmin())
			return true;
		return ArrayUtils.isListIntersect(roles, user.getUserAuthInfo()
				.getAuthRoleAliases());
	}

	/**
	 * 在程序中使用，获取当前登录用户
	 * 
	 * @return
	 */
	public static WebAppUser getWebAppUser() {
		WebAppUser rtnVal = null;
		try {
			rtnVal = WebAppUserHolder.getAuthenticatedUser();
		} catch (Exception e) {
		}
		if (rtnVal == null)
			return anonymousUser;
		return rtnVal;
	}

	/**
	 * 在页面中使用，获取当前登录用户
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static WebAppUser getWebAppUser(HttpServletRequest request,Authentication authentication) {
		WebAppUser rtnVal = WebAppUserHolder.getAuthenticatedUser();
		if (rtnVal == null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof WebAppUser) {
				rtnVal = (WebAppUser) principal;
			}
		}
		if (rtnVal == null)
			return anonymousUser;
		return rtnVal;
	}
	
	/**
	 * 在程序中使用，获取当前登录用户
	 * 
	 * @return
	 */
	public static User getUser() {
		return getWebAppUser().getUser();
	}


	public static void setAnonymousUser(WebAppUser anonymousUser) {
		UserUtil.anonymousUser = anonymousUser;
	}

	public static WebAppUser getAnonymousUser() {
		return anonymousUser;
	}
	
	private static SecurityMetadataSourceExtend securityMetadataSource;
	private static SecurityMetadataSourceExtend getSecurityMetadataSource() {
		if (securityMetadataSource == null)
			securityMetadataSource = (SecurityMetadataSourceExtend) SpringContextHolder.getBean("securityMetadataSource");
		return securityMetadataSource;
	}
}
