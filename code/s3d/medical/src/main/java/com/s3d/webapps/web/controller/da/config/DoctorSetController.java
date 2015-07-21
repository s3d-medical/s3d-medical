package com.s3d.webapps.web.controller.da.config;

import com.s3d.webapps.config.persistence.ConfigDoctor;
import com.s3d.webapps.da.config.service.IDaConfigDoctorService;
import com.s3d.webapps.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Controller
@RequestMapping("/da/config/doctors")
public class DoctorSetController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request,Model model) {
        /*String type = request.getParameter("type");
        String[] v = getTypeAttribute(type);
        model.addAttribute("fdType", v[0]);
        model.addAttribute("descName", v[1]);
        model.addAttribute("descCode", v[2]);*/
        return "/da/config/doctor/index";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Model getDoctors(HttpServletRequest request, Model model) {
        String hospitalId = request.getParameter("hospitalId");
        List<ConfigDoctor> doctors;
        if (StringUtil.isNull(hospitalId)) {
            doctors = new ArrayList<ConfigDoctor>();
        } else {
            doctors = daConfigDoctorService.getDoctors(hospitalId);
        }
        model.addAttribute("doctors", doctors);
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addDoctorHome(HttpServletRequest request, Model model) {
        return "/da/config/doctor/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addDoctor(ConfigDoctor doctor) {
        daConfigDoctorService.addDoctor(doctor);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/edit/{doctorId}", method = RequestMethod.GET)
    public String editDoctorHome(HttpServletRequest request, Model model, @PathVariable Integer doctorId) {
        ConfigDoctor doctor = daConfigDoctorService.getDoctor(doctorId);
        model.addAttribute("doctor", doctor);
        return "/da/config/doctor/edit";
    }

    @RequestMapping(value = "/edit/{doctorId}", method = RequestMethod.POST)
    public ModelAndView editDoctor(ConfigDoctor doctor, Model model, @PathVariable Integer doctorId) {
        daConfigDoctorService.updateDoctor(doctor);
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/delete/{doctorId}", method = RequestMethod.GET)
    public ModelAndView deleteDoctor(HttpServletRequest request, Model model, @PathVariable Integer doctorId) {
        daConfigDoctorService.deleteDoctor(doctorId);
        return new ModelAndView("success");
    }

    private IDaConfigDoctorService daConfigDoctorService;

    @Autowired
    public void setDaConfigDoctorService(IDaConfigDoctorService daConfigDoctorService) {
        this.daConfigDoctorService = daConfigDoctorService;
    }

}
