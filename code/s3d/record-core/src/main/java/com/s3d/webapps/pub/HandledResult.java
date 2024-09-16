package com.s3d.webapps.pub;

/**
 * @author wind.chen
 * @date 2015/5/18.
 */
public class HandledResult {
    private HandledResultCode code;
    private String error;
    private Object data;

    public HandledResult(HandledResultCode code, String error, Object data) {
        this.code = code;
        this.error = error;
        this.data = data;
    }

    public HandledResultCode getCode() {
        return code;
    }

    public void setCode(HandledResultCode code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
