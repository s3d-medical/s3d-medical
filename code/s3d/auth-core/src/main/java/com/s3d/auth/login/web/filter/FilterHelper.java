package com.s3d.auth.login.web.filter;

import com.s3d.auth.constants.LoginConstants;
import com.s3d.tech.session.UserSession;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wind.chen
 * @desc com.s3d.auth.login.web.filter
 * @date 2016/1/6 19:49
 */
class FilterHelper {

    public static boolean hasAuthenticated(HttpServletRequest httpServletRequest){
        // check authentication
        Integer userId = UserSession.get(httpServletRequest, LoginConstants.USER_ID);
        if(userId == null){
            return false;
        }
        return true;
    }

}
