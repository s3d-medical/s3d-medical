package com.s3d.webapps.common.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.dao.ISpringJDbcDao;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.component.db.Page;

public class AbstractBaseServiceMgr implements BaseServiceMgr {

	protected static Log log = null;

	public AbstractBaseServiceMgr() {
		log = LogFactory.getLog(this.getClass());
	}
	
	private IBaseDao baseDao;
	
	private ISpringJDbcDao springJDbcDao;
	
	public ISpringJDbcDao getSpringJDbcDao() {
		return springJDbcDao;
	}

	public void setSpringJDbcDao(ISpringJDbcDao springJDbcDao) {
		this.springJDbcDao = springJDbcDao;
	}

	public String add(EntityObject modelObj) {
		String rtnVal = getBaseDao().add(modelObj);
		return rtnVal;
	}

	public void delete(EntityObject modelObj)  {
		getBaseDao().delete(modelObj);
	}

	public final void delete(String id)  {
		delete(findByPrimaryKey(id));
	}

	public final void delete(String[] ids)  {
		for (int i = 0; i < ids.length; i++) {
			if (i > 0)
				flushHibernateSession();
			delete(ids[i]);
		}
	}

	public void flushHibernateSession() {
		getBaseDao().flushHibernateSession();
	}

	public <R extends EntityObject>  R findByPrimaryKey(String id)  {
		return (R)getBaseDao().findByPrimaryKey(id);
	}

	public <R extends EntityObject> R findByPrimaryKey(String id, Object modelInfo,
			boolean noLazy)  {
		return (R)getBaseDao().findByPrimaryKey(id, modelInfo, noLazy);
	}
		
	public List findByPrimaryKeys(String[] ids)  {
		return getBaseDao().findByPrimaryKeys(ids);
	}

	public List findList(HQLInfo hqlInfo)  {
		return getBaseDao().findList(hqlInfo);
	}

	public List findList(String whereBlock, String orderBy)  {
		return getBaseDao().findList(whereBlock, orderBy);
	}

	public List findValue(HQLInfo hqlInfo)  {
		return getBaseDao().findValue(hqlInfo);
	}

	public List findValue(String selectBlock, String whereBlock, String orderBy)
			 {
		return getBaseDao().findValue(selectBlock, whereBlock, orderBy);
	}

	public String getModelName() {
		return getBaseDao().getModelName();
	}

	public IBaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	public void update(EntityObject modelObj)  {
		getBaseDao().update(modelObj);
	}

	public void clearHibernateSession() {
		getBaseDao().clearHibernateSession();
	}

	public String addUsingJdbc(EntityObject modelObj)  {
		return getSpringJDbcDao().addUsingJdbc(modelObj);
	}

	public void deleteUsingJdbc(EntityObject modelObj) {
		getSpringJDbcDao().deleteUsingJdbc(modelObj);		
	}

	public void updateUsingJdbc(EntityObject modelObj) {
		getSpringJDbcDao().updateUsingJdbc(modelObj);		
	}

	public EntityObject findById(String id)  {
		return getSpringJDbcDao().findById(id);
	}

	public Page findPage(HQLInfo hqlInfo) {
		return getBaseDao().findPage(hqlInfo);
	}	
}
