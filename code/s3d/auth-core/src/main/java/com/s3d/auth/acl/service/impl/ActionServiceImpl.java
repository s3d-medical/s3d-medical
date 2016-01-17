package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ActionDao;
import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.vo.ActionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/1 18:53
 */
@Service
@Transactional
public class ActionServiceImpl implements ActionService{
    private ActionDao actionDao;
    private ModuleDao moduleDao;

    @Override
    public void saveOrUpdate(ActionVO actionVO) {
        Assert.isTrue(actionVO != null, "Action can not be null.");
        Assert.isTrue(StringUtils.isEmpty(actionVO.getActionName()), "Action name is not null");
        Assert.isTrue(StringUtils.isEmpty(actionVO.getState()), "Action state is not null");
        // check if this action no has been defined.
        Module module = moduleDao.getCodeModule(Integer.valueOf(actionVO.getModuleNo()));
        Action action = new Action(actionVO.getId(), actionVO.getActionName(), module, actionVO.getPageNo(), actionVO.getState());
        this.actionDao.saveOrUpdate(action);
    }

    @Override
    public List<Action> getActByIds(List<Integer> actionIds) {
       return this.actionDao.getActByIds(actionIds);
    }

    @Override
    public Map getActionVO(Integer actionId) {
        Action action = actionDao.get(actionId);
        Map result = new HashMap();
        result.put("text", action.getActionName());
        result.put("remark", action.getRemark());
        List<String> roles = new ArrayList<String>();
        for (Role role : action.getRoles()) {
            roles.add(role.getName());
        }
        List<String> departments = new ArrayList<String>();
        for (User user : action.getUsers()) {
            departments.add(user.getOrg().getName());
        }
        result.put("roles", roles);
        result.put("departments", departments);
        return result;
    }

    @Autowired
    public void setActionDao(ActionDao actionDao) {
        this.actionDao = actionDao;
    }

    @Autowired
    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }
}
