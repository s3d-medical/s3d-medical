package com.s3d.webapps.medicalrecord.web.controller;

import com.s3d.webapps.medicalrecord.service.MedicalRecordHomePageService;
import com.s3d.webapps.medicalrecord.vo.MedicalRecordHomePageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
public class MedicalRecordHomePageController {
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
            MedicalRecordHomePageVO homePageVO = this.medicalRecordHomePageService.getHomePageByBusinessKey(seq);
            model.addAttribute("data", homePageVO);
            return model;
        } catch (Exception ex) {
            logger.error("Failed to get MedicalRecordHomePage", ex.getCause());
        }
        model.addAttribute("data", null);
        return model;
    }

    @RequestMapping(value = "/homepages/{seq}", method = RequestMethod.POST)
    public Model saveMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String seq, @RequestBody MedicalRecordHomePageVO medicalRecordHomePageVO) {
        // do something.
        try {
            if (medicalRecordHomePageVO != null) {
                this.medicalRecordHomePageService.saveOrUpdateHomePage(medicalRecordHomePageVO);
                model.addAttribute("result", "ok");
                return model;
            }
        } catch (Exception ex) {
            logger.error("Failed to save MedicalRecordHomePage", ex.getCause());
        }
        model.addAttribute("result", "fail");
        return model;
    }

    @Resource
    public void setMedicalRecordHomePageService(MedicalRecordHomePageService medicalRecordHomePageService) {
        this.medicalRecordHomePageService = medicalRecordHomePageService;
    }

    private MedicalRecordHomePageService medicalRecordHomePageService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
