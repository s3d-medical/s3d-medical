package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.UserActionDao;
import com.s3d.auth.acl.entity.UserAction;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2016/1/14.
 */
@Repository
public class UserActionDaoImpl extends HibernateDao<UserAction, Integer> implements UserActionDao {
    @Override
    public List<UserAction> getUserActions(Integer userId) {
        StringBuilder hql = new StringBuilder();
        hql.append("from UserAction where id = :id");
        Map params = new HashMap();
        params.put("id", userId);
        Query query = this.createQuery(hql.toString(), params);
        return (List<UserAction>)query.list();
    }
}
