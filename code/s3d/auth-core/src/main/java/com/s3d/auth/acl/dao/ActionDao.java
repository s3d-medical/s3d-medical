package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.Action;
import com.s3d.tech.data.dao.GenericDao;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao
 * @date 2015/11/1 14:19
 */
public interface ActionDao extends GenericDao<Action,Integer> {

    List<Action> getActByIds(List<Integer> actionIds);

}
