package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/12/30.
 */
@Service
public class ModuleServiceImpl implements ModuleService {
    @Override
    public List<Module> getAllActionModules() {
        return moduleDao.getAllActionModules();
    }

    @Override
    public Module getCodeModule(Integer id) {
        return moduleDao.getCodeModule(id);
    }

    private ModuleDao moduleDao;

    @Autowired
    public void setModuleDao(ModuleDao moduleDao) {
        this.moduleDao = moduleDao;
    }
}
