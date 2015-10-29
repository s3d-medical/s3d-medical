package com.s3d.webapps.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Enumeration;


public class ConfigLocationsUtil {
    private static Logger logger = LoggerFactory.getLogger(ConfigLocationsUtil.class);
    private static String webContentPath;

    public static String getWebContentPath() {
        if(!StringUtils.hasText(webContentPath)){
            URL url = ConfigLocationsUtil.class.getClassLoader().getResource("");
            try {
                webContentPath = java.net.URLDecoder.decode(url.getPath(),"utf-8");
                webContentPath = webContentPath.substring(0,
                        webContentPath.lastIndexOf("/WEB-INF/"));
                if (webContentPath.startsWith("file:")) {
                    webContentPath = webContentPath.substring(5);
                }
            } catch (UnsupportedEncodingException e) {
                logger.error("Failed to get web content path", e.getCause());
            }
        }
        return webContentPath;
    }
}
