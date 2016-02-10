package com.s3d.tech.session;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class UserSession {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    /**
     * user id
     *
     * @param request
     * @return
     */
    public static <T> T get(HttpServletRequest request, String key) {
        if (request != null && !StringUtils.isEmpty(key)) {
            HttpSession session = request.getSession();
            return (T) session.getAttribute(key);
        }
        return null;
    }

    public static <T> T get(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return (T) map.get(key);
    }

    /**
     * get user login account.
     *
     * @param request
     * @return
     */
    public static void set(HttpServletRequest request, String key, Object value) {
        if (request != null && !StringUtils.isEmpty(key)) {
            HttpSession session = request.getSession();
            session.setAttribute(key, value);

            // set threadlocal value.
            Map<String, Object> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<String, Object>();
                threadLocal.set(map);
            }
            map.put(key, value);
        }
    }

    /**
     * copy http session data to thread local.
     * @param request
     */
    public static void copyHttpSessionData(HttpServletRequest request) {
        if (request != null) {
            HttpSession session = request.getSession();
            Enumeration attNames = session.getAttributeNames();
            Map<String, Object> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<String, Object>();
                threadLocal.set(map);
            }else{
                map.clear();
            }
            while (attNames.hasMoreElements()){
                String attName = attNames.nextElement().toString();
                map.put(attName, session.getAttribute(attName));
            }
        }
    }
}
