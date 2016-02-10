package com.s3d.auth.login.service;

import com.s3d.auth.login.vo.LoginAuthUserVO;
import com.s3d.auth.login.vo.param.LoginParam;
import com.s3d.auth.login.vo.param.ResetPwdParam;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public interface AuthenticationService {

    /**
     * authenticate user.
     */
    LoginAuthUserVO authenticatedUser(LoginParam loginParam);

    /**
     * reset password.
     * @param resetPwdParam
     * @return
     */
    boolean resetPassword(ResetPwdParam resetPwdParam);

}
