package com.s3d.webapps.web.controller.da.config;

import com.s3d.webapps.config.persistence.ConfigOperation;
import com.s3d.webapps.da.config.service.IDaConfigOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/21.
 */
@Controller
@RequestMapping("/da/config/operations")
public class OperationSetController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model) {
        return "/da/config/operation/index";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Model getOperations(HttpServletRequest request, Model model) {
        String hospitalId = request.getParameter("hospitalId");
        List<ConfigOperation> operations = operationService.getOperations(hospitalId);
        model.addAttribute("operations", operations);
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addOperationHome(HttpServletRequest request, Model model) {
        return "/da/config/operation/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addOperation(ConfigOperation operation) {
        operationService.addOperation(operation);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/edit/{operationId}", method = RequestMethod.GET)
    public String editOperationHome(HttpServletRequest request, Model model, @PathVariable Integer operationId) {
        ConfigOperation operation = operationService.getOperation(operationId);
        model.addAttribute("operation", operation);
        return "/da/config/operation/edit";
    }

    @RequestMapping(value = "/edit/{operationId}", method = RequestMethod.POST)
    public ModelAndView editOperation(ConfigOperation operation, Model model, @PathVariable Integer operationId) {
        operationService.updateOperation(operation);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/delete/{operationId}", method = RequestMethod.GET)
    public ModelAndView deleteOperation(HttpServletRequest request, Model model, @PathVariable Integer operationId) {
        operationService.deleteOperation(operationId);
        return new ModelAndView("success");
    }

    @Autowired
    private IDaConfigOperationService operationService;

    public void setOperationService(IDaConfigOperationService operationService) {
        this.operationService = operationService;
    }
}
