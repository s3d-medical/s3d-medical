package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.User;
import com.s3d.auth.acl.vo.QueryUserVO;
import com.s3d.auth.acl.vo.UserVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.service
 * @date 2015/11/1 17:54
 */
public interface UserService {
    public void saveOrUpdate(UserVO userVO);

    /**
     * get by id.
     * @param id
     * @return
     */
    public User getById(Integer id);

    /**
     * query user by user full name and org id.
     * @return
     */
    public List<User> getUsers(QueryUserVO queryUserVO);

    public PageResult<User> getUsers(Integer orgId, PageParam pageParam);

    /**
     * check an email has been used. if yes , check if the userId == id of the found user.
     * @param userId     current id of compared user.
     * @param email      compared email
     * @return
     */
    public boolean existSameEmail(Integer userId, String email);

    public boolean existSameCode(Integer userId, String code);

    public boolean existSameUserName(Integer userId, String userName);

    public void delete(Integer id);

    public void delete(List<Integer> ids);

}
