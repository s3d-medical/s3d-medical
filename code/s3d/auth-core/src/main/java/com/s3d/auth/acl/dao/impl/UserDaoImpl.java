package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.User;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.tech.slicer.PageParam;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:47
 */
@Repository
public class UserDaoImpl extends HibernateDao<User, Integer> implements UserDao {

    @Override
    public User getByEmail(String email) {
        List<User> users = this.getAllUsers(null, null, email, null);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByCode(String code) {
        List<User> users = this.getAllUsers(null, code, null, null);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByLoginName(String loginName) {
        List<User> users = this.getAllUsers(loginName, null, null, null);
        if(users != null && users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User getByLoginNamePwd(String loginName, String pwd) {
        List<User> users = this.getAllUsers(loginName, pwd, null, null);
        if(users != null && users.size() > 0){
           return users.get(0);
        }
        return null;
    }

    /**
     *
     * @param loginName
     * @param pwd
     * @param code
     * @param email
     * @return
     */
    private List<User> getAllUsers(String loginName, String pwd,  String code, String email){
       return this.getUsers(loginName, pwd, code, email, null);
    }

    /**
     *
     * @param loginName
     * @param pwd
     * @param code
     * @param email
     * @param states
     * @return
     */
    private List<User> getUsers(String loginName, String pwd,  String code, String email, List<Integer> states){
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
        if(!StringUtils.isEmpty(pwd)){
            hql.append(" and u.pwd = :pwd");
            param.put("pwd", pwd);
        }
        if(states != null && states.size() > 0){
            hql.append(" and u.state in ( :states)");
            param.put("states", states);
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
            hql.append(" and u.fullName like :fullName");
            param.put("fullName", "%" + fullName + "%");
        }
        if(orgId != null){
            hql.append(" and u.org.id = :orgId");
            param.put("orgId", orgId);
        }
        hql.append(" and u.state != 2");
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
        hql.append(" and u.state != 2");
        param.put("orgId", orgId);

        Query query = this.createQuery(hql.toString(), param);
        Long count = (Long)query.uniqueResult();
        return count;
    }

    @Override
    public void deleteUsers(List<Integer> ids) {
        StringBuilder hql = new StringBuilder();
        Map param = new HashMap();
        hql.append("update User set state = 2 where id in (:ids)");
        param.put("ids", ids);
        Query query = this.createQuery(hql.toString(), param);
        query.executeUpdate();
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
        hql.append(" and u.state != 2");
        param.put("orgId", orgId);

        Query query = this.createQuery(hql.toString(), param);
        query.setFirstResult(pageParam.getStartNo());
        query.setMaxResults(pageParam.getPageSize());
        List<User> userList = query.list();
        return userList;
    }

    @Override
    public List<User> getUsersByIds(List<Integer> userIds) {
        if(CollectionUtils.isEmpty(userIds)){
            return null;
        }
       return this.getByIds(userIds);
    }

}
