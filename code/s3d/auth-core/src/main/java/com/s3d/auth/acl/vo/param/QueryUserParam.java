package com.s3d.auth.acl.vo.param;

import java.io.Serializable;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/22 19:15
 */
public class QueryUserParam implements Serializable{
    private String realName;
    private Integer departmentId;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
