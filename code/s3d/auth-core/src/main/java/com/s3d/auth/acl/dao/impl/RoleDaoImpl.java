package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Role;
import com.s3d.tech.data.dao.hibernate.CommonDao;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.tech.slicer.PageParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:47
 */
@Repository
public class RoleDaoImpl extends HibernateDao<Role, Integer> implements RoleDao {

    @Override
    public Long getRolesCount(PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("select count(r.id) as totalCount from Role r where r.state != 2");
        Query query = this.createQuery(hql.toString());
        return (Long)query.uniqueResult();
    }

    @Override
    public List<Role> getRoles(PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Role where state != 2");
        Query query = this.createQuery(hql.toString());
        query.setFirstResult(pageParam.getStartNo());
        query.setMaxResults(pageParam.getPageSize());
        return (List<Role>)query.list();
    }

    @Override
    public void deleteRoles(List<Integer> ids) {
        StringBuilder hql = new StringBuilder();
        Map params = new HashMap();
        hql.append("update Role set state = 2 where id in (:ids)");
        params.put("ids", ids);
        Query query = this.createQuery(hql.toString(), params);
        query.executeUpdate();
    }
}
