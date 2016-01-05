package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Module;

import java.util.List;

/**
 * Created by Gary.Feng on 2015/12/30.
 */
public interface ModuleService {

    List<Module> getAllActionModules();

    Module getCodeModule(Integer id);

}
