package com.s3d.webapps.cache.ehcache;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.s3d.webapps.util.IDGenerator;

public class WebAppCache {
	private static final Log logger = LogFactory.getLog(WebAppCache.class);

	private static Map<String, String> cacheNameMap = new HashMap<String, String>();

	private Cache cache;

	/**
	 * 内部函数
	 * 
	 * @param cacheName
	 * @param maxElementsInMemory
	 * @param overflowToDisk
	 * @param eternal
	 * @param timeToLiveSeconds
	 * @param timeToIdleSeconds
	 */
	protected WebAppCache(String cacheName, int maxElementsInMemory,
			boolean overflowToDisk, boolean eternal, long timeToLiveSeconds,
			long timeToIdleSeconds) {
		if (cacheNameMap.containsKey(cacheName)) {
			cacheName = (String) cacheNameMap.get(cacheName);
		} else {
			String newName = cacheName + IDGenerator.generateID();
			cacheNameMap.put(cacheName, newName);
			cacheName = newName;
		}
		CacheManager manager = CacheManager.getInstance();
		cache = manager.getCache(cacheName);
		if (cache == null) {
			cache = new Cache(cacheName, maxElementsInMemory, overflowToDisk,
					eternal, timeToLiveSeconds, timeToIdleSeconds);
			manager.addCache(cache);
		}
	}

	/**
	 * 读取一个持久的缓存，用默认的配置
	 * 
	 * @param c
	 */
	public WebAppCache(Class<?> c) {
		this(c, 5);
	}

	/**
	 * 读取一个持久的缓存，指定内存最大数量
	 * 
	 * @param c
	 * @param maxElementsInMemory
	 */
	public WebAppCache(Class<?> c, int maxElementsInMemory) {
		this(c.getName(), maxElementsInMemory, true, true, 0, 0);
	}

	/**
	 * 读取一个临时性的缓存
	 * 
	 * @param c
	 * @param maxElementsInMemory
	 *            内存最大数量
	 * @param overflowToDisk
	 *            当基于内存的对象数目达到了界限后，是否将溢出的对象写到硬盘
	 * @param timeToLiveSeconds
	 *            对象允许存在于缓存中的最长时间
	 * @param timeToIdleSeconds
	 *            允许对象处于空闲状态的最长时间
	 */
	public WebAppCache(Class<?> c, int maxElementsInMemory,
			boolean overflowToDisk, long timeToLiveSeconds,
			long timeToIdleSeconds) {
		this(c.getName(), maxElementsInMemory, overflowToDisk, false,
				timeToLiveSeconds, timeToIdleSeconds);
	}

	/**
	 * 从缓存中取一个值
	 * 
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		Element element = cache.get(key);
		if (element == null)
			return null;
		return element.getValue();
	}

	/**
	 * 往缓存中存一个值
	 * 
	 * @param key
	 * @param value
	 */
	public void put(String key, Object value) {
		cache.put(new Element(key, value));
	}

	/**
	 * 清除缓存
	 * 
	 * @param 
	 */
	public void clear() {
		cache.removeAll();
		CacheManager.getInstance().removeCache(cache.getName());
	}

	/**
	 * 关闭缓存
	 */
	protected static void shutdown() {
		CacheManager.getInstance().shutdown();
	}
}
