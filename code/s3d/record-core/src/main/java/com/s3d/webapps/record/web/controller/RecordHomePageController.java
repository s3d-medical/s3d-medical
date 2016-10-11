package com.s3d.webapps.record.web.controller;

import com.s3d.tech.slicer.PageParam;
import com.s3d.webapps.record.dto.QRecordAccess;
import com.s3d.webapps.record.dto.QRecordParam;
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
import java.util.ArrayList;
import java.util.List;

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
            RecordHomePage homePage = this.recordHomePageService.getWithEmptyOne(seq);
            model.addAttribute("data", homePage);
            return model;
        } catch (Exception ex) {
            logger.error("Failed to get MedicalRecordHomePage", ex);
        }
        model.addAttribute("data", "");
        return model;
    }

    @RequestMapping(value = "/homepages", method = RequestMethod.POST)
    public Model saveMedicalRecordHomePageData(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody RecordHomePage recordHomePage) {
        // do something.
        try {
            if (recordHomePage != null) {
                this.recordHomePageService.insertOrReplace(recordHomePage);
                model.addAttribute("result", "ok");
                return model;
            }
        } catch (Exception ex) {
            logger.error("Failed to save RecordHomePage", ex);
        }
        model.addAttribute("result", "fail");
        return model;
    }

    @RequestMapping(value = "/userQuery", method = RequestMethod.GET)
    public Model queryRecordHomePageData(HttpServletRequest request,
                                               HttpServletResponse response,
                                               Model model) {
        QRecordParam qRecordParam = new QRecordParam(1, "007", 1);
        QRecordAccess access = new QRecordAccess();
        PageParam page = new PageParam();
        List<QRecordAccess> accessList = new ArrayList<QRecordAccess>();
        accessList.add(access);
        access.setDepartNo("001");
        access.getSignFields().add("1");
        access.getSignFields().add("2");
        access.getSignFields().add("3");
        access.getSignFields().add("4");
        access.getSignFields().add("5");
        List<RecordHomePage> result =  recordHomePageService.queryRecordsByAccess(qRecordParam, accessList, page);
        model.addAttribute("result", result);
        return model;
    }

    @Resource
    public void setRecordHomePageService(RecordHomePageService recordHomePageService) {
        this.recordHomePageService = recordHomePageService;
    }

    private RecordHomePageService recordHomePageService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
}
