package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.ActionDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:46
 */
@Repository
public class ActionDaoImpl extends HibernateDao<Action, Integer> implements ActionDao {

    @Override
    public List<Action> getActByIds(List<Integer> actionIds) {
        if(actionIds == null || actionIds.size() ==0){
            return null;
        }
        return this.getByIds(actionIds);
    }
}
