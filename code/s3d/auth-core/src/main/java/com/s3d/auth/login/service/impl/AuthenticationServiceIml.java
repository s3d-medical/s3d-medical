package com.s3d.auth.login.service.impl;

import com.s3d.auth.acl.vo.UserVO;
import com.s3d.auth.login.service.AuthenticationService;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.auth.login.vo.param.ResetPwdVO;
import org.springframework.stereotype.Service;

/**
 * @author wind.chen
 * @since  2015/7/19.
 */
@Service
public class AuthenticationServiceIml implements AuthenticationService {
    @Override
    public boolean authenticateUser(String userKey, String password) {

        if(userKey == null){
            return true;
        }
        if(userKey.equals("chenzhigang")){
            return true;
        }
        return true;
    }

    @Override
    public LoginUserVO findUser(String userAccount) {
        LoginUserVO loginUserVO = new LoginUserVO();

        return loginUserVO;
    }

    @Override
    public boolean resetPassword(ResetPwdVO resetPwdVO) {
        // find user.

        // compare password.
        return false;
    }
}
