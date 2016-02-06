package com.s3d.auth.acl.vo;

import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.User;

import java.util.*;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2016/2/5 15:40
 */
public class UserVO {

    /**
     * user basic info
     */
    private UserBasicVO userInfo;

    /**
     * user's role list.
     */
    private List<RoleBasicVO> uniqueRoles;

    /**
     * user's action list.
     */
    private List<ActionBasicVO> uniqueActions ;

    public UserVO(User user) {
       this.fill(user);
    }
    private void fill(User user){
        if(user == null) {
            return ;
        }
        this.uniqueRoles = new ArrayList<RoleBasicVO>();
        this.uniqueActions = new ArrayList<ActionBasicVO>();
        this.userInfo = new UserBasicVO(user);
        if(user.getRoles() != null){
            for(Role role : user.getRoles()){


            }
        }
    }
    public UserBasicVO getUserInfo() {
        return userInfo;
    }

}
