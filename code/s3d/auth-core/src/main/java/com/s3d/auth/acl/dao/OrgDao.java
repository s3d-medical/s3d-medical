package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Org;
import com.s3d.tech.data.dao.GenericDao;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao
 * @date 2015/11/1 14:19
 */
public interface OrgDao extends GenericDao<Org,Integer> {
    public Org getOrgByCode(String code);

}
