package com.s3d.webapps.common.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.component.db.Page;
import com.s3d.webapps.util.HQLUtil;
import com.s3d.webapps.util.IDGenerator;


public class BaseDaoImp extends HibernateDaoSupport implements IBaseDao{
	
	protected IHQLBuilder hqlBuilder = null;

	private String modelName;

	public String add(EntityObject modelObj)  {
		if(StringUtils.isEmpty(modelObj.getFdId()))
			modelObj.setFdId(IDGenerator.generateID());
		modelObj.recalculateFields();
		getHibernateTemplate().save(modelObj);
		return modelObj.getFdId();
	}

	public void delete(EntityObject modelObj)  {
		getHibernateTemplate().delete(modelObj);
	}

	public void flushHibernateSession() {
		getSession().flush();
	}

	public <T extends EntityObject> T findByPrimaryKey(String id)  {
		return findByPrimaryKey(id, null, true);
	}

	public <T extends EntityObject> T findByPrimaryKey(String id, Object modelInfo,
			boolean noLazy)  {
		Object rtnVal = null;
		if (id != null) {
			try {
				if (modelInfo == null)
					modelInfo = getModelName();
				if (modelInfo instanceof Class) {
					if (noLazy)
						rtnVal = getHibernateTemplate().get((Class) modelInfo,
								id);
					else
						rtnVal = getHibernateTemplate().load((Class) modelInfo,
								id);
				} else {
					if (noLazy)
						rtnVal = getHibernateTemplate().get((String) modelInfo,
								id);
					else
						rtnVal = getHibernateTemplate().load(
								(String) modelInfo, id);
				}
			} catch (HibernateObjectRetrievalFailureException e) {
			}
		}
		return (T) rtnVal;
	}

	public final List findByPrimaryKeys(String[] ids)  {
		ArrayList modelList = new ArrayList();
		EntityObject model;
		for (int i = 0; i < ids.length; i++) {
			model = findByPrimaryKey(ids[i]);
			if (model != null)
				modelList.add(model);
		}
		return modelList;
	}

	public List findList(HQLInfo hqlInfo)  {
		hqlInfo.setFromBlock(null);
		return createListByHbmQuery(hqlInfo);
	}

	public List findList(String whereBlock, String orderBy)  {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock(whereBlock);
		hqlInfo.setOrderBy(orderBy);
		return findList(hqlInfo);
	}

	public Page findPage(HQLInfo hqlInfo)  {
		Page page = null;
//		if (hqlInfo.getAuthCheckType() == null)
//			hqlInfo.setAuthCheckType(AUTH_CHECK_READER);
		int total = hqlInfo.getRowSize();
		if (hqlInfo.isGetCount()) {
			hqlInfo.setGettingCount(true);
			final HQLWrapper hqlWrapper = createHQLWrapper(hqlInfo);
			total = getHibernateTemplate().execute(new HibernateCallback<Integer>(){
				@Override
				public Integer doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlWrapper.getHql());
					HQLUtil.setParameters(query, hqlWrapper.getParameterList());
					return ((Long)query.iterate().next()).intValue();
				}}
			);
		}
		if (total > 0) {
			hqlInfo.setGettingCount(false);
			page = new Page();
			page.setRowsize(hqlInfo.getRowSize());
			page.setPageno(hqlInfo.getPageNo());
			page.setTotalrows(total);
			page.excecute();
			
			final int start = page.getStart();
			final int rowsize = page.getRowsize();
			final HQLWrapper hqlWrapper = createHQLWrapper(hqlInfo);
			List list = getHibernateTemplate().execute(new HibernateCallback<List>(){
				@Override
				public List doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query query = session.createQuery(hqlWrapper.getHql());					
					HQLUtil.setParameters(query, hqlWrapper.getParameterList());
					query.setFirstResult(start);
					query.setMaxResults(rowsize);					
					return query.list();
				}}
			);
			page.setList(list);
		}
		if (page == null) {
			page = Page.getEmptyPage();
		}
		return page;
	}

	public Page findPage(String whereBlock, String orderBy, int pageno,
			int rowsize)  {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setWhereBlock(whereBlock);
		hqlInfo.setOrderBy(orderBy);
		hqlInfo.setPageNo(pageno);
		hqlInfo.setRowSize(rowsize);
		return findPage(hqlInfo);
	}

	public List findValue(HQLInfo hqlInfo)  {
		return createListByHbmQuery(hqlInfo);
	}

	public Iterator findValueIterator(HQLInfo hqlInfo)  {
		final HQLWrapper hqlWrapper = createHQLWrapper(hqlInfo);
		return getHibernateTemplate().execute(new HibernateCallback<Iterator>(){
			@Override
			public Iterator doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hqlWrapper.getHql());
				HQLUtil.setParameters(query, hqlWrapper.getParameterList());
				return query.iterate();
			}}
		);
	}

	public void findValueIterator(HQLInfo hqlInfo, boolean isClear,
			IteratorCallBack callBack)  {
		Iterator iterate = findValueIterator(hqlInfo);
		while (iterate.hasNext()) {
			Object obj = iterate.next();
			callBack.exec(obj);
			if (isClear) {
				getSession().flush();
				getSession().clear();
			} else {
				getSession().evict(obj);
			}
		}
	}

	public List findValue(String selectBlock, String whereBlock, String orderBy)
			 {
		HQLInfo hqlInfo = new HQLInfo();
		hqlInfo.setSelectBlock(selectBlock);
		hqlInfo.setWhereBlock(whereBlock);
		hqlInfo.setOrderBy(orderBy);
		return findValue(hqlInfo);
	}
	
	/**
	 * @deprecated 会有session close问题,建议使用 getHibernateTemplate().execute(new HibernateCallback() { ....  的方式
	 */
	public Session getHibernateSession() {
		return getSession();
	}

	public String getModelName() {
		return modelName;
	}


	/**
	 * 设置HQL拼装器
	 * 
	 * @param hqlBuilder
	 */
	public void setHqlBuilder(IHQLBuilder hqlBuilder) {
		this.hqlBuilder = hqlBuilder;
	}

	/**
	 * 设置Dao对应的域模型
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void update(EntityObject modelObj)  {
		modelObj.recalculateFields();
		getHibernateTemplate().saveOrUpdate(modelObj);
	}
	
	protected HQLWrapper createHQLWrapper(HQLInfo hqlInfo) {
		if(StringUtils.isEmpty(hqlInfo.getModelName())){
			hqlInfo.setModelName(getModelName());
		}
		return hqlBuilder.buildQueryHQL(hqlInfo);
	}
	
	protected List createListByHbmQuery(HQLInfo hqlInfo)  {
		final HQLWrapper hqlWrapper = createHQLWrapper(hqlInfo);
		return getHibernateTemplate().execute(new HibernateCallback<List>(){
			@Override
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hqlWrapper.getHql());
				HQLUtil.setParameters(query, hqlWrapper.getParameterList());
				return query.list();
			}}
		);
	}

	public void clearHibernateSession() {
		getSession().clear();
	}

	public boolean isExist(final String modelName,final String fdId)  {
		return getHibernateTemplate().execute(new HibernateCallback<Boolean>(){
			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				return session.createQuery(
						"select fdId from " + modelName + " where fdId=:fdId")
						.setParameter("fdId", fdId).list().size() > 0;
			}}
		);
	}
}
