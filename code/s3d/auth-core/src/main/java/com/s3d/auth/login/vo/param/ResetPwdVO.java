package com.s3d.auth.login.vo.param;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.vo
 * @date 2015/11/22 20:26
 */
public class ResetPwdVO implements Serializable {

    private static final long serialVersionUID = 206560331098451772L;

    private Integer userId;

    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
