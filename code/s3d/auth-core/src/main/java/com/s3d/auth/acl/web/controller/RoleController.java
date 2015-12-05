package com.s3d.auth.acl.web.controller;

import com.s3d.auth.acl.vo.result.PageRoleVO;
import com.s3d.tech.slicer.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public Map getPageRoles(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        PageResult<PageRoleVO> pageResult = new PageResult<PageRoleVO>();
        Map map = new HashMap();
        map.put("count", pageResult.getTotalRecords());
        map.put("result", pageResult.getResults());
        return map;
    }

}
