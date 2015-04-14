package com.s3d.webapps.da.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public abstract class DASysProperties {
	private static PropertiesConfiguration propertyConfiguration;

	public static String getConfiguration(String name1) {
		try {
			if (propertyConfiguration == null)
				propertyConfiguration = new PropertiesConfiguration(
						"da.properties");
			if(name1!=null)
				return propertyConfiguration.getString(name1);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void saveConfiguration(String name1, String value) throws ConfigurationException {
		getConfiguration(null);
		if (propertyConfiguration == null)
			return;
		propertyConfiguration.setProperty(name1, value);
		propertyConfiguration.save();
	}

	
	/**
	 * 服务器图片目录
	 * @return
	 */
	public static String getDataFilePath(){
		String path = getConfiguration("p_datafilepath");
		path = path.replace('\\', '/');
		if(path.endsWith("/"))
			path = path.substring(0,path.length()-1);
		
		return path;
	}
	
	public static Map<String, String> getMap(){
		getConfiguration(null);
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator<String> iterator = propertyConfiguration.getKeys(); iterator.hasNext();) {
			String key = iterator.next();
			map.put(key, getConfiguration(key));
		}
		return map;
	}
}
