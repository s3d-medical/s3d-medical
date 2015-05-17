package com.s3d.webapps.medicalrecord.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

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
    public Model getMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response,  Model model, @PathVariable String seq) {
        model.addAttribute("data", "ssssss");
        return model;
    }

    @RequestMapping(value = "/homepages/{seq}", method = RequestMethod.POST)
    public Model saveMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @PathVariable String seq) {
        // do something.
        model.addAttribute("result", "ok1111111111");
        model.addAttribute("result1", "222");
        model.addAttribute("result3", "4444");
        return model;
    }
}
