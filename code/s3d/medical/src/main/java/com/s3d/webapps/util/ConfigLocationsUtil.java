package com.s3d.webapps.util;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;


public class ConfigLocationsUtil {
	
	private static String webContentPath;
	
	public static String getWebContentPath() {
		if (webContentPath == null) {
			URL url = null;
			try {
				Enumeration urls = Thread.currentThread()
						.getContextClassLoader().getResources("/");
				while (urls.hasMoreElements()) {
					URL tmpUrl = (URL) urls.nextElement();
					String tmpPath = tmpUrl.getPath();
					if (!tmpPath.endsWith("/")) {
						tmpPath = tmpPath + "/";
					}
					if (tmpPath.endsWith("WEB-INF/classes/")) {
						url = tmpUrl;
						break;
					}
				}

				if (url == null) {
					url = Thread.currentThread().getContextClassLoader()
							.getResource("da.properties");
				}
			} catch (IOException localIOException) {
			}
			webContentPath = url.getPath().substring(0,
					url.getPath().lastIndexOf("/WEB-INF/"));
			if (webContentPath.startsWith("file:")) {
				webContentPath = webContentPath.substring(5);
			}

			System.out.println("webContentPath:" + webContentPath + "\n");
		}
		return webContentPath;
	}


}
