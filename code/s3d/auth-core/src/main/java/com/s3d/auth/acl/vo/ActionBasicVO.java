package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.Action;
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
public class ActionBasicVO implements Serializable{
    private static final long serialVersionUID = -6858457890951321431L;
    private Integer id;
    private String actionName;
    private String moduleNo;
    private String pageNo;
    private Integer state;

    public ActionBasicVO() {

    }

    public ActionBasicVO(Action action){
        this.id = action.getId();
        this.actionName = action.getActionName();
        this.moduleNo = action.getModule().getName();
        this.pageNo = action.getPageNo();
        this.state = action.getState();
    }

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

    public String getModuleNo() {
        return moduleNo;
    }

    public void setModuleNo(String moduleNo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActionBasicVO)) return false;

        ActionBasicVO that = (ActionBasicVO) o;

        if (actionName != null ? !actionName.equals(that.actionName) : that.actionName != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (moduleNo != null ? !moduleNo.equals(that.moduleNo) : that.moduleNo != null) return false;
        if (pageNo != null ? !pageNo.equals(that.pageNo) : that.pageNo != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (actionName != null ? actionName.hashCode() : 0);
        result = 31 * result + (moduleNo != null ? moduleNo.hashCode() : 0);
        result = 31 * result + (pageNo != null ? pageNo.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
