package com.s3d.webapps.access.config.web.controller;

import com.s3d.webapps.access.config.service.ConfigSetService;

import com.s3d.webapps.pub.datatype.ValidationStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wind.chen
 * @date 2015/5/23.
 */
@Controller
@RequestMapping("/config")
public class ConfigSetController {
    @RequestMapping(value = "/codetables", method = RequestMethod.GET)
    public Model getAllCodeTables(HttpServletRequest request, HttpServletResponse response, Model model) {
        String businessKey = request.getParameter("businessKey");
        String hospitalId = "";
        Map<String, Object> map = this.configSetService.getCodeTablesInMap(ValidationStatus.VALID, businessKey, hospitalId);
        model.addAttribute("settings", map);
        return model;
    }

    @Resource
    public void setConfigSetService(ConfigSetService configSetService) {
        this.configSetService = configSetService;
    }

    private ConfigSetService configSetService;

}
