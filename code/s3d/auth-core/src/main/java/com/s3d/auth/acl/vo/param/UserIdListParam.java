package com.s3d.auth.acl.vo.param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/22 18:07
 */
public class UserIdListParam {
    private List<Integer> userIds = new ArrayList<Integer>();

    public List<Integer> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
    }
}
