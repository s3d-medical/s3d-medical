package com.s3d.auth.acl.web.controller.helper;

import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.vo.OrgExtVO;
import com.s3d.tech.slicer.PageResult;
import com.s3d.tech.utils.JacksonParser;

import java.util.*;

/**
 * Convert object, convert to json.
 *
 * @author wind.chen
 * @desc com.s3d.auth.acl.service.impl.jsonConvertor
 * @date 2015/11/8 15:05
 */
public class OrgJsonHelper {
    /**
     * convert to this format
     * {
     * "count": 100,
     * "departments":[{
     * "id": 1,
     * "text": "当前点击的机构名称",
     * "parent": "父机构名称",
     * "order": 1,
     * "remark": ""
     * }]
     * }
     *
     * @param pageResult
     * @return
     */
    public static String toJsonForGetDirectChildrenPage(PageResult<OrgExtVO> pageResult) {
        Map map = new HashMap();
        map.put("count", pageResult.getTotalRecords());

        List<Map> departments = new ArrayList<Map>();
        List<OrgExtVO> orgList = pageResult.getResults();
        for (int i = 0; i < orgList.size(); i++) {
            OrgExtVO org = orgList.get(i);
            Map oneOrg = new HashMap();
            oneOrg.put("id", org.getId());
            oneOrg.put("text", org.getName());
            oneOrg.put("parent", org.getParentName());
            oneOrg.put("order", org.getOrder());
            oneOrg.put("remark", org.getRemark());
            departments.add(oneOrg);
        }

        map.put("departments", departments);
        return JacksonParser.convertToJSONString(map);
    }

    /**
     * @param orgs
     * @return
     */
    public static String toJsonForGetAllOrgs(List<Org> orgs) {
        List<Map> orgMaps = new ArrayList<Map>();
        if (orgs != null && orgs.size() > 0) {
            for(Org org : orgs){
                Map oneOrgMap = toMapForOneOrg(org);
                orgMaps.add(oneOrgMap);
            }
        }
        return JacksonParser.convertToJSONString(orgMaps);
    }

    private static Map toMapForOneOrg(Org org) {
        if (org != null) {
            Map orgMap = new HashMap();
            orgMap.put("id", org.getId());
            orgMap.put("text", org.getName());
            List<Map> nodes = new ArrayList<Map>();
            if (org.getChildren() != null && org.getChildren().size() > 0) {
                for (Org child : org.getChildren()) {
                    Map childMap = toMapForOneOrg(child);
                    nodes.add(childMap);
                }
            }
            orgMap.put("nodes", nodes);
        }
        return null;
    }
}
