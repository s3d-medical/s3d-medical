package com.s3d.auth.login.web.filter;

import com.s3d.auth.login.constants.LoginConstants;
import com.s3d.tech.utils.StringUtil;
import com.s3d.tech.utils.URLUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class CheckAuthenticationFilter implements Filter {
    private String loginUrl;
    private Set<String> allowUrlSet = new HashSet<String>();
    private Set<String> resourceSuffixSet = new HashSet<String>();
    private String homePageUrl="homePage";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.allowUrlSet.addAll(StringUtil.stringToSet(filterConfig.getInitParameter("ignoreUrls")));
        this.loginUrl = filterConfig.getInitParameter("loginUrl");
        this.resourceSuffixSet.addAll(StringUtil.stringToSet(filterConfig.getInitParameter("resourceSuffix")));
        this.homePageUrl = filterConfig.getInitParameter("homePageUrl");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // check is omitted url, if no check session.
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse  res = (HttpServletResponse)response;
        // check if root path
        if(isRoot(req)){
            this.toHomePage(req, res);
            return;
        }
        // Has been authenticated.
        if(!hasAuthenticated(req)){
            // need authenticated.
            if(isNeedAuthenticate(req)){
                this.toLoginPage(req, res);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isRoot( HttpServletRequest req){
        String uri=  req.getRequestURI();
        String endPath = URLUtils.getLastPathOfUrl(uri);
        if("/".equals(endPath)){
            return true;
        }
        return false;
    }

    private void toHomePage(HttpServletRequest request, HttpServletResponse  response) throws IOException {
        String uri = request.getRequestURI();
        response.sendRedirect(uri + this.homePageUrl.replaceFirst("/", ""));
    }

    private void toLoginPage(HttpServletRequest request, HttpServletResponse  response) throws IOException {
        response.sendRedirect(request.getContextPath() + this.loginUrl);
    }

    private boolean hasAuthenticated(HttpServletRequest httpServletRequest){
        // check authentication
        HttpSession session = httpServletRequest.getSession();
        String userAccount = (String)session.getAttribute(LoginConstants.USER_ACCOUNT);
        if(userAccount == null){
            return false;
        }
        return true;
    }

    private boolean isNeedAuthenticate(HttpServletRequest httpServletRequest){
        boolean result = true;
        String uri = httpServletRequest.getRequestURI();
        String endPath = URLUtils.getLastPathOfUrl(uri);
        // check is allowed urls.
        if(this.allowUrlSet.contains(endPath)){
            result = false;
            return result;
        }
        // if allow Url set.
        String suffix = URLUtils.getSuffixOfUrl(endPath);
        if(this.resourceSuffixSet.contains(suffix)){
            result = false;
            return result;
        }
        return result;
    }

    @Override
    public void destroy() {

    }
}
