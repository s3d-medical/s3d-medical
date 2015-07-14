package com.s3d.webapps.web.controller.da.config;

import com.s3d.webapps.common.controller.BaseController;
import com.s3d.webapps.common.json.IJSONSerializeConfig;
import com.s3d.webapps.da.config.persistence.DaConfigSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gary.Feng on 2015/7/12.
 */
@Controller
@RequestMapping("/da/config/doctors")
public class DoctorSetController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
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
        List<DoctorVO> vos = new ArrayList<DoctorVO>();
        vos.add(new DoctorVO(1, "Kevin", "k", 1));
        vos.add(new DoctorVO(2, "Stin", "s", 1));
        vos.add(new DoctorVO(3, "Krol", "l", 1));
        model.addAttribute("doctors", vos);
        return model;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Model addDoctor(HttpServletRequest request, Model model) {

        return model;
    }

    @RequestMapping(value = "/edit/{doctorId}", method = RequestMethod.PUT)
    public Model editDoctor(HttpServletRequest request, Model model, @PathVariable Integer doctorId) {

        return model;
    }

    @RequestMapping(value = "/delete/{doctorId}", method = RequestMethod.DELETE)
    public Model deleteDoctor(HttpServletRequest request, Model model, @PathVariable Integer doctorId) {

        return model;
    }

    protected IJSONSerializeConfig listjsonSerializeConfig() {
        return null;
    }

    class DoctorVO {
        private Integer id;
        private String name;
        private String shortcut;
        private Integer status;

        public DoctorVO (Integer id, String name, String shortcut, Integer status) {
            this.id = id;
            this.name = name;
            this.shortcut = shortcut;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShortcut() {
            return shortcut;
        }

        public void setShortcut(String shortcut) {
            this.shortcut = shortcut;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }
}
