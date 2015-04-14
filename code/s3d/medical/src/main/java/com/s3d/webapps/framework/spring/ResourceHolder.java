package com.s3d.webapps.framework.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public abstract class ResourceHolder {
	
	private static ConcurrentMap<String, Collection<ConfigAttribute>> urlResMap = new ConcurrentHashMap <String, Collection<ConfigAttribute>>(); // url类资源集合
		
	public static void regsiterResource(String resource,String[] roles){
		if(roles.length==0) return;		
		List<ConfigAttribute> list = new ArrayList<ConfigAttribute>(roles.length);
		for (int i = 0; i < roles.length; i++) {
			list.add(new SecurityConfig(roles[i].trim()));
			
		}
		urlResMap.put(resource,list);
	}

	public static Map<String, Collection<ConfigAttribute>> getUrlResources() {
		return urlResMap;
	}

	public static void regsiterResource(String[] resources, String[] roles) {
		for (int i = 0; i < resources.length; i++) {
			regsiterResource(resources[i], roles);
		}
	}
}
