package com.s3d.auth.acl.service;

import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.vo.result.OrgVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;

import java.util.List;

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
    public void saveOrUpdate(OrgVO orgVO);

    /**
     * delete an org
     * @param orgId
     */
    public void deleteOrg(Integer orgId);

    /**
     * Get all orgnizations.
     * @return
     */
    public List<Org> getAllOrgs();

    public PageResult<OrgVO> getDirectChildrenPage(Integer orgId, PageParam pageParam);

}
