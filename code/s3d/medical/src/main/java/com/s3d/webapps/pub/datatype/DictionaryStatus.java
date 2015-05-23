package com.s3d.webapps.pub.datatype;

/**
 * @author wind.chen
 * @date 2015/4/23.
 */
public enum DictionaryStatus {
    INVALID("invalid"), VALID("valid");

    DictionaryStatus(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    private String value;
}
