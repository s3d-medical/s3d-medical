package com.s3d.webapps.da.customer.service.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Service;

import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.service.AbstractBaseServiceMgr;
import com.s3d.webapps.da.config.DASysProperties;
import com.s3d.webapps.da.customer.dao.IDaCustomerLabelDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerLabel;
import com.s3d.webapps.da.customer.service.IDaCustomerLabelService;
import com.s3d.webapps.framework.spring.annotation.ChildOf;

/**
 * 盘号信息业务接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseService")
@Service(IDaCustomerLabelService.SERVICE_NAME)
public class DaCustomerLabelServiceImp extends AbstractBaseServiceMgr implements IDaCustomerLabelService {
	@Autowired
	private IDaCustomerLabelDao daCustomerLabelDao;
	
	public IBaseDao getBaseDao(){
		return daCustomerLabelDao;
	}
	
	@Override
	public String add(EntityObject modelObj) {
		DaCustomerLabel label = (DaCustomerLabel) modelObj;
		String name = label.getFdName();
		String path = DASysProperties.getDataFilePath()+"/"+name;
		File labelDir = new File(path);
		if(!labelDir.exists())
			throw new RuntimeException("盘号不存在,请检查!"+path);
		return super.add(modelObj);
	}
	
	@SuppressWarnings("unchecked")
	public Long getFileNoNullCount(final String labelId){
		final String hql = "select count(*) from com.s3d.webapps.da.customer.persistence.DaCustomerPicture where fdLabel.fdId=:label and fdFileNo is null";
		
		List result = (List) getBaseDao().getHibernateTemplate().execute(new HibernateCallback() {
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				query.setParameter("label", labelId);
				List result = query.list();
				return result;
			}
		});
		
		for (int i = 0; i < result.size();) {
			return (Long) result.get(i);
		}
		
		return -1L;
	}
	
	@SuppressWarnings("unchecked")
	public Long getCategoryNullCount(final String labelId){
		final String hql = "select count(*) from com.s3d.webapps.da.customer.persistence.DaCustomerPicture where fdLabel.fdId=:label and fdCategory is null";
		List result = (List) getBaseDao().getHibernateTemplate().execute(new HibernateCallback() {
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				query.setParameter("label", labelId);
				List result = query.list();
				return result;
			}
		});
		
		for (int i = 0; i < result.size();) {
			return (Long) result.get(i);
		}
		
		return -1L;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Long getNoFillIndexPageCount(final String labelId) {
		final String hql = "select count(*) from com.s3d.webapps.da.customer.persistence.DaCustomerPicture where fdLabel.fdId=:label and fdCategory.fdType=:type"; //这盘里有多少个首页
		List result = (List) getBaseDao().getHibernateTemplate().execute(new HibernateCallback() {
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql);
				query.setParameter("label", labelId);
				query.setParameter("type", 1);
				List result = query.list();
				return result;
			}
		});
		Long expectedCount = 0L; 
		for (int i = 0; i < result.size();) {
			expectedCount = (Long) result.get(i);
			break;
		}
		
		final String hql2 = "select count(*) from com.s3d.webapps.da.customer.persistence.DaCustomerShouye where fdLabel.fdId=:label"; //已经录入了多少
		result = (List) getBaseDao().getHibernateTemplate().execute(new HibernateCallback() {
			public List doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query = session.createQuery(hql2);
				query.setParameter("label", labelId);
				List result = query.list();
				return result;
			}
		});
		Long existCount = 0L; 
		for (int i = 0; i < result.size();) {
			existCount = (Long) result.get(i);
			break;
		}
		
		return expectedCount - existCount;
	}
}
