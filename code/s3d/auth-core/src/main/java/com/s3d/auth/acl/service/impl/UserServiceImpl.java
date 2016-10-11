package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.dao.UserActionDao;
import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.UserService;
import com.s3d.auth.acl.vo.param.QueryUserParam;
import com.s3d.auth.acl.vo.UserBasicVO;
import com.s3d.auth.acl.vo.UserActionsVO;
import com.s3d.auth.acl.web.controller.helper.UserHelper;
import com.s3d.tech.encryption.DesEncryptUtil;
import com.s3d.tech.encryption.MD5StringUtil;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/22 12:03
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private OrgDao orgDao;
    private UserActionDao userActionDao;
    private ModuleDao moduleDao;

    @Override
    public void saveOrUpdate(UserBasicVO userBasicVO) {
        this.checkBeforeSaveOrUpdate(userBasicVO);
        User user = null;
        if(userBasicVO.getId() != null && userBasicVO.getId() > 0){
            user = this.userDao.get(userBasicVO.getId());
        }else{
            user = new User();
            user.setRegisterTime(new Date());
        }
        user.setLoginName(userBasicVO.getUserName());
        user.setState(1);
        user.setFullName(userBasicVO.getRealName());
        user.setCode(userBasicVO.getCode());
        user.setEmail(userBasicVO.getEmail());
        user.setPhone(userBasicVO.getPhone());
        user.setTel(userBasicVO.getTel());
        user.setKey(userBasicVO.getKey());
        user.setRemark(userBasicVO.getRemark());
        user.setLanguageId(userBasicVO.getLanguageId());
        Integer orgId = userBasicVO.getDepartmentId();
        Org org = this.orgDao.get(orgId);
        user.setOrg(org);
        this.userDao.saveOrUpdate(user);
    }

    @Override
    public void saveOrUpdate(User user) {
        if(user != null){
            this.userDao.saveOrUpdate(user);
        }
    }

    @Override
    public User getByLoginNamePwd(String loginName, String password) {
        if(StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)){
            return null;
        }
        try {
            // check from db.  encrypt password
            String encryptedPwd = MD5StringUtil.MD5Encode(password);
            // load user info.
            User user = this.userDao.getByLoginNamePwd(loginName, encryptedPwd);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("查找用户出错", e);
        }
    }

    @Override
    public User getById(Integer id) {
        if(id == null){
            return null;
        }
        return this.userDao.get(id);
    }

    @Override
    public User getById(String id) {
        if(StringUtils.isEmpty(id)){
            return null;
        }
        return  this.getById(Integer.parseInt(id));
    }

    @Override
    public List<User> getUsers(QueryUserParam queryUserParam) {
        Assert.isTrue(queryUserParam != null , "Query user parameter can not be null.");
        String fullName = queryUserParam.getRealName();
        Integer orgId = queryUserParam.getDepartmentId();
        if(StringUtils.isEmpty(fullName) && orgId == null){
            throw new RuntimeException("User name and organization id can not be null together.");
        }
        return this.userDao.getUsers(orgId, fullName);
    }

    @Override
    public PageResult<User> getUsers(Integer orgId, PageParam pageParam) {
        Long count = this.userDao.getUserCountInOrg(orgId);

        PageResult<User> result = new PageResult<User>();
        if(count != null && count > 0){
            List<User> userList = this.userDao.getUsers(orgId, pageParam);
            result.init(count, userList, pageParam.getPageSize(), pageParam.getPageNo());
        }else{
            result.init(count, null, pageParam.getPageSize(), pageParam.getPageNo());
        }
        return result;
    }

    @Override
    public List<User> getUsersByIds(List<Integer> userIds) {
        if(CollectionUtils.isEmpty(userIds)){
            return null;
        }
       return  this.userDao.getUsersByIds(userIds);
    }

    @Override
    public Set<User> getUserSetByIds(List<Integer> userIds) {
        if(userIds == null || userIds.size() ==0){
            return null;
        }

        return null;
    }

    private void checkBeforeSaveOrUpdate(UserBasicVO userBasicVO) {
        Assert.isTrue(userBasicVO != null, "Saved user can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userBasicVO.getUserName()), "User name used in login can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userBasicVO.getCode()), "User code can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userBasicVO.getEmail()), "User email can not be null");
        Assert.isTrue(this.existSameCode(userBasicVO.getId(), userBasicVO.getCode()) == false, "User code has been existing.");
        Assert.isTrue(this.existSameEmail(userBasicVO.getId(), userBasicVO.getEmail()) == false, "User email has been existing.");
        Assert.isTrue(this.existSameUserName(userBasicVO.getId(), userBasicVO.getUserName()) == false, "User name has been existing.");
    }

    @Override
    public boolean existSameEmail(Integer userId, String email) {
        if(StringUtils.isEmpty(email)){
            return false;
        }
        User user  = this.userDao.getByEmail(email);
        if(user == null){
            return false;
        }
        if(user.getId().equals(userId)){
            return false;
        }
        return true;
    }

    @Override
    public boolean existSameCode(Integer userId, String code) {
        if(StringUtils.isEmpty(code)){
            return false;
        }
        User user  = this.userDao.getByCode(code);
        if(user == null){
            return false;
        }
        if(user.getId().equals(userId)){
            return false;
        }
        return true;
    }

    @Override
    public boolean existSameUserName(Integer userId, String userName) {
        if(StringUtils.isEmpty(userName)){
            return false;
        }
        User user  = this.userDao.getByLoginName(userName);
        if(user == null){
            return false;
        }
        if(user.getId().equals(userId)){
            return false;
        }
        return true;
    }

    @Override
    public void delete(Integer id) {
        Assert.isTrue((id != null && id >0), "Given id is not valid.");
        this.delete(id);
    }

    @Override
    public void delete(List<Integer> ids) {
        Assert.isTrue((ids != null && ids.size() >0), "Given id list can not be empty.");
        userDao.deleteUsers(ids);
        /*for (Integer id : ids){
            this.userDao.delete(id);
        }*/
    }

    @Override
    public UserActionsVO getUserActions(Integer userId) {
        User user = userDao.get(userId);
//        List<UserAction> userActions = userActionDao.getUserActions(userId);
        // todo format user actions (group by category)
        List<Module> modules = moduleDao.getAllActionModules();
        UserActionsVO vo = UserHelper.convertUserRoles(user, modules);
        return vo;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }

    @Autowired
    public void setUserActionDao(UserActionDao userActionDao) {
        this.userActionDao = userActionDao;
    }

    @Autowired
    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }
}
