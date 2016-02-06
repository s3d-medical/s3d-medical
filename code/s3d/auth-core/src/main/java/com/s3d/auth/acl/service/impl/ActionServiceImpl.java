package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ActionDao;
import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.vo.ActionBasicVO;
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
    private ModuleDao moduleDao;

    @Override
    public void saveOrUpdate(ActionBasicVO actionBasicVO) {
        Assert.isTrue(actionBasicVO != null, "Action can not be null.");
        Assert.isTrue(StringUtils.isEmpty(actionBasicVO.getActionName()), "Action name is not null");
        Assert.isTrue(StringUtils.isEmpty(actionBasicVO.getState()), "Action state is not null");
        // check if this action no has been defined.
        Module module = moduleDao.getCodeModule(Integer.valueOf(actionBasicVO.getModuleNo()));
        Action action = new Action(actionBasicVO.getId(), actionBasicVO.getActionName(), module, actionBasicVO.getPageNo(), actionBasicVO.getState());
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

    @Autowired
    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }
}
