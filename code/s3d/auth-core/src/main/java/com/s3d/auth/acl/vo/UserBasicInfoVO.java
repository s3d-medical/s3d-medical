package com.s3d.auth.acl.vo;

import java.io.Serializable;

/**
 * @author  wind.chen
 * @since 2015/7/19.
 */
public class UserBasicInfoVO implements Serializable {
    private static final long serialVersionUID = 6578526809587873686L;
    private Integer userId;
    private String name;
    private String sex;
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}