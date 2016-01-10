package com.s3d.auth.login.vo;

import com.s3d.auth.acl.vo.RoleVO;
import com.s3d.auth.acl.vo.UserVO;

import java.io.Serializable;
import java.util.List;

/**
 * login user.
 * @author wind.chen
 * @since 2015/7/19.
 */
public class LoginUserVO implements Serializable {
    private String expiredDateTime;
    private String createDateTime;
    private UserVO userVO;
    private List<RoleVO> roleVOs;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<RoleVO> getRoleVOs() {
        return roleVOs;
    }

    public void setRoleVOs(List<RoleVO> roleVOs) {
        this.roleVOs = roleVOs;
    }

    public String getExpiredDateTime() {
        return expiredDateTime;
    }

    public void setExpiredDateTime(String expiredDateTime) {
        this.expiredDateTime = expiredDateTime;
    }

    public Integer getUserId(){
        if(this.userVO == null){
            return null;
        }
        return this.userVO.getId();
    }
}
