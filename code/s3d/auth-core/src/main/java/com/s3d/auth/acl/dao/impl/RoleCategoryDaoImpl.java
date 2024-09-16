package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.RoleCategoryDao;
import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.entity.RoleCategory;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.tech.slicer.PageParam;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:47
 */
@Repository
public class RoleCategoryDaoImpl extends HibernateDao<RoleCategory, Integer> implements RoleCategoryDao {

}
