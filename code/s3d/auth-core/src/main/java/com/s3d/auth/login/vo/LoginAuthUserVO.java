package com.s3d.auth.login.vo;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.vo.ActionBasicVO;
import com.s3d.auth.acl.vo.RoleBasicVO;
import com.s3d.auth.acl.vo.UserBasicVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * login user.
 * @author wind.chen
 * @since 2015/7/19.
 */
public class LoginAuthUserVO extends UserBasicVO implements Serializable {
    /**
     * user's role list.
     */
    private List<RoleBasicVO> uniqueRoles;

    /**
     * user's action list.
     */
    private List<ActionBasicVO> uniqueActions ;

    public LoginAuthUserVO() {
    }

    public LoginAuthUserVO(User user) {
        this.init(user);
    }

    private void init(User user){
        if(user == null) {
            return ;
        }
        this.setId(user.getId());
        this.setRemark(user.getRemark());
        this.setEmail(user.getEmail());
        this.setUserName(user.getLoginName());
        this.setRealName(user.getFullName());

        this.fillRoles(user);
        this.fillActions(user);
    }

    private void fillRoles(User user){
        this.uniqueRoles = new ArrayList<RoleBasicVO>();
        if(user != null && user.getRoles() != null){
            for(Role role : user.getRoles()){
                RoleBasicVO roleBasicVO = new RoleBasicVO(role);
                this.uniqueRoles.add(roleBasicVO);
            }
        }
    }
    private void fillActions(User user){
        this.uniqueActions = new ArrayList<ActionBasicVO>();
        if(user != null && user.getActions() != null){
            for(Action action : user.getActions()){
                ActionBasicVO actionBasicVO = new ActionBasicVO(action);
                if(!this.uniqueActions.contains(actionBasicVO)) {
                    this.uniqueActions.add(actionBasicVO);
                }
            }
        }
    }

    public List<RoleBasicVO> getUniqueRoles() {
        return uniqueRoles;
    }

    public List<ActionBasicVO> getUniqueActions() {
        return uniqueActions;
    }
}
