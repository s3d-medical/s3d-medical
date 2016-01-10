package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.Role;
import com.s3d.tech.utils.StringUtil;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/1 18:51
 */
public class ActionVO implements Serializable{
    private static final long serialVersionUID = -6858457890951321431L;
    private Integer id;
    private String actionName;
    private Integer moduleNo;
    private String pageNo;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(Integer moduleNo) {
        this.moduleNo = moduleNo;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
