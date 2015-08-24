package com.s3d.tech.spring;

import org.apache.commons.lang3.StringUtils;

/**
 * @author wind.chen
 * @since 2015/7/22.
 */
public class SpringControllerHelper {
    public static String redirect(String targetUrlPath, String param){
        StringBuilder sb = new StringBuilder();
        sb.append("redirect:");
        sb.append(targetUrlPath);
        if(!StringUtils.isEmpty(param)){
            sb.append(param);
        }
        return sb.toString();
    }
}
