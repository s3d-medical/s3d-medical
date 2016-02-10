package com.s3d.auth.login.vo.param;

import java.io.Serializable;

/**
 * @author wind.chen
 * @desc com.s3d.auth.login.vo
 * @date 2015/11/22 20:26
 */
public class ResetPwdParam implements Serializable {

    private static final long serialVersionUID = 206560331098451772L;

    private Integer userId;
    /**
     * old password
     */
    private String oldPassword;

    private String newPassword;

    private String confirmedPassword;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

}
