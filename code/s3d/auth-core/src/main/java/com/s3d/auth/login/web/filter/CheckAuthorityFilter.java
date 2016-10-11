package com.s3d.auth.login.web.filter;

import com.s3d.auth.constants.LoginConstants;
import com.s3d.tech.session.UserSession;
import com.s3d.tech.utils.StringUtil;
import com.s3d.tech.utils.URLUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class CheckAuthorityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // check is omitted url, if no check session.
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse  res = (HttpServletResponse)response;
        // set
        if(FilterHelper.hasAuthenticated(req)){
            UserSession.copyHttpSessionData(req);
        }
        // check current user has authority to execute this action.

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
