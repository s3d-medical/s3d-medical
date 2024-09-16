package com.s3d.webapps.record.dto;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.webapps.record.dto
 * @date 2016/2/10 12:06
 */
public class QRecordParam implements Serializable {
    private Integer userId;
    private String userInput;
    private Integer queryCate;

    public QRecordParam(Integer userId, String userInput, Integer queryCate) {
        this.userId = userId;
        this.userInput = userInput;
        this.queryCate = queryCate;
    }

    public QRecordParam() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public Integer getQueryCate() {
        return queryCate;
    }

    public void setQueryCate(Integer queryCate) {
        this.queryCate = queryCate;
    }
}
