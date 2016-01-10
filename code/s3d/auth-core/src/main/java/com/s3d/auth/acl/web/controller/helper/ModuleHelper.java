package com.s3d.auth.acl.web.controller.helper;

import com.s3d.auth.acl.entity.Action;
import com.s3d.auth.acl.entity.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gary.Feng on 2016/1/8.
 */
public class ModuleHelper {

    /**
     * Convert all modules to map
     * @param modules
     * @return
     */
    public static List<Map> toMapForGetAllModules(List<Module> modules) {
        List<Map> result = new ArrayList<Map>();
        for (Module module : modules) {
            Map moduleMap = new HashMap();
            moduleMap.put("id", module.getId());
            moduleMap.put("text", module.getName());
            List<Map> nodes = new ArrayList<Map>();
            for (Action action : module.getActions()) {
                Map actionMap = new HashMap();
                actionMap.put("id", action.getId());
                actionMap.put("text", action.getActionName());
                nodes.add(actionMap);
            }
            moduleMap.put("nodes", nodes);
            result.add(moduleMap);
        }
        return result;
    }
}
