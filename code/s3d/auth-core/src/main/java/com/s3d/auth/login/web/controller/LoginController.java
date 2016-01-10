package com.s3d.auth.login.web.controller;


import com.s3d.auth.constants.LoginConstants;
import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.auth.login.vo.param.ResetPwdParam;
import com.s3d.tech.session.UserSession;
import com.s3d.tech.spring.SpringControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        // authenticate it.
        LoginUserVO loginUserVO = authenticationService.authenticatedUser(loginParam);
        if (loginUserVO == null || loginUserVO.getUserId() == null) {
            return SpringControllerHelper.redirect("login?auth=Invalid user name and password", null);
        }
        // set session and cookie.
        UserSession.set(request, LoginConstants.USER_ID, loginUserVO.getUserVO().getId());
        //request.getSession().setAttribute(LoginConstants.USER_ACCOUNT, loginParam.getUserName());
       // Cookie cookie = new Cookie(LoginConstants.USER_ACCOUNT, loginParam.getUserName());
       // response.addCookie(cookie);

        // set user authorities (actions)

       return SpringControllerHelper.redirect("homePage", null);
    }

    public String logout(){
        return "";
    }

    /**
     * reset password.
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String resetPwd(HttpServletRequest request, HttpServletResponse response, @RequestBody ResetPwdParam resetPwdParam){
        //this.authenticationService.resetPassword();
        return "";
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private AuthenticationService authenticationService;
}
