package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.entity.Org;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.tech.slicer.PageParam;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:46
 */
@Repository
public class OrgDaoImpl extends HibernateDao<Org, Integer> implements OrgDao {
    @Override
    public Org getOrgByCode(String code) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Org where code = :code");
        Query query = this.getSession().createQuery(hql.toString());
        query.setString("code", code);
        List<Org> orgList = query.list();
        if(orgList != null && orgList.size() >0){
            return orgList.get(0);
        }
        return null;
    }

    @Override
    public List<Org> getAllOrgs() {
        StringBuilder hql = new StringBuilder();
        hql.append("from Org t where t.parent = null");
        Query query = this.getSession().createQuery(hql.toString());
        return query.list();
    }

    @Override
    public List<Org> getDirectChildren(Integer orgId, PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Org t where t.parent.id = :parentId ");
        Query query = this.getSession().createQuery(hql.toString());
        query.setInteger("parentId", orgId);
        query.setFirstResult(pageParam.getStartNo());
        query.setMaxResults(pageParam.getPageSize());
        return query.list();
    }

    @Override
    public Long getDirectChildrenCount(Integer orgId, PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("select count(t.id) as totalCount from Org t where t.parent.id = :parentId ");
        Query query = this.getSession().createQuery(hql.toString());
        query.setInteger("parentId", orgId);
        return (Long)query.uniqueResult();
    }

    @Override
    public Org getDepartmentById(Integer departmentId) {
        return get(departmentId);
    }
}
