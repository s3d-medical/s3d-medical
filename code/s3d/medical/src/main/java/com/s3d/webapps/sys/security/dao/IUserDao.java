package com.s3d.webapps.sys.security.dao;

import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.sys.security.persistence.User;

/**
 * 个人数据访问接口
 * 
 * @author s3d
 */
public interface IUserDao extends ISecurityElementDao {
	
	public void updateUser(EntityObject modelObj) throws Exception;

	public void abandonUser(EntityObject modelObj) throws Exception;
	
	public User loadUserByLoginName(
			String fdLoginName	
		);
	
}