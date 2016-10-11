package com.s3d.webapps.da.config.dao.impl;

import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.webapps.access.config.persistence.ConfigOperation;
import com.s3d.webapps.da.config.dao.IDaConfigOperationDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2015/7/21.
 */
@Repository
public class DaConfigOperationDaoImp extends HibernateDao<ConfigOperation, Integer> implements IDaConfigOperationDao {
    @Override
    public List<ConfigOperation> getOperations(String hospitalId, Integer status) {
        StringBuilder hql = new StringBuilder();
        hql.append("from ConfigOperation");
        hql.append(" where 1 = 1");
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isNotEmpty(hospitalId)) {
            hql.append(" and hospitalId = :hospitalId");
            params.put("hospitalId", hospitalId);
        }
        if (null != status) {
            hql.append(" and status = :status");
            params.put("status", status);
        }
        return get(hql.toString(), params);
    }

    @Override
    public ConfigOperation getOperation(Integer id) {
        return get(id);
    }

    @Override
    public Integer addOperation(ConfigOperation operation) {
        return add(operation);
    }

    @Override
    public void updateOperation(ConfigOperation operation) {
        update(operation);
    }

    @Override
    public void deleteOperation(Integer id) {
        delete(id);
    }
}
