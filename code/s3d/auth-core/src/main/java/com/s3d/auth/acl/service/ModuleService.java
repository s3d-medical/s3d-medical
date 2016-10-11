package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Module;

import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2015/12/30.
 */
public interface ModuleService {

    List<Map> getAllActionModules();

    Module getCodeModule(Integer id);

}
