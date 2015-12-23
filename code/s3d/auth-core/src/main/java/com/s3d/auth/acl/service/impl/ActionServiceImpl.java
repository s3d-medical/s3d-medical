package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ActionDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.vo.ActionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/1 18:53
 */
@Service
@Transactional
public class ActionServiceImpl implements ActionService{
    private ActionDao actionDao;

    @Override
    public void saveOrUpdate(ActionVO actionVO) {
        Assert.isTrue(actionVO != null, "Action can not be null.");
        Assert.isTrue(StringUtils.isEmpty(actionVO.getActionName()), "Action name is not null");
        Assert.isTrue(StringUtils.isEmpty(actionVO.getState()), "Action state is not null");
        // check if this action no has been defined.
        Action action = new Action(actionVO.getId(), actionVO.getActionName(), actionVO.getModuleNo(), actionVO.getPageNo(), actionVO.getState());
        this.actionDao.saveOrUpdate(action);
    }

    @Override
    public List<Action> getActByIds(List<Integer> actionIds) {
       return this.actionDao.getActByIds(actionIds);
    }

    @Autowired
    public void setActionDao(ActionDao actionDao) {
        this.actionDao = actionDao;
    }
}
