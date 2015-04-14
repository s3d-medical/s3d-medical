package com.s3d.webapps.sys.security.dao;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.sys.security.persistence.BaseSecurityElement;
import com.s3d.webapps.sys.security.persistence.User;

public interface ISecurityElementDao  extends IBaseDao{
		BaseSecurityElement format(BaseSecurityElement element);
}
