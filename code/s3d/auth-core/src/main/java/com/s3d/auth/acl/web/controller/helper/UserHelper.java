package com.s3d.auth.acl.web.controller.helper;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.entity.UserAction;
import com.s3d.auth.acl.vo.UserActionsVO;

import java.util.*;

/**
 * Created by Gary.Feng on 2016/1/13.
 */
public class UserHelper {

    public static UserActionsVO convertUserRoles(User user, List<Module> modules) {
        UserActionsVO vo = new UserActionsVO();
        vo.setId(user.getId());
        vo.setName(user.getFullName());
        vo.setRemark(user.getRemark());
        String[] orgs = new String[]{user.getOrg().getName()};
        vo.setDepartments(orgs);
        List<Map> moduleVOs = new ArrayList<Map>();
        for (Module module : modules) {
            Map moduleVO = new HashMap();
            List<Map> actionVOs = new ArrayList<Map>();
            for (Action action : user.getActions()) {
                if (action.getModule().getId() == module.getId()) {
                    Map actionVO = new HashMap();
                    actionVO.put("id", action.getId());
                    actionVO.put("text", action.getActionName());
                    actionVOs.add(actionVO);
                }
            }
            if (actionVOs.size() > 0) {
                moduleVO.put("id", module.getId());
                moduleVO.put("text", module.getName());
                moduleVO.put("nodes", actionVOs);
                moduleVOs.add(moduleVO);
            }
        }
        vo.setPermissionCategories(moduleVOs);
        return vo;
    }
}
