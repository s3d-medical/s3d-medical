package com.s3d.auth.service;

import com.s3d.auth.vo.RegisteredUserVO;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public interface AuthenticationService {
    boolean authenticateUser(String userAccount, String password);
    RegisteredUserVO findUser(String userAccount);
}
