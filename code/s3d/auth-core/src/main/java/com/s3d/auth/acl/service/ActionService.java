package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.vo.ActionVO;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.service
 * @date 2015/11/1 17:53
 */
public interface ActionService {

    public void saveOrUpdate(ActionVO actionVO);

    public List<Action> getActionsByIds(List<Integer> actionIds);

}
