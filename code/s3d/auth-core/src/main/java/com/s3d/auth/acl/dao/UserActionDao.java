package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.UserAction;

import java.util.List;

/**
 * Created by Gary.Feng on 2016/1/14.
 */
public interface UserActionDao {

    List<UserAction> getUserActions(Integer userId);

}
