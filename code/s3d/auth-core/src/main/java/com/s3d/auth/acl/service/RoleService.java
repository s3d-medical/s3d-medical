package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.vo.param.IdListParam;
import com.s3d.auth.acl.vo.RoleBasicVO;
import com.s3d.auth.acl.vo.PageRoleVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.service
 * @date 2015/11/1 17:53
 */
public interface RoleService {
    void saveOrUpdate(RoleBasicVO roleBasicVO, List<Integer> actionIds, List<Integer> userIds);

    PageResult<PageRoleVO> getInPage(PageParam pageParam);

    void delete(IdListParam idListParam);

    /**
     * check the role name is unique or not.
     * @param roleName
     * @param roleId
     */
    boolean isDuplicatedRole(String roleName, String roleId);

    Role getById(Integer roleId);
}
