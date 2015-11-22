package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.User;
import com.s3d.tech.data.dao.GenericDao;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao
 * @date 2015/11/1 17:45
 */
public interface UserDao extends GenericDao<User, Integer> {

    User getByEmail(String email);

    User getByCode(String code);

    User getByLoginName(String loginName);

    /**
     * query user by user full name and org id.
     * @param fullName
     * @param orgId
     * @return
     */
    public List<User> getUsers(String fullName, Integer orgId);
}
