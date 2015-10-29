package com.s3d.webapps.sys.security.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.constant.BaseTreeConstant;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.security.dao.IUserDao;
import com.s3d.webapps.sys.security.persistence.User;
import com.s3d.webapps.sys.security.service.IUserServiceMgr;
import com.s3d.webapps.sys.security.userdetails.UserAuthInfo;

@ChildOf(parent="securityElementService")
@Service(IUserServiceMgr.SERVICE_NAME)
public class UserServiceMgrImpl extends SecurityElementServiceMgrImpl implements IUserServiceMgr {
	
	
	private IUserDao userDao;
	
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IBaseDao getBaseDao(){
		return userDao;
	}
	
	@Override
	public String add(EntityObject modelObj) {
		User user = (User) modelObj;
		if(user.getFdIsAvailable()==null){
			user.setFdIsAvailable(true);
			user.setFdCreateTime(new Date());
		}
		return super.add(user);
	}
	
	@Override
	public User findByLoginName(String username) {
		return userDao.loadUserByLoginName(username);
	}

	@Override
	public User createAnonymousUser() {
		User user = userDao.loadUserByLoginName("anonymous");
		if (user == null) {
			user = new User();
			user.setFdId("294de3557d9d00b3d2d8a1e6aab028cf");
			user.setFdLoginName("anonymous");
			user.setFdName("游客");
			user.setFdEmail("0");
			user.setFdPassword("nopass");
			user.setFdIsAvailable(true);
			this.add(user);
		} else {
			if (user.getFdIsAvailable().equals(false)) {
				user.setFdIsAvailable(true);
				this.update(user);
			}
		}
		return user;
	}
	
	@Override
	public UserAuthInfo getOrgsUserAuthInfo(User user) {
		UserAuthInfo rtnInfo = new UserAuthInfo();
		List<String> hierarchyIds = new ArrayList<String>();
		if(StringUtils.isNotEmpty(user.getFdHierarchyId()))
			hierarchyIds.add(user.getFdHierarchyId());
		
		List<String> ids = new ArrayList<String>();
		ids.add(user.getFdId());

		List<String> parentIds = new ArrayList<String>();
		if (StringUtils.isNotEmpty(user.getFdParentId()))
			parentIds.add(user.getFdParentId());

		rtnInfo.setDirectParentIds(parentIds);

		for (int i = 0; i < hierarchyIds.size(); i++) {
			String[] parentIdArr = hierarchyIds.get(i).toString()
					.split(BaseTreeConstant.HIERARCHY_ID_SPLIT);
			for (int j = 1; j < parentIdArr.length - 1; j++) {
				String id = parentIdArr[j];
				if (!ids.contains(id))
					ids.add(id);
			}
		}
		rtnInfo.setAuthOrgIds(ids);
		return rtnInfo;
	}
}
