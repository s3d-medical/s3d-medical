package com.s3d.webapps.sys.security.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.security.dao.IUserDao;
import com.s3d.webapps.sys.security.persistence.BaseSecurityElement;
import com.s3d.webapps.sys.security.persistence.User;

@ChildOf(parent="securityElementDao")
@Repository("userDao")
public class UserDaoImp extends SecurityElementDaoImp implements IUserDao {
	
	@Override
	public String getModelName() {
		return User.class.getName();
	}
	
	public void updateUser(EntityObject modelObj) throws Exception {
		BaseSecurityElement element = (BaseSecurityElement) modelObj;
		element.setFdAlterTime(new Date());
		getHibernateTemplate().update(element);
	}

	public void abandonUser(EntityObject modelObj) throws Exception {
		User user = (User) modelObj;
		getHibernateTemplate().update(user);
	}
	
	@Override
	public User loadUserByLoginName(String fdLoginName) {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock("lower(user.fdLoginName)=:fdLoginName and user.fdIsAvailable=:fdIsAvailable");
		
		hqlInfo.setParameter("fdLoginName", fdLoginName.toLowerCase().replaceAll(
				"'", "''"));
		hqlInfo.setParameter("fdIsAvailable", true);
		List rtnList = findList(hqlInfo);
		if (rtnList.isEmpty())
			return null;
		else
			return (User) rtnList.get(0);
	}
}
