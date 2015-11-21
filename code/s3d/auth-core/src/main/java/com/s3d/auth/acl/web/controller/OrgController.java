package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.service.OrgService;
import com.s3d.auth.acl.vo.OrgVO;
import com.s3d.auth.acl.web.controller.helper.OrgConvertor;
import com.s3d.auth.acl.web.controller.helper.ResultHelper;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class OrgController {
    private static Logger logger = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService;

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    @ResponseBody
    public List<Map> getAllOrgs(HttpServletRequest request, HttpServletResponse response, final Model model){
        List<Org> orgList = this.orgService.getAllOrgs();
       return OrgConvertor.toMapForGetAllOrgs(orgList);
    }

    // add or edit org.
    @RequestMapping(value = "/departments", method = RequestMethod.POST)
    public Model addOrg(HttpServletRequest request, HttpServletResponse response, final Model model, @RequestBody OrgVO orgVO) {
        try {
            orgService.saveOrUpdate(orgVO);
            ResultHelper.createSuccessResult(model);
        } catch (Exception e) {
            logger.error("Failed to add or save org.", e);
            ResultHelper.createFailResult(model, "error", e.getMessage());
        }
        return model;
    }

    // query sub orgs by page.
    @RequestMapping(value = "/departments/{orgId}/departments", method = RequestMethod.GET)
    @ResponseBody
    public Map querySubOrgs(HttpServletRequest request, HttpServletResponse response,
                            @PathVariable(value = "orgId") Integer orgId,
                               @RequestParam(value = "page", defaultValue = "0" ) Integer pageNo,
                               @RequestParam(value = "pageSize", defaultValue="10") Integer pageSize) {
        PageResult<OrgVO> pageResult = new PageResult<OrgVO>(0L, null, pageSize, pageNo);
        try {
            pageResult = this.orgService.getDirectChildrenPage(orgId, new PageParam(pageNo, pageSize));
        } catch (Exception e) {
            logger.error("Failed to query sub organizations. ", e);
        }
        return OrgConvertor.toMapForQuerySubOrgs(pageResult);
    }
}