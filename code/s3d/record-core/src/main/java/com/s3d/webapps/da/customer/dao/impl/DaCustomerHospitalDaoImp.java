package com.s3d.webapps.da.customer.dao.impl;

import java.sql.SQLException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.constant.BaseTreeConstant;
import com.s3d.webapps.constant.HospitalOrgConstant;
import com.s3d.webapps.da.customer.dao.IDaCustomerHospitalDao;
import com.s3d.webapps.da.customer.persistence.DaCustomerHospital;
import com.s3d.webapps.framework.spring.annotation.ChildOf;


/**
 * 客户信息数据访问接口实现
 * 
 * @author 
 * @version 1.0 2014-08-15
 */
@ChildOf(parent="BaseDao")
@Repository("daCustomerHospitalDao")
public class DaCustomerHospitalDaoImp extends BaseDaoImp implements IDaCustomerHospitalDao,BaseTreeConstant,HospitalOrgConstant {
	@Override
	public String getModelName() {
		return DaCustomerHospital.class.getName();
	}
	
	
	private String getTreeHierarchyId(DaCustomerHospital element) {
		if (element.getFdParent() == null)
			return HIERARCHY_ID_SPLIT + element.getFdId() + HIERARCHY_ID_SPLIT;
		else
			return element.getFdParent().getFdHierarchyId() + element.getFdId()
					+ HIERARCHY_ID_SPLIT;
	}
	
	public String add(EntityObject modelObj){
		DaCustomerHospital element = (DaCustomerHospital) modelObj;
		
		super.add(modelObj);
		// 更新层级ID
		element.setFdHierarchyId(getTreeHierarchyId(element));
		
		super.update(element);
		return element.getFdId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(EntityObject modelObj) {
		DaCustomerHospital element = (DaCustomerHospital) modelObj;
		element.setFdAlterTime(new Date());
		
		// 更新层级ID
		String hierarchyId = element.getFdHierarchyId();
		element.setFdHierarchyId(getTreeHierarchyId(element));
		super.update(modelObj);

		int orgType = element.getFdOrgType().intValue();
		if (orgType > HSP_TYPE_HOSPITAL)
			return;
		
		// 更新客户时，判断层级ID是否有改动，若已经改动，则更新所有下级关系
		if (!hierarchyId.equals(element.getFdHierarchyId())) {
			final String hql = "update com.s3d.webapps.da.customer.persistence.DaCustomerHospital set fdAlterTime=:thisDay," +
			
			"fdHierarchyId='" + element.getFdHierarchyId()
					+ "' || substring(fdHierarchyId, "
					+ (hierarchyId.length() + 1) + ", length(fdHierarchyId)) " + 
					
					"where substring(fdHierarchyId,1," + hierarchyId.length()
					+ ")='" + hierarchyId + "'";
			
			if (logger.isDebugEnabled())
				logger.debug("更新客户的所有下级关系，hql=" + hql);
			
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
}
