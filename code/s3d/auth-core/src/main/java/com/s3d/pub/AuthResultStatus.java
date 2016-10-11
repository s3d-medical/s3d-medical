package com.s3d.pub;

/**
 * @author wind.chen
 * @date 2015/5/18.
 */
public enum AuthResultStatus {
    SUCCEED("succeed"), FAIL("failure");

    AuthResultStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    private String value;

}
