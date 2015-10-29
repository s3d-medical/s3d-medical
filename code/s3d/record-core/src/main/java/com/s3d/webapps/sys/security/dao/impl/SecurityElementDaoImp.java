package com.s3d.webapps.sys.security.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.constant.BaseTreeConstant;
import com.s3d.webapps.constant.SecurityElementConstant;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.security.dao.ISecurityElementDao;
import com.s3d.webapps.sys.security.persistence.BaseSecurityElement;
import com.s3d.webapps.sys.security.persistence.User;

@ChildOf(parent="BaseDao")
@Repository("securityElementDao")
public class SecurityElementDaoImp extends BaseDaoImp implements ISecurityElementDao ,SecurityElementConstant ,BaseTreeConstant{
	private static final Log logger = LogFactory.getLog(SecurityElementDaoImp.class);
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	@Override
	public String getModelName() {
		return BaseSecurityElement.class.getName();
	}
	
	private String getTreeHierarchyId(BaseSecurityElement element) {
		if (element.getFdParent() == null)
			return HIERARCHY_ID_SPLIT + element.getFdId() + HIERARCHY_ID_SPLIT;
		else
			return element.getFdParent().getFdHierarchyId() + element.getFdId()
					+ HIERARCHY_ID_SPLIT;
	}
	
	public String add(EntityObject modelObj){
		BaseSecurityElement element = (BaseSecurityElement) modelObj;
		if (!element.getFdIsAvailable().booleanValue()) {
			clearRelation(element);
			return super.add(element);
		}
		super.add(modelObj);
		// 更新层级ID
		element.setFdHierarchyId(getTreeHierarchyId(element));
		
		super.update(element);
		return element.getFdId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(EntityObject modelObj) {
		BaseSecurityElement element = (BaseSecurityElement) modelObj;
		element.setFdAlterTime(new Date());
		if (!element.getFdIsAvailable().booleanValue()) {
			clearRelation(element);
			return;
		}
		// 更新层级ID
		String hierarchyId = element.getFdHierarchyId();
		element.setFdHierarchyId(getTreeHierarchyId(element));
		super.update(modelObj);

		int orgType = element.getFdOrgType().intValue();
		if (orgType > SEC_TYPE_ORG)
			return;

		// 更新企业时，判断层级ID是否有改动，若已经改动，则更新所有下级关系
		if (!hierarchyId.equals(element.getFdHierarchyId())) {
			final String hql = "update com.s3d.webapps.sys.security.persistence.BaseSecurityElement set fdAlterTime=:thisDay," +
			
			"fdHierarchyId='" + element.getFdHierarchyId()
					+ "' || substring(fdHierarchyId, "
					+ (hierarchyId.length() + 1) + ", length(fdHierarchyId)) " +
					
					"where substring(fdHierarchyId,1," + hierarchyId.length()
					+ ")='" + hierarchyId + "'";
			if (logger.isDebugEnabled())
				logger.debug("更新企业的所有下级关系，hql=" + hql);
			
			getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Query q = session.createQuery(hql);
					
					q.setParameter("thisDay", new Date());
					q.executeUpdate();
					
					return null;
				}
			});			
			
		}
	}
	
	protected void clearRelation(BaseSecurityElement element) {
		element.setHbmParent(null);
		element.setFdHierarchyId("0");
	}
		
	public BaseSecurityElement format(BaseSecurityElement element) {
		if (element == null)
			return null;
		switch (element.getFdOrgType().intValue()) {
		case SEC_TYPE_PERSON:
			return (User) findByPrimaryKey(element.getFdId(),
					User.class, false);
		default:
			return null;
		}
	}
}
