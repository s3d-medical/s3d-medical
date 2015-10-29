package com.s3d.webapps.common.service;

import org.springframework.util.Assert;

import com.s3d.tech.spring.SpringContextHolder;

public class EntityFactory {
	
	private static EntityFactory bf;
	
	private EntityFactory() {
		 
	}
	
	public static EntityFactory getInstance() {
		if (bf == null) {
			synchronized (EntityFactory.class) {
				bf = new EntityFactory();
			}
		}
		return bf;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends AbstractBaseServiceMgr> T getService(String serviceName) {
		Assert.hasText(serviceName);
		return (T)SpringContextHolder.getBean(serviceName);
	}
	
}
