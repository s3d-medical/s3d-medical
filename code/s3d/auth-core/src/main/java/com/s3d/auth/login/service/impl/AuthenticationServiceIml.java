package com.s3d.auth.login.service.impl;

import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.service.UserService;
import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.LoginAuthUserVO;
import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.param.ResetPwdParam;

import com.s3d.tech.encryption.MD5StringUtil;
import com.s3d.tech.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
@Service
@Transactional
public class AuthenticationServiceIml implements AuthenticationService {

    public LoginAuthUserVO authenticatedUser(String userLoginName, String password) {
        if (StringUtils.isEmpty(userLoginName) || StringUtils.isEmpty(password)) {
            return null;
        }
        User user = this.userService.getByLoginNamePwd(userLoginName, password);
        LoginAuthUserVO loginAuthUserVO = new LoginAuthUserVO(user);
        return loginAuthUserVO;

    }

    @Override
    public LoginAuthUserVO authenticatedUser(LoginParam loginParam) {
        if (loginParam == null) {
            return null;
        }
        return this.authenticatedUser(loginParam.getUserName(), loginParam.getPassword());
    }

    @Override
    public boolean resetPassword(ResetPwdParam resetPwdParam) {
        Assert.isTrue(resetPwdParam != null, "修改密码， 参数对象不能为null");
        Assert.isTrue(!StringUtils.isEmpty(resetPwdParam.getNewPassword()), "新密码不能为空");
        Assert.isTrue(!StringUtils.isEmpty(resetPwdParam.getConfirmedPassword()), "确认密码不能为空");
        // compare newpwd, confirmed password.
        if (StringUtil.equals(resetPwdParam.getNewPassword(), resetPwdParam.getConfirmedPassword())) {
            throw new RuntimeException("新密码和确认密码不匹配.");
        }

        // find old one.
        User user = this.userService.getById(resetPwdParam.getUserId());
        if (user == null) {
            return false;
        }
        String encryptPwd = MD5StringUtil.MD5Encode(resetPwdParam.getOldPassword());
        if (!StringUtil.equals(user.getPwd(), encryptPwd)) {
            return false;
        }
        // change password and save.
        user.setPwd(encryptPwd);
        this.userService.saveOrUpdate(user);
        return true;
    }

    @Autowired
    private UserService userService;
}
