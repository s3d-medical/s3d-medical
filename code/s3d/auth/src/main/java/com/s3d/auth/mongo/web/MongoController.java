package com.s3d.auth.mongo.web;

import com.s3d.auth.mongo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Wind.Chen
 * @date 2015/6/30.
 */
@Controller
public class MongoController {
    @RequestMapping(value="/{eventUrl}/mongo/data", method = RequestMethod.POST)
    public Model insert(HttpServletResponse response, HttpServletRequest request, Model model,
                        @RequestParam(value = "amount", required = false, defaultValue = "0") Integer amount){


        return model;
    }

    @Autowired
    private DemoService mongoService;

}
