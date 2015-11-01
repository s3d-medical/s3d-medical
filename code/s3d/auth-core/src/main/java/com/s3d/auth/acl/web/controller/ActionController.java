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
 * @since authorization
 */
@Controller
public class ActionController {


    @RequestMapping(value = "/action" , method = RequestMethod.POST)
    public void add(HttpServletRequest request, final Model model){

    }

    @RequestMapping(value = "/action/{actionId}" , method = RequestMethod.GET)
    public void get(HttpServletRequest request, final Model model){

    }

    @RequestMapping(value = "/action/{actionId}" , method = RequestMethod.POST)
    public void update(HttpServletRequest request, final Model model, @PathVariable("actionId") Integer operationId){

    }
    @RequestMapping(value = "/actions" , method = RequestMethod.GET)
    public void getList(HttpServletRequest request, final Model model){

    }

    public List query(){
        return null;
    }

}
