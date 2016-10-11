package com.s3d.auth.acl.web.controller.helper;

import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.vo.OrgVO;
import com.s3d.tech.slicer.PageResult;

import java.util.*;

/**
 * Convert object, convert to json.
 *
 * @author wind.chen
 * @desc com.s3d.auth.acl.service.impl.jsonConvertor
 * @date 2015/11/8 15:05
 */
public class OrgConvertor {

    /**
     * @param pageResult
     * @return
     */
    public static Map toMapForQuerySubOrgs(PageResult<OrgVO> pageResult) {
        Map map = new HashMap();
        map.put("count", pageResult.getTotalRecords());

        List<Map> departments = new ArrayList<Map>();
        List<OrgVO> orgList = pageResult.getResults();
        for (int i = 0; i < orgList.size(); i++) {
            OrgVO org = orgList.get(i);
            Map oneOrg = new HashMap();
            oneOrg.put("id", org.getId());
            oneOrg.put("text", org.getName());
            oneOrg.put("parent", org.getParentName());
            oneOrg.put("order", org.getOrder());
            oneOrg.put("remark", org.getRemark());
            departments.add(oneOrg);
        }
        map.put("result", departments);
       return map;
    }

    /**
     * @param orgs
     * @return
     */
    public static List<Map> toMapForGetAllOrgs(List<Org> orgs) {
        List<Map> orgMaps = new ArrayList<Map>();
        if (orgs != null && orgs.size() > 0) {
            for(Org org : orgs){
                Map oneOrgMap = handleOneOrg(org);
                orgMaps.add(oneOrgMap);
            }
        }
        return orgMaps;
    }

    private static Map handleOneOrg(Org org) {
        if (org != null) {
            Map orgMap = new HashMap();
            orgMap.put("id", org.getId());
            orgMap.put("text", org.getName());
            List<Map> nodes = new ArrayList<Map>();
            if (org.getChildren() != null && org.getChildren().size() > 0) {
                for (Org child : org.getChildren()) {
                    Map childMap = handleOneOrg(child);
                    nodes.add(childMap);
                }
            }
            orgMap.put("nodes", nodes);
            return orgMap;
        }
        return null;
    }
}
