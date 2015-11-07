package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.service.OrgService;
import com.s3d.auth.acl.vo.OrgVO;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/7 18:48
 */
public class OrgServiceImpl implements OrgService {
    private OrgDao orgDao ;
    @Override
    public void saveOrUpdateOrg(OrgVO orgVO) {
        Assert.isTrue(orgVO != null, "Saved org can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(orgVO.getCode()), "Org code can not be null" );
        Assert.isTrue(!StringUtils.isEmpty(orgVO.getName()), "Org name can not be null" );
        // check code is duplicated.
        Org extOrg = orgDao.getOrgByCode(orgVO.getCode());
        if(extOrg != null){
            //
            if(orgVO.getId() != null && !orgVO.getId().equals(extOrg.getId())){
                StringBuilder error = new StringBuilder();
                error.append("");
                throw new RuntimeException(" " );
            }
        }
        //orgDao.saveOrUpdate(orgVO);
    }

    @Override
    public void deleteOrg(Integer orgId) {

    }

    @Resource
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }
}
