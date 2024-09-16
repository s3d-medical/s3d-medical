package com.s3d.pub;

/**
 * @author Administrator
 * @desc com.s3d.pub
 * @date 2015/11/7 15:37
 */
public class AuthResultErrorMsg {
    private String code;
    private String message;

    public AuthResultErrorMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
