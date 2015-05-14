package com.s3d.tech.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.URI;

/**
 * URL Utilities
 *
 * @author James Ye
 */
public final class URLUtils {

    public static String getRootDomain(String url) {
        try {
            url = url.replaceAll(" ", "%20");
            if (url.indexOf("?") > 0) {
                url = url.substring(0, url.indexOf("?"));
            }
            URI uri = new URI(url);
            String host = uri.getHost();
            // If the url is invalid, the host will be null
            if (host == null) {
                return "";
            }
            int startIndex = 0;
            int nextIndex = host.indexOf('.');
            int lastIndex = host.lastIndexOf('.');
            while (nextIndex < lastIndex) {
                startIndex = nextIndex + 1;
                nextIndex = host.indexOf('.', startIndex);
            }
            if (startIndex > 0) {
                return host.substring(startIndex);
            } else {
                return host;
            }
        } catch (Exception e) {
            log.error("Failed to get root domain from url '" + url + "'.", e);
        }
        return "";
    }

    public static String getDomain(String url) {
        try {
            return new URI(url).getHost();
        } catch (Exception e) {
            log.error("Failed to get domain from url '" + url + "'.", e);
        }
        return "";
    }

    private final static Log log = LogFactory.getLog(URLUtils.class);

}
