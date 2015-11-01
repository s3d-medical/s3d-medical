package com.s3d.auth.acl.dao.impl;

import com.s3d.auth.acl.dao.ActionDao;
import com.s3d.auth.acl.entity.Action;
import com.s3d.tech.data.dao.hibernate.CommonDao;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @desc com.s3d.auth.acl.dao.impl
 * @date 2015/11/1 17:46
 */
@Repository
public class ActionDaoImpl extends CommonDao<Action, Integer> implements ActionDao {

}
