package com.s3d.auth.acl.dao;

import com.s3d.auth.acl.entity.Org;
import com.s3d.tech.data.dao.GenericDao;
import com.s3d.tech.slicer.PageParam;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao
 * @date 2015/11/1 14:19
 */
public interface OrgDao extends GenericDao<Org,Integer> {

    public Org getOrgByCode(String code);

    public List<Org> getAllOrgs();

    public List<Org> getDirectChildren(Integer orgId, PageParam pageParam);

    public Long getDirectChildrenCount(Integer orgId, PageParam pageParam);

}
