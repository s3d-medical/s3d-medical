package com.s3d.auth.service.impl;

import com.s3d.auth.service.AuthenticationService;
import com.s3d.auth.vo.RegisteredUserVO;
import com.s3d.auth.vo.UserBasicInfoVO;
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
            return false;
        }
        if(userKey.equals("chenzhigang")){
            return true;
        }
        return false;
    }

    @Override
    public RegisteredUserVO findUser(String userAccount) {
        RegisteredUserVO registeredUserVO = new RegisteredUserVO();
        UserBasicInfoVO basicInfoVO = new UserBasicInfoVO();
        basicInfoVO.setUserId(1);
        basicInfoVO.setEmail("chenzhigang9848@sohu.com");
        registeredUserVO.setUserBasicInfoVO(basicInfoVO);
        return registeredUserVO;
    }
}
