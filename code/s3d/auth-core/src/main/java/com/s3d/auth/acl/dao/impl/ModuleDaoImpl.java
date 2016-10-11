package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.entity.Module;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/12/30.
 */
@Repository
public class ModuleDaoImpl extends HibernateDao<Module, Integer> implements ModuleDao {
    @Override
    public List<Module> getAllActionModules() {
        return getAll();
    }

    @Override
    public Module getCodeModule(Integer id) {
        return this.get(id);
    }
}
