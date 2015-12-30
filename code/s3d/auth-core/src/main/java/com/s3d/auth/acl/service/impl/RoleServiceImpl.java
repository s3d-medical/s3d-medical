package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.RoleCategoryDao;
import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.RoleCategory;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.ActionService;
import com.s3d.auth.acl.service.RoleService;
import com.s3d.auth.acl.service.UserService;
import com.s3d.auth.acl.vo.param.IdListParam;
import com.s3d.auth.acl.vo.RoleBasicVO;
import com.s3d.auth.acl.vo.PageRoleVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
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

    @Override
    public void saveOrUpdate(RoleBasicVO roleBasicVO, List<Integer> actionIds, List<Integer> userIds) {
       // check.
//        Assert.isTrue(roleBasicVO != null, "Role can not be null.");
//        Assert.isTrue(StringUtils.isEmpty(roleBasicVO.getName()), "Role name is not null");
//        Assert.isTrue(StringUtils.isEmpty(roleBasicVO.getState()), "Role state is not null");
//        Assert.isTrue(StringUtils.isEmpty(roleBasicVO.getCreateId()), "Creator Id of the role can not be null.");
        boolean ifDuplicated = this.isDuplicatedRole(roleBasicVO.getName(), roleBasicVO.getId());
        if(ifDuplicated){
            throw new RuntimeException("Role name is duplicated with others.");
        }
        // create and save
        Role role = null;
        if(roleBasicVO.getId() != null){
            role = this.roleDao.get(roleBasicVO.getId());
        }else{
            role = new Role(roleBasicVO.getId(), roleBasicVO.getName(), roleBasicVO.getRemark(), roleBasicVO.getState());
        }
        List<Action> actionList = this.actionService.getActByIds(actionIds);// get actions
        List<User> userList =  this.userService.getUsersByIds(userIds);        // get users
        // create role and related info.
        role.addedActions(actionList);
        role.addUsers(userList);
        if(!StringUtils.isEmpty(roleBasicVO.getCategoryId()) ){
            RoleCategory roleCategory = this.roleCategoryDao.get(Integer.parseInt(roleBasicVO.getCategoryId()));
            role.setCategory(roleCategory);
        }
        User user = this.userService.getById(roleBasicVO.getCreateId());
        role.setCreator(user);
        this.roleDao.saveOrUpdate(role);
    }

    @Override
    public PageResult<PageRoleVO> getInPage(PageParam pageParam) {
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
                    PageRoleVO pageRoleVO = new PageRoleVO(role.getId(), role.getName(), role.getDesc());
                    if(role.getCategory() != null){
                        pageRoleVO.setCategory(role.getCategory().getId().toString());
                        pageRoleVO.setCreator(role.getCreator().getLoginName());
                    }
                    roleVOs.add(pageRoleVO);
                }
            }
        }
        PageResult<PageRoleVO> pageResult = new PageResult<PageRoleVO>(count, roleVOs, pageParam.getPageSize(), pageParam.getPageNo());
        return pageResult;
    }

    @Override
    public void delete(IdListParam idListParam) {
        roleDao.deleteRoles(idListParam.getIds());
    }

    @Override
    public boolean isDuplicatedRole(String roleName, Integer roleId) {
        if(StringUtils.isEmpty(roleName)){
            return false;
        }
        Role role = this.roleDao.getRoleByName(roleName);
        if(role != null){
            //new role , and find existing old role
            if(StringUtils.isEmpty(roleId)){
                return true;
            }else{
                // the role is updated.
                if(role.getId().equals(roleId)){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Role getById(Integer roleId) {
        Role role = this.roleDao.get(roleId);
        return null;
    }

    //////////////////////////////////////////// setter , getter /////////////////////////////////////
    private RoleDao roleDao;

    private ActionService actionService;

    private UserService userService;

    private RoleCategoryDao roleCategoryDao;

    @Autowired
    public void setActionService(ActionService actionService) {
        this.actionService = actionService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setRoleCategoryDao(RoleCategoryDao roleCategoryDao) {
        this.roleCategoryDao = roleCategoryDao;
    }
}
