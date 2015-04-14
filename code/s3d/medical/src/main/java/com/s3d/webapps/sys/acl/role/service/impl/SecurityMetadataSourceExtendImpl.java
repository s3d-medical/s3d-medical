package com.s3d.webapps.sys.acl.role.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.RegexRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import com.s3d.webapps.framework.spring.ResourceHolder;
import com.s3d.webapps.sys.acl.role.service.SecurityMetadataSourceExtend;
import com.s3d.webapps.util.WebAppsAntPathMatcher;

public class SecurityMetadataSourceExtendImpl implements
		SecurityMetadataSourceExtend{

	private boolean expire = false; // 过期标识

	private RequestMatcher requestMatcher; // 匹配规则

	private String matcher; // 规则标识

	private Map<String, Collection<ConfigAttribute>> kv = null;

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void init() {
		
	}
	
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		if (null == kv)
			load();
		Set<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : kv
				.entrySet()) {
			attributes.addAll(entry.getValue());
		}
		return attributes;
	}
	
	public Collection<ConfigAttribute> getAttributesByAntPath(String url){
		Iterator<String> iterator = kv.keySet().iterator();
		while (iterator.hasNext()) {
			String uri = iterator.next();
			WebAppsAntPathMatcher requestMatcher = new WebAppsAntPathMatcher(uri);
			if (requestMatcher.matches(url))
				return kv.get(uri);
		}
		return null;
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();

		// 检测是否刷新了资源
		if (isExpire()) {
			// 清空原本资源
			//kv.clear();
			expire = false;
		}

		// 如果资源Map为空的时候则重新加载一次
		if (null == kv)
			load();
		
		if (object instanceof String) {
			String url = (String) object;
			return getAttributesByAntPath(url);
		}
		// 检测请求与当前资源匹配的正确性
		Iterator<String> iterator = kv.keySet().iterator();
		while (iterator.hasNext()) {
			String uri = iterator.next();
			if (matcher.toLowerCase().equals("ant")) {
				requestMatcher = new WebAppsAntPathMatcher(uri);
			}
			if (matcher.toLowerCase().equals("regex")) {
				requestMatcher = new RegexRequestMatcher(uri, request
						.getMethod(), true);
			}
			if (requestMatcher.matches(request))
				return kv.get(uri);
		}
		return null;
	}

	/**
	 * 加载所有资源与权限的关系
	 */
	public void load() {
		kv = ResourceHolder.getUrlResources();
	}

	public void setMatcher(String matcher) {
		this.matcher = matcher;
	}

	public boolean isExpire() {
		return expire;
	}

	public void expireNow() {
		this.expire = true;
	}
}