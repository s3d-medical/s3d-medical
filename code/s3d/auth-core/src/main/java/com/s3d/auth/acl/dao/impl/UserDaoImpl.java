package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.UserDao;
import com.s3d.auth.acl.entity.User;
import com.s3d.tech.data.dao.hibernate.CommonDao;
import com.s3d.tech.data.dao.hibernate.HibernateDao;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:47
 */
@Repository
public class UserDaoImpl extends HibernateDao<User, Integer> implements UserDao {

}
