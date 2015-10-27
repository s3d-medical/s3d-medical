package com.s3d.auth.web.filter;

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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.allowUrlSet.addAll(StringUtil.stringToSet(filterConfig.getInitParameter("allowUrls")));
        this.loginUrl = filterConfig.getInitParameter("loginUrl");
        this.resourceSuffixSet.addAll(StringUtil.stringToSet(filterConfig.getInitParameter("resourceSuffix")));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // check is omitted url, if no check session.
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse  httpServletResponse = (HttpServletResponse)response;
        if(!hasAuthenticated(httpServletRequest)){
            if(isNeedAuthenticate(httpServletRequest)){
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + this.loginUrl);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    private boolean hasAuthenticated(HttpServletRequest httpServletRequest){
        // check authentication
        HttpSession session = httpServletRequest.getSession();
        Integer userId = (Integer)session.getAttribute("endUserId");
        if(userId == null){
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
