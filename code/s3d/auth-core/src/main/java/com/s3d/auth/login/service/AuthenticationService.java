package com.s3d.auth.login.service;

import com.s3d.auth.login.vo.LoginUserVO;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public interface AuthenticationService {
    boolean authenticateUser(String userAccount, String password);
    LoginUserVO findUser(String userAccount);
}
