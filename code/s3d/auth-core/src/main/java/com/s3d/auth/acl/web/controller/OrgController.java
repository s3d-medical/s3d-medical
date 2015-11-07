package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.service.OrgService;
import com.s3d.auth.acl.vo.OrgVO;
import com.s3d.auth.acl.web.controller.helper.ControllerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class OrgController {
    private static Logger logger = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService ;

    // add or edit org.
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Model addOrg(HttpServletRequest request, HttpServletResponse response, final Model model, OrgVO orgVO){
        try{
            orgService.saveOrUpdateOrg(orgVO);
            ControllerHelper.createSuccessResult(model);
        }catch (Exception e){
            logger.error("Failed to add or save org. ", e);
            ControllerHelper.createFailResult(model, "error", e.getMessage());
        }
        return model;
    }

    // delete org

    // query org by page.

    //
}
