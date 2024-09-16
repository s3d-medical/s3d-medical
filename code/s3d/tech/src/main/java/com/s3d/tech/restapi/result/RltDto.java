package com.s3d.tech.restapi.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * rest api result.
 * @author wind.chen
 * @since 2016/9/20.
 */
public class RltDto<T> implements Serializable{
    public static String DEFAULT_FAIL_CODE="fail";
    public static String DEFAULT_SUCCEED_CODE="succeed";
    /**
     * 处理结果码
     */
    private String code;

    /**
     * 相关提示
     */
    private String desc;

    private T objVal;

    public RltDto() {

    }

    public RltDto(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public RltDto(String code, String desc, T objVal) {
        this.code = code;
        this.desc = desc;
        this.objVal = objVal;
    }

    public Map convertToMap(){
        Map map = new HashMap();
        map.put("code", this.code);
        map.put("desc", this.desc);
        map.put("objVal", this.objVal);
        return map;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getObjVal() {
        return objVal;
    }

    public void setObjVal(T objVal) {
        this.objVal = objVal;
    }

    public void fail(){
        this.setCode(DEFAULT_FAIL_CODE);
    }

    public void fail(String desc){
        this.setCode(DEFAULT_FAIL_CODE);
        this.setDesc(desc);
    }

    public void fail(String code, String desc){
        this.setCode(code);
        this.setDesc(desc);
    }

    public void succeed(){
        this.setCode(DEFAULT_SUCCEED_CODE);
    }

    public void succeed(T objVal){
        this.setCode(DEFAULT_SUCCEED_CODE);
        this.setObjVal(objVal);
        this.setDesc("");
    }

    public void succeed(String code, String desc, T objVal){
        this.setCode(DEFAULT_SUCCEED_CODE);
        this.setObjVal(objVal);
        this.setDesc(desc);
    }

}
