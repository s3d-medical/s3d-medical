package com.s3d.webapps.access.config.vo;

/**
 * Created by Gary.Feng on 2015/7/22.
 */
public class OperationVO {

    private String code;
    private String name;
    private String shortcut;
    private Integer grade;

    public OperationVO() {

    }

    public OperationVO(String code, String name, String shortcut, Integer grade) {
        this.code = code;
        this.name = name;
        this.shortcut = shortcut;
        this.grade = grade;
    }

    public OperationVO(String code, String name, Integer grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
