package com.s3d.auth.web.controller;

import com.s3d.auth.service.AuthenticationService;
import com.s3d.auth.vo.LoginParam;
import com.s3d.auth.vo.RegisteredUserVO;
import com.s3d.tech.spring.SpringControllerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class AuthenticationController {
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        return "loginPage";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        Model model, LoginParam loginParam) {
        // check logic
        if (loginParam == null || loginParam.getPassword() == null || loginParam.getUserName() == null) {
            return SpringControllerHelper.redirect("login?failed=Invalid user name and password.", null);
        }
        boolean ifSuccess = authenticationService.authenticateUser(loginParam.getUserName(),
                loginParam.getPassword());
        if (!ifSuccess) {
            return SpringControllerHelper.redirect("login?auth=Invalid user name and password", null);
        }
        RegisteredUserVO registeredUserVO = this.authenticationService.findUser(loginParam.getUserName());
        request.getSession().setAttribute("endUserId", registeredUserVO.getUserBasicInfoVO().getUserId());
        return SpringControllerHelper.redirect("home", null);
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
