package com.s3d.tech.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RequestUtils {
    public final static String CUR_USER_ID = "current_user_id";
    public final static String CUR_USER_NAME = "current_user_name";

    public static Integer getCurUserId(HttpServletRequest request) {
        if (request != null) {
            HttpSession session = request.getSession();
            return (Integer) session.getAttribute(CUR_USER_ID);
        }
        return null;
    }

    public static Integer getCurUserName(HttpServletRequest request) {
        if (request != null) {
            HttpSession session = request.getSession();
            return (Integer) session.getAttribute(CUR_USER_NAME);
        }
        return null;
    }

    public static void setCurUser(HttpServletRequest request, Integer id, String userName) {
        if (request != null) {
            HttpSession session = request.getSession();
            session.setAttribute(CUR_USER_ID, id);
            session.setAttribute(CUR_USER_NAME, userName);
        }

    }
}
