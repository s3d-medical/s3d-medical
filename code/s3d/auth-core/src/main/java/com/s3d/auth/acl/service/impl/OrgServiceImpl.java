package com.s3d.auth.acl.service.impl;

import com.s3d.auth.acl.dao.OrgDao;
import com.s3d.auth.acl.entity.Org;
import com.s3d.auth.acl.service.OrgService;
import com.s3d.auth.acl.vo.OrgVO;
import com.s3d.tech.slicer.PageParam;
import com.s3d.tech.slicer.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.service.impl
 * @date 2015/11/7 18:48
 */
@Service
public class OrgServiceImpl implements OrgService {
    private OrgDao orgDao;

    @Transactional
    @Override
    public void saveOrUpdate(OrgVO orgVO) {
        // check org.
        this.checkOrg(orgVO);
        // save or update.
        if (orgVO.getId() > 0) {
            this.update(orgVO);
        } else {
            this.save(orgVO);
        }
    }

    private void save(OrgVO orgVO) {
        Org org = new Org(orgVO.getName(), orgVO.getCode(), orgVO.getKey(), orgVO.getRemark(), Org.STATUS_VALID);
        if (orgVO.getParentId() != null) {
            Org parent = this.orgDao.get(orgVO.getParentId());
            org.setParent(parent);
            //parent.addChild(org);
        }
        this.orgDao.saveOrUpdate(org);
    }

    private void update(OrgVO orgVO) {
        Org org = this.orgDao.get(orgVO.getId());
        if (orgVO.getParentId() != null) {
            Org parent = this.orgDao.get(orgVO.getParentId());
            org.setParent(parent);
            //parent.addChild(org);       // 多方(主动方维护)该步可以省略
        } else {
            org.setParent(null);
        }
        org.setCode(orgVO.getCode());
        org.setKey(orgVO.getKey());
        org.setDesc(orgVO.getRemark());
        org.setName(orgVO.getName());
        org.setOrder(orgVO.getOrder());
        org.setStatus(orgVO.getActive());
        this.orgDao.saveOrUpdate(org);
    }

    private void checkOrg(OrgVO orgVO) {
        // check basically
        Assert.isTrue(orgVO != null, "Saved org can not be null.");
        Assert.isTrue(!StringUtils.isEmpty(orgVO.getCode()), "Org code can not be empty");
        Assert.isTrue(!StringUtils.isEmpty(orgVO.getName()), "Org name can not be empty");

        // check code is duplicated.
        Org extOrg = orgDao.getOrgByCode(orgVO.getCode());
        if (extOrg != null) {
            if (orgVO.getId() != null && !orgVO.getId().equals(extOrg.getId())) {
                StringBuilder error = new StringBuilder();
                error.append("Org code has been used by other org").append(",org id: ").append(extOrg.getId())
                        .append(", org code: ").append(extOrg.getCode()) .append(", org name:").append(extOrg.getName());
                throw new RuntimeException(error.toString());
            }
        }
    }

    @Transactional
    @Override
    public void deleteOrg(Integer orgId) {
        if (orgId == null) {
            throw new RuntimeException("Id of org to delete can not be null.");
        }
        Org org = this.orgDao.get(orgId);
        if (org == null) {
            throw new RuntimeException("Can't find this org by id= " + orgId);
        }
        org.setStatus(Org.STATUS_INVALID);
        this.orgDao.saveOrUpdate(org);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Org> getAllOrgs() {
        List<Org> orgList = this.orgDao.getAllOrgs();
        return orgList;
    }

    @Transactional(readOnly = true)
    @Override
    public PageResult<OrgVO> getDirectChildrenPage(Integer orgId, PageParam pageParam) {
        if (orgId == null || pageParam.isValid() == false) {
            throw new RuntimeException("Org id or parameters form pagination is wrong.");
        }
        Long count = this.orgDao.getDirectChildrenCount(orgId, pageParam);
        List<OrgVO> orgExtVOs = new ArrayList<OrgVO>();
        if(count != null && count > 0){
            List<Org> orgList = this.orgDao.getDirectChildren(orgId, pageParam);
            if (orgList != null && orgList.size() > 0) {
                for (int i = 0; i < orgList.size(); i++) {
                    Org org = orgList.get(i);
                    OrgVO orgExtVO = new OrgVO(org.getId(), org.getCode(), org.getKey(), org.getName(),
                            org.getStatus(), org.getDesc(), 0, org.getParentId(), org.getParentName());
                    orgExtVO.setOrder(pageParam.calOrder(i+1));
                    orgExtVOs.add(orgExtVO);
                }
            }
        }
        PageResult<OrgVO> pageResult = new PageResult(count, orgExtVOs, pageParam.getPageSize(), pageParam.getPageNo());
        return pageResult;
    }

    @Resource
    public void setOrgDao(OrgDao orgDao) {
        this.orgDao = orgDao;
    }
}
