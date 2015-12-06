package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.service.RoleService;
import com.s3d.auth.acl.vo.param.IdListParam;
import com.s3d.auth.acl.vo.result.ActionVO;
import com.s3d.auth.acl.vo.result.PageRoleVO;
import com.s3d.auth.acl.vo.result.RoleVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
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

    @Override
    public PageResult<PageRoleVO> getRoles(PageParam pageParam) {
        if (pageParam.isValid() == false) {
            throw new RuntimeException("Parameters form pagination is wrong.");
        }
        Long count = roleDao.getRolesCount(pageParam);
        List<PageRoleVO> roleVOs = new ArrayList<PageRoleVO>();
        if (null != count && count > 0) {
            List<Role> roles = roleDao.getRoles(pageParam);
            if (null != roles && roles.size() > 0) {
                for (int i = 0; i < roles.size(); i++) {
                    Role role = roles.get(i);
                    PageRoleVO vo = new PageRoleVO(role.getId(), role.getName(), role.getDesc(), "", "");
                    roleVOs.add(vo);
                }
            }
        }
        PageResult<PageRoleVO> pageResult = new PageResult<PageRoleVO>(count, roleVOs, pageParam.getPageSize(), pageParam.getPageNo());
        return pageResult;
    }

    @Override
    public void deleteRoles(IdListParam idListParam) {
        roleDao.deleteRoles(idListParam.getIds());
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
