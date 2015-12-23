package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.RoleDao;
import com.s3d.auth.acl.entity.Role;
import com.s3d.auth.acl.vo.param.QueryRoleParam;
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
    public Role getRoleByName(String roleName) {
        QueryRoleParam queryRole = new QueryRoleParam();
        queryRole.setName(roleName);
        List<Role> roles = this.getRolesBySimple(queryRole, null);
        if(roles != null && roles.size() >0){
            return roles.get(0);
        }
        return null;
    }

    private List<Role> getRolesBySimple(QueryRoleParam queryRole, PageParam pageParam){
        // build sql and related params.
        StringBuilder hql = new StringBuilder();
        hql.append("from Role as role where 1=1 ");
        Map paramMap = new HashMap();
        if(queryRole != null){
            if(queryRole.getId() != null){
                hql.append(" role.id = :id");
                paramMap.put("id",queryRole.getId() );
            }
            if(queryRole.getCategoryId() != null){
                hql.append("role.categoryId =:categoryId");
                paramMap.put("categoryId", queryRole.getCategoryId());
            }
            if(queryRole.getName() != null){
                hql.append("role.name = :name");
                paramMap.put("name", queryRole.getName());
            }
        }
        // create query.
        Query query = this.createQuery(hql.toString(), paramMap);
        // build separated page
        if(pageParam != null){
            query.setFirstResult(pageParam.getStartNo());
            query.setMaxResults(pageParam.getPageSize());
        }
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
