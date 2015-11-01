package com.s3d.auth.acl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class UserController {
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public String getUserList(HttpServletRequest request, final Model model){
        // find user list and set model.
        return "userListPage";
    }

    @RequestMapping(value = "/users" , method = RequestMethod.POST)
    public void add(HttpServletRequest request, final Model model){

    }

    @RequestMapping(value = "/users/{userId}" , method = RequestMethod.DELETE)
    public void delete(HttpServletRequest request, final Model model,
                       @PathVariable("userId") Integer userId){

    }

    public void update(HttpServletRequest request, final Model model){

    }

    public List query(){
        return null;
    }
}
