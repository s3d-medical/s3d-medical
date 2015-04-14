package com.s3d.webapps.cache.memcached.memcache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.s3d.webapps.cache.memcached.memcache.client.ErrorHandler;
import com.s3d.webapps.cache.memcached.memcache.client.MemcachedClient;


public class DefaultErrorHandlerImpl implements ErrorHandler
{
	
	private static final Log Logger = LogFactory.getLog(DefaultErrorHandlerImpl.class);

	public void handleErrorOnInit(MemcachedClient client, Throwable error)
	{
		Logger.error("ErrorOnInit",error);
	}

	public void handleErrorOnGet(MemcachedClient client, Throwable error, String cacheKey)
	{
		Logger.error(new StringBuilder("ErrorOnGet, cacheKey: ").append(cacheKey).toString(),error);
	}


	public void handleErrorOnGet(MemcachedClient client, Throwable error, String[] cacheKeys)
	{
		Logger.error(new StringBuilder("ErrorOnGet, cacheKey: ").append(cacheKeys).toString(),error);
	}

	
	public void handleErrorOnSet(MemcachedClient client, Throwable error, String cacheKey)
	{
		Logger.error(new StringBuilder("ErrorOnSet, cacheKey: ").append(cacheKey).toString(),error);
	}

	
	public void handleErrorOnDelete(MemcachedClient client, Throwable error, String cacheKey)
	{
		Logger.error(new StringBuilder("ErrorOnDelete, cacheKey: ").append(cacheKey).toString(),error);
	}

	
	public void handleErrorOnFlush(MemcachedClient client, Throwable error)
	{
		Logger.error("ErrorOnFlush",error);
	}

	
	public void handleErrorOnStats(MemcachedClient client, Throwable error)
	{
		Logger.error("ErrorOnStats",error);
	}
	
}
