package com.s3d.auth.login.web.controller;


import com.s3d.auth.login.constants.LoginConstants;
import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.LoginParam;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.tech.spring.SpringControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String showHomePage(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "homePage";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        Model model, LoginParam loginParam) {
        // check logic
        if (loginParam == null || loginParam.getPassword() == null || loginParam.getUserName() == null) {
            return SpringControllerHelper.redirect("login?failed=Invalid user name and password.", null);
        }
        // authenticate it.
        boolean ifSuccess = authenticationService.authenticateUser(loginParam.getUserName(),
                loginParam.getPassword());
        if (!ifSuccess) {
            return SpringControllerHelper.redirect("login?auth=Invalid user name and password", null);
        }
        // set session and cookie.
        request.getSession().setAttribute(LoginConstants.USER_ACCOUNT, loginParam.getUserName());
        Cookie cookie = new Cookie(LoginConstants.USER_ACCOUNT, loginParam.getUserName());
        response.addCookie(cookie);
       return SpringControllerHelper.redirect("homePage", null);
    }

    public String logout(){
        return "";
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private AuthenticationService authenticationService;
}
