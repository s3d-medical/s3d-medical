package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.UserService;
import com.s3d.auth.acl.vo.param.QueryUserParam;
import com.s3d.auth.acl.vo.result.UserVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

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

    @Override
    public void saveOrUpdate(UserVO userVO) {
        this.checkBeforeSaveOrUpdate(userVO);
        User user = null;
        if(userVO.getId() != null && userVO.getId() > 0){
            user = this.userDao.get(userVO.getId());
        }else{
            user = new User();
            user.setRegisterTime(new Date());
        }
        user.setLoginName(userVO.getUserName());
        user.setState(1);
        user.setFullName(userVO.getRealName());
        user.setCode(userVO.getCode());
        user.setEmail(userVO.getEmail());
        user.setPhone(userVO.getPhone());
        user.setTel(userVO.getTel());
        user.setKey(userVO.getKey());
        user.setRemark(userVO.getRemark());
        user.setLanguageId(userVO.getLanguageId());
        Integer orgId = userVO.getDepartmentId();
        Org org = this.orgDao.get(orgId);
        user.setOrg(org);
        this.userDao.saveOrUpdate(user);
    }

    @Override
    public User getById(Integer id) {
        if(id == null){
            return null;
        }
        return this.userDao.get(id);
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

    private void checkBeforeSaveOrUpdate(UserVO userVO) {
        Assert.isTrue(userVO != null, "Saved user can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userVO.getUserName()), "User name used in login can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userVO.getCode()), "User code can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(userVO.getEmail()), "User email can not be null");
        Assert.isTrue(this.existSameCode(userVO.getId(), userVO.getCode()) == false, "User code has been existing.");
        Assert.isTrue(this.existSameEmail(userVO.getId(), userVO.getEmail()) == false, "User email has been existing.");
        Assert.isTrue(this.existSameUserName(userVO.getId(), userVO.getUserName()) == false, "User name has been existing.");
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

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }
}
