package com.s3d.auth.acl.vo.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/1 18:51
 */
public class QueryActionParam implements Serializable {
    private static final long serialVersionUID = -221188226440741729L;
    private List<Integer> actionIds = new ArrayList<Integer>();

    public List<Integer> getActionIds() {
        return actionIds;
    }

    public void setActionIds(List<Integer> actionIds) {
        this.actionIds = actionIds;
    }
}
