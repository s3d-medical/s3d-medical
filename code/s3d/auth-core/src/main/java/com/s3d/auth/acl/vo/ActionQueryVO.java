package com.s3d.auth.acl.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/1 18:51
 */
public class ActionQueryVO {
    private List<Integer> actionIds = new ArrayList<Integer>();

    public List<Integer> getActionIds() {
        return actionIds;
    }

    public void setActionIds(List<Integer> actionIds) {
        this.actionIds = actionIds;
    }
}
