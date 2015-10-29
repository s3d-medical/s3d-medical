package com.s3d.webapps.cache.memcached;

import java.io.Serializable;

import org.springframework.util.Assert;

public class CacheUtils
{
	
	/**
	 * 通过Class得到Cache Key
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String keyOfClassPrefix(Class clazz) 
	{
		Assert.notNull(clazz);
		return clazz.getName();
	}
	
	/**
	 * 通过Class获取CacheKey
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String keyOfClass(Class clazz,Serializable id)
	{
		Assert.notNull(clazz);
		Assert.notNull(id);
		return clazz.getName() + "_" + id;
	}
	
	/**
	 * 通过Class以及Serializable得到Cache Key
	 * @param clazz
	 * @param id
	 * @return
	 */
	public static String keyOfObject(Object object,Serializable id)
	{
		Assert.notNull(object);
		Assert.notNull(id);
		return object.getClass().getName() + "_" + id;
	}
	
	public static void main(String[] args)
	{
		System.out.println(keyOfClassPrefix(CacheManager.class));
	}
}
