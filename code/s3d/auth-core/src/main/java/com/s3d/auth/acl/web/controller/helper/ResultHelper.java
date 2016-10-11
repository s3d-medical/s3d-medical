package com.s3d.auth.acl.web.controller.helper;

import com.s3d.pub.AuthResultErrorMsg;
import com.s3d.pub.AuthResultStatus;
import org.springframework.ui.Model;

/**
 * @author wind.chen
 * @date 2015/5/18.
 */
public class ResultHelper {
    private AuthResultStatus code;
    private AuthResultErrorMsg error;

    public static void createSuccessResult(Model model){
        model.addAttribute("status", AuthResultStatus.SUCCEED.value());
    }

    public static void createFailResult(Model model, String errorCode, String errorMsg){
        model.addAttribute("status", AuthResultStatus.FAIL.value());
        AuthResultErrorMsg resultErrorMsg = new AuthResultErrorMsg(errorCode, errorMsg);
        model.addAttribute("error", resultErrorMsg);
    }

    public AuthResultStatus getCode() {
        return code;
    }

    public void setCode(AuthResultStatus code) {
        this.code = code;
    }

    public AuthResultErrorMsg getError() {
        return error;
    }

    public void setError(AuthResultErrorMsg error) {
        this.error = error;
    }
}
