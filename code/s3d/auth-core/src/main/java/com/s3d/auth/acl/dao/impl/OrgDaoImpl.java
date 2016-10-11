package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.entity.Org;
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
 * @date 2015/11/1 17:46
 */
@Repository
public class OrgDaoImpl extends HibernateDao<Org, Integer> implements OrgDao {
    @Override
    public Org getOrgByCode(String code) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Org where code = :code and status != 2");
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
        hql.append("from Org t where t.parent = null and status != 2");
        Query query = this.getSession().createQuery(hql.toString());
        return query.list();
    }

    @Override
    public List<Org> getDirectChildren(Integer orgId, PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("from Org t where t.parent.id = :parentId and status != 2 order by pos asc");
        Query query = this.getSession().createQuery(hql.toString());
        query.setInteger("parentId", orgId);
        query.setFirstResult(pageParam.getStartNo());
        query.setMaxResults(pageParam.getPageSize());
        return query.list();
    }

    @Override
    public Long getDirectChildrenCount(Integer orgId, PageParam pageParam) {
        StringBuilder hql = new StringBuilder();
        hql.append("select count(t.id) as totalCount from Org t where t.parent.id = :parentId and status != 2");
        Query query = this.getSession().createQuery(hql.toString());
        query.setInteger("parentId", orgId);
        return (Long)query.uniqueResult();
    }

    @Override
    public Org getDepartmentById(Integer departmentId) {
        return get(departmentId);
    }

    @Override
    public void deleteOrgs(List<Integer> ids) {
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("update Org set status = 2 where id in(:ids)");
        param.put("ids", ids);
        Query query = this.createQuery(hql.toString(), param);
        query.executeUpdate();
    }
}
