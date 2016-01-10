package com.s3d.auth.login.service.impl;

import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.auth.login.vo.param.ResetPwdParam;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author wind.chen
 * @since  2015/7/19.
 */
@Service
public class AuthenticationServiceIml implements AuthenticationService {
    @Override
    public boolean authenticateUser(String userKey, String password) {
        if(StringUtils.isEmpty(userKey) || StringUtils.isEmpty(password)){
            return false;
        }
        if(userKey == null){
            return true;
        }
        if(userKey.equals("chenzhigang")){
            return true;
        }
        return true;
    }

    @Override
    public LoginUserVO authenticatedUser(LoginParam loginParam) {
        // check logic
        if (loginParam == null) {
            return null;
        }
        // authenticate it.
        boolean ifSuccess = this.authenticateUser(loginParam.getUserName(), loginParam.getPassword());
        if (!ifSuccess) {
            return null;
        }
        return null;
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
}
