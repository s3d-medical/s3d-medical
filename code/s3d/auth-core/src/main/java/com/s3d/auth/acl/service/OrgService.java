package com.s3d.auth.acl.service;

import com.s3d.auth.acl.vo.OrgVO;

/**
 * @author zhigang.chen
 * @desc com.s3d.auth.acl.service
 * @date 2015/11/7 15:10
 */
public interface OrgService {
    /**
     * add or update an org.
     * @param orgVO
     */
    public void saveOrUpdateOrg(OrgVO orgVO);

    /**
     * delete an org
     * @param orgId
     */
    public void deleteOrg(Integer orgId);

}
