package com.s3d.webapps.pub.datatype;

/**
 * Created by Administrator on 2015/5/9.
 */
public enum  MatrialStatus {
    UNMARRIED("unmarried"), MARRIED("married"), WIDOWED("widowed"),DIVORCE("divorce"),;

    MatrialStatus(String value) {
        this.value = value;
    }
    private String value="";

}
