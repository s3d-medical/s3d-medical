package com.s3d.auth.mongo.entity;

import java.io.Serializable;

/**
 * Created by Wind.Chen on 2015/6/30.
 */
public class Author implements Serializable {
    private String name;
    private String address;
    private String sex;


    public Author(String name, String address, String sex) {
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
