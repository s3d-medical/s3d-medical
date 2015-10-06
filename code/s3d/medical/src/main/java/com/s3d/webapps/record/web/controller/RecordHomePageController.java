package com.s3d.webapps.record.web.controller;

import com.s3d.webapps.record.entity.homepage.RecordHomePage;
import com.s3d.webapps.record.service.RecordHomePageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 * @date 2015/5/16.
 */
@Controller
@RequestMapping("/medicalRecord")
public class RecordHomePageController {
    @RequestMapping(value = "/homepages/show/{seq}", method = RequestMethod.GET)
    public ModelAndView showPage(HttpServletRequest request, HttpServletResponse response, @PathVariable String seq) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        modelAndView.addObject("seq", seq);
        return modelAndView;
    }

    /**
     * @return
     */
    @RequestMapping(value = "/homepages/{seq}", method = RequestMethod.GET)
    public Model getMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String seq) {
        try {
            RecordHomePage homePageVO = this.recordHomePageService.getByBusinessKey(seq);
            model.addAttribute("data", homePageVO);
            return model;
        } catch (Exception ex) {
            logger.error("Failed to get MedicalRecordHomePage", ex);
        }
        model.addAttribute("data", "");
        return model;
    }

    @RequestMapping(value = "/homepages", method = RequestMethod.POST)
    public Model saveMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody RecordHomePage medicalRecordHomePage) {
        // do something.
        try {
            if (medicalRecordHomePage != null) {
                this.recordHomePageService.saveOrUpdate(medicalRecordHomePage);
                model.addAttribute("result", "ok");
                return model;
            }
        } catch (Exception ex) {
            logger.error("Failed to save MedicalRecordHomePage", ex);
        }
        model.addAttribute("result", "fail");
        return model;
    }

    @Resource
    public void setRecordHomePageService(RecordHomePageService recordHomePageService) {
        this.recordHomePageService = recordHomePageService;
    }

    private RecordHomePageService recordHomePageService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
