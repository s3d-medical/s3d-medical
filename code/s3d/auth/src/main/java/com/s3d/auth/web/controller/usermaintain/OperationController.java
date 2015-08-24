package com.s3d.auth.web.controller.usermaintain;

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
public class OperationController {

    @RequestMapping(value = "/operations" , method = RequestMethod.POST)
    public void add(HttpServletRequest request, final Model model){

    }

    @RequestMapping(value = "/operations/{operationId}" , method = RequestMethod.POST)
    public void delete(HttpServletRequest request, final Model model,
                       @PathVariable("operationId") Integer operationId){

    }

    public void update(){

    }

    public List query(){
        return null;
    }

}
