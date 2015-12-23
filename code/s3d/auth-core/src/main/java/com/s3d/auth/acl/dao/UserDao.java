package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.User;
import com.s3d.tech.data.dao.GenericDao;
import com.s3d.tech.slicer.PageParam;

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
     * @param orgId
     * @param fullName
     * @return
     */
    public List<User> getUsers(Integer orgId, String fullName);

    /**
     * get users in this given org.
     * @param orgId
     * @param pageParam
     * @return
     */
    public List<User> getUsers(Integer orgId, PageParam pageParam);

    public List<User> getUsersByIds(List<Integer> userIds);

    /**
     * find user count in given org.
     * @param orgId
     * @return
     */
    public Long getUserCountInOrg(Integer orgId);

    public void deleteUsers(List<Integer> ids);

}
