package com.s3d.auth.acl.vo.param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.vo
 * @date 2015/11/22 18:07
 */
public class IdListParam {
    private List<Integer> ids = new ArrayList<Integer>();

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
