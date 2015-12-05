package com.s3d.auth.acl.service;

import com.s3d.auth.acl.vo.result.PageRoleVO;
import com.s3d.auth.acl.vo.result.RoleVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;

/**
 * @author Administrator
 * @desc com.s3d.auth.login.service
 * @date 2015/11/1 17:53
 */
public interface RoleService {
    public void saveOrUpdate(RoleVO roleVO);

    PageResult<PageRoleVO> getRoles(PageParam pageParam);
}
