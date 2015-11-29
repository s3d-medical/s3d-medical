package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.User;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.tech.slicer.PageParam;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:47
 */
@Repository
public class UserDaoImpl extends HibernateDao<User, Integer> implements UserDao {

    @Override
    public User getByEmail(String email) {
        List<User> users = this.getUsers(null, null, email);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByCode(String code) {
        List<User> users = this.getUsers(null, code, null);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByLoginName(String loginName) {
        List<User> users = this.getUsers(loginName, null, null);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }


    private List<User> getUsers(String loginName, String code, String email){
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("from User as u where 1=1 ");
        if(!StringUtils.isEmpty(loginName)){
            hql.append(" and u.loginName = :loginName");
            param.put("loginName", loginName);
        }
        if(!StringUtils.isEmpty(code)){
            hql.append(" and u.code = :code");
            param.put("code", code);
        }
        if(!StringUtils.isEmpty(email)){
            hql.append(" and u.email = :email");
            param.put("email", email);
        }
        Query query = this.createQuery(hql.toString(), param);
        List<User> userList = query.list();
        return userList;
    }

    @Override
    public List<User> getUsers( Integer orgId, String fullName) {
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("from User as u where 1=1 ");
        if(!StringUtils.isEmpty(fullName)){
            hql.append(" and u.fullName = :fullName");
            param.put("fullName", fullName);
        }
        if(orgId != null){
            hql.append(" and u.org.id = :orgId");
            param.put("orgId", orgId);
        }
        Query query = this.createQuery(hql.toString(), param);
        List<User> userList = query.list();
        return userList;
    }

    @Override
    public Long getUserCountInOrg(Integer orgId) {
        if (orgId == null) {
            return null;
        }
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("select count(u.id) from User as u where 1=1 ");
        hql.append(" and u.org.id = :orgId");
        param.put("orgId", orgId);

        Query query = this.createQuery(hql.toString(), param);
        Long count = (Long)query.uniqueResult();
        return count;
    }

    @Override
    public List<User> getUsers(Integer orgId, PageParam pageParam) {
        if (orgId == null) {
            return null;
        }
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("from User as u where 1=1 ");
        hql.append(" and u.org.id = :orgId");
        param.put("orgId", orgId);

        Query query = this.createQuery(hql.toString(), param);
        query.setFirstResult(pageParam.getStartNo());
        query.setMaxResults(pageParam.getPageSize());
        List<User> userList = query.list();
        return userList;
    }

}
