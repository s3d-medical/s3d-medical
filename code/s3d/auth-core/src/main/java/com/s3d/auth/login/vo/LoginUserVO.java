package com.s3d.auth.login.vo;

import com.s3d.auth.acl.vo.RoleVO;
import com.s3d.auth.acl.vo.UserBasicInfoVO;

import java.io.Serializable;
import java.util.List;

/**
 * @author wind.chen
 * @since 2015/7/19.
 */
public class LoginUserVO implements Serializable {
    private String expiredDateTime;
    private String createDateTime;
    private UserBasicInfoVO userBasicInfoVO;
    private List<RoleVO> roleVOs;

    public UserBasicInfoVO getUserBasicInfoVO() {
        return userBasicInfoVO;
    }

    public void setUserBasicInfoVO(UserBasicInfoVO userBasicInfoVO) {
        this.userBasicInfoVO = userBasicInfoVO;
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
}
