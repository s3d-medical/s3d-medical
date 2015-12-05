package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.service.RoleService;
import com.s3d.auth.acl.vo.param.IdListParam;
import com.s3d.auth.acl.vo.result.PageRoleVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

//    public Model addOrEditRole(final Model model, )

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Map getPageRoles(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageResult<PageRoleVO> pageResult = roleService.getRoles(new PageParam(page, pageSize));
        Map map = new HashMap();
        map.put("count", pageResult.getTotalRecords());
        map.put("result", pageResult.getResults());
        return map;
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Model deleteRoles(final Model model, @RequestBody IdListParam idListParam) {
        if (null == idListParam || null == idListParam.getIds() || idListParam.getIds().size() == 0) {
            model.addAttribute("status", "failure");
        } else {
            this.roleService.deleteRoles(idListParam);
            model.addAttribute("status", "succeed");
        }
        return model;
    }

    @Autowired
    private RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
