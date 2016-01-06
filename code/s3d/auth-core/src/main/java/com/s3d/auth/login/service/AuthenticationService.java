package com.s3d.auth.login.service;

import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.LoginUserVO;
import com.s3d.auth.login.vo.param.ResetPwdParam;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public interface AuthenticationService {
    /**
     * authenticate user.
     * @param userAccount       user
     * @param password
     * @return
     */
    boolean authenticateUser(String userAccount, String password);

    LoginUserVO authenticatedUser(LoginParam loginParam);

    /**
     * get user info by user account.
     * @param userAccount
     * @return
     */
    LoginUserVO findUser(String userAccount);

    /**
     * reset password.
     * @param resetPwdParam
     * @return
     */
    boolean resetPassword(ResetPwdParam resetPwdParam);

}
