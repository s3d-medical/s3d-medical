package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.RoleService;
import com.s3d.auth.acl.vo.param.IdListParam;
import com.s3d.auth.acl.vo.PageRoleVO;
import com.s3d.auth.acl.vo.RoleAddedVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
public class RoleController {

  @RequestMapping(value="/roles", method = RequestMethod.POST)
  public Model addOrUpdateRole(HttpServletRequest request, final Model model, @RequestBody RoleAddedVO roleAddedVO){
    boolean ifSuccess = false;
    try {
        this.roleService.saveOrUpdate(roleAddedVO, roleAddedVO.getPermissions(), roleAddedVO.getUsers());
    }catch (Exception ex){
        logger.error("Failed to save or update role.", ex);
    }
      if(ifSuccess){
          model.addAttribute("status","succeed");
      }else{
          model.addAttribute("status","failed");
      }
      return model;
  }

    @RequestMapping(value = "/roles", method = RequestMethod.DELETE)
    public Model deleteRoles(final Model model, @RequestBody IdListParam idListParam) {
        if (null == idListParam || null == idListParam.getIds() || idListParam.getIds().size() == 0) {
            model.addAttribute("status", "failure");
        } else {
            this.roleService.delete(idListParam);
            model.addAttribute("status", "succeed");
        }
        return model;
    }

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    @ResponseBody
    public Map getPageRoles(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageResult<PageRoleVO> pageResult = roleService.getInPage(new PageParam(page, pageSize));
        Map map = new HashMap();
        map.put("count", pageResult.getTotalRecords());
        map.put("result", pageResult.getResults());
        return map;
    }

    @RequestMapping(value = "/roles/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public Map getRole(HttpServletRequest request, final Model model, @PathVariable(value = "roleId") Integer roleId) {
        Map result = roleService.getRoleById(roleId);
        return result;
    }

    private RoleService roleService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
