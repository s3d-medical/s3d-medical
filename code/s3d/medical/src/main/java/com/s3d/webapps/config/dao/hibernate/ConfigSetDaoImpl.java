package com.s3d.webapps.config.dao.hibernate;

import com.s3d.tech.data.dao.hibernate.HibernateDao;
import com.s3d.webapps.config.dao.ConfigSetDao;
import com.s3d.webapps.config.persistence.ConfigSet;
import com.s3d.webapps.pub.datatype.ValidationStatus;
import com.s3d.webapps.util.ObjectUtil;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind.chen
 * @date 2015/5/23.
 */
@Repository
public class ConfigSetDaoImpl extends HibernateDao<ConfigSet, Integer> implements ConfigSetDao {

    @Override
    public List<ConfigSet> getConfigSets(String fdType, ValidationStatus validationStatus) {
        StringBuilder hql = new StringBuilder();
        hql.append("from ConfigSet configSet where configSet.fdType = :fdType and configSet.fdStatus = :fdStatus");
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("fdType", fdType);
        paramMap.put("fdStatus", validationStatus.ordinal());
        return this.get(hql.toString(), paramMap);
    }
}
