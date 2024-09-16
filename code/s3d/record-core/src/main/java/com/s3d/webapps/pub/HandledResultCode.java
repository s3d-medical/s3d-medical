package com.s3d.webapps.pub;

/**
 * @author wind.chen
 * @date 2015/5/18.
 */
public enum HandledResultCode {
    SUCCESS("success"), FAIL("fail");

    HandledResultCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    private String value;

}
