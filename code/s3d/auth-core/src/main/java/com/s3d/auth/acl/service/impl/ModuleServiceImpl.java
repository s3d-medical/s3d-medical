package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.ModuleDao;
import com.s3d.auth.acl.entity.Module;
import com.s3d.auth.acl.service.ModuleService;
import com.s3d.auth.acl.web.controller.helper.ModuleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2015/12/30.
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
    @Override
    public List<Map> getAllActionModules() {
        List<Module> modules = moduleDao.getAllActionModules();
        List<Map> maps = ModuleHelper.toMapForGetAllModules(modules);
        return maps;
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
