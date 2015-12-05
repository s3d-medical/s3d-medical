package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.Role;
import com.s3d.tech.data.dao.GenericDao;
import com.s3d.tech.slicer.PageParam;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao
 * @date 2015/11/1 14:19
 */
public interface RoleDao extends GenericDao<Role,Integer> {

    Long getRolesCount(PageParam pageParam);

    List<Role> getRoles(PageParam pageParam);

}
