package com.s3d.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String goHome2(HttpServletRequest request, final Model model){
        // find user list and set model.
        return "homePage";
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String goHomePage(HttpServletRequest request, final Model model){
        // find user list and set model.
        return "homePage";
    }
}
