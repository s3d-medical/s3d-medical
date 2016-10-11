package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.vo.ActionBasicVO;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.service
 * @date 2015/11/1 17:53
 */
public interface ActionService {

    public void saveOrUpdate(ActionBasicVO actionBasicVO);

    public List<Action> getActByIds(List<Integer> actionIds);

    Map getActionVO(Integer actionId);

}
