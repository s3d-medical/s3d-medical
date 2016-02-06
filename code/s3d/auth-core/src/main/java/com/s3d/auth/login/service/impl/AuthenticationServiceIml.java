package com.s3d.auth.login.service.impl;

import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.vo.UserVO;
import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.auth.login.vo.param.ResetPwdParam;

import com.s3d.tech.encryption.StringEncryptUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author wind.chen
 * @since  2015/7/19.
 */
@Service
@Transactional
public class AuthenticationServiceIml implements AuthenticationService {
    @Override
    public LoginUserVO authenticatedUser(String userLoginName, String password) {
        if(StringUtils.isEmpty(userLoginName) || StringUtils.isEmpty(password)){
            return null;
        }
        try {
            // check from db.  encrypt password
            String encryptedPwd = StringEncryptUtil.decrypt(password);
            // load user info.
           User user = this.userDao.getByLoginNamePwd(userLoginName, encryptedPwd);
           if(user == null){

           }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("用户认证失败", e);
        }
    }

    @Override
    public LoginUserVO authenticatedUser(LoginParam loginParam) {
       if(loginParam == null){
           return null;
       }
        return this.authenticatedUser(loginParam.getUserName(), loginParam.getPassword());

    }

    @Override
    public LoginUserVO findUser(String userAccount) {
        LoginUserVO loginUserVO = new LoginUserVO();

        return loginUserVO;
    }

    @Override
    public boolean resetPassword(ResetPwdParam resetPwdParam) {
        // find user.

        // compare password.
        return false;
    }

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
