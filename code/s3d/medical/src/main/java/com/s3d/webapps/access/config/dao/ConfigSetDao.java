package com.s3d.webapps.access.config.dao;

import com.s3d.tech.data.dao.GenericDao;
import com.s3d.webapps.access.config.persistence.ConfigSet;
import com.s3d.webapps.pub.datatype.ValidationStatus;

import java.util.List;

/**
 * @author  wind.chen
 * @date 2015/5/23.
 */
public interface ConfigSetDao extends GenericDao<ConfigSet, Integer> {
    public List<ConfigSet> getConfigSets(String fdType, ValidationStatus validationStatus);
}
