package com.s3d.auth.acl.vo.result;

import com.s3d.auth.acl.vo.result.ActionVO;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class RoleVO implements Serializable{
    private static final long serialVersionUID = -3361683703204634757L;
    private String id;

    private String name;

    private String desc;

    private Integer state;

    private List<ActionVO> actions;

    public RoleVO() {

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<ActionVO> getActions() {
        return actions;
    }

    public void setActions(List<ActionVO> actions) {
        this.actions = actions;
    }
}