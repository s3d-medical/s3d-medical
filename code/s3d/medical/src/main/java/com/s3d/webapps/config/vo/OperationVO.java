package com.s3d.webapps.config.vo;

/**
 * Created by Gary.Feng on 2015/7/22.
 */
public class OperationVO {

    private String id;
    private String name;
    private String shortcut;
    private Integer grade;

    public OperationVO(String id, String name, String shortcut, Integer grade) {
        this.id = id;
        this.name = name;
        this.shortcut = shortcut;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
