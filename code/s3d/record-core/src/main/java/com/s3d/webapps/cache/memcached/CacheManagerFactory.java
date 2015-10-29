package com.s3d.webapps.cache.memcached;

import com.s3d.webapps.cache.memcached.memcache.MemcacheCacheManager;


public class CacheManagerFactory
{
	
	private CacheManagerFactory()
	{
	}
	
	private static CacheManagerFactory cmf = null;
	
	/**
	 * 获取CacheManagerFactory实例
	 * @return
	 */
	public static CacheManagerFactory getInstance()
	{
		if (cmf == null)
		{
			cmf = new CacheManagerFactory();
		}
		return cmf;
	}
	
	/**
	 * 获取MemcachedManager
	 * @return
	 */
	public CacheManager getMemCacheManager()
	{
		return new MemcacheCacheManager();
	}
	
}
