package com.s3d.webapps.pub.datatype;

/**
 * Created by Administrator on 2015/5/9.
 */
public enum SexType {
    MALE("male"), FEMALE("female"), UNKNOWN("unknown");
    SexType(String value) {
        this.value = value;
    }
    private String value="";
    public SexType parse(String givenValue){
        if(MALE.value.equals(givenValue)){
            return MALE;
        }else if(FEMALE.equals(givenValue)){
            return FEMALE;
        }
        return UNKNOWN;
    }
}
