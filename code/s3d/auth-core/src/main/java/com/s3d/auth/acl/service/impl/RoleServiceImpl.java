package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.service.RoleService;
import com.s3d.auth.acl.vo.result.ActionVO;
import com.s3d.auth.acl.vo.result.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/1 18:53
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    private ActionService actionService;

    @Override
    public void saveOrUpdate(RoleVO roleVO) {
        Assert.isTrue(roleVO != null, "Role can not be null.");
        Assert.isTrue(StringUtils.isEmpty(roleVO.getName()), "Role name is not null");
        Assert.isTrue(StringUtils.isEmpty(roleVO.getState()), "Role state is not null");
        // load assigned actions.
        List<Action> actions = null;
        if(!CollectionUtils.isEmpty(roleVO.getActions())){
            List<Integer> actionIds = new ArrayList<Integer>();
            for(ActionVO actionVO : roleVO.getActions()){
                if(actionVO.getId() != null){
                    actionIds.add(actionVO.getId());
                }
            }
           actions = this.actionService.getActionsByIds(actionIds);
        }
        //
        if(roleVO.getId() != null){

        }
        // update role
        // check if this action no has been defined.
        Role role = new Role(roleVO.getId(), roleVO.getName(), roleVO.getDesc(), roleVO.getState());
        // load actions.

        this.roleDao.saveOrUpdate(role);
    }

    @Autowired
    public void setActionDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setActionService(ActionService actionService) {
        this.actionService = actionService;
    }
}
