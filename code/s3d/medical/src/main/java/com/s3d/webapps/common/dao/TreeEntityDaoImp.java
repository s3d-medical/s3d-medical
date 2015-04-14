package com.s3d.webapps.common.dao;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.common.entity.TreeEntityObject;
import com.s3d.webapps.constant.BaseTreeConstant;
import com.s3d.webapps.util.IDGenerator;

public class TreeEntityDaoImp extends BaseDaoImp implements BaseTreeConstant {
	private String getTreeHierarchyId(TreeEntityObject treeModel) {
		if (treeModel.getFdParent() != null)
			return treeModel.getFdParent().getFdHierarchyId()
					+ treeModel.getFdId() + HIERARCHY_ID_SPLIT;
		else
			return HIERARCHY_ID_SPLIT + treeModel.getFdId()
					+ HIERARCHY_ID_SPLIT;
	}

	@Override
	public String add(EntityObject modelObj){
		if(StringUtils.isEmpty(modelObj.getFdId()))
			modelObj.setFdId(IDGenerator.generateID());
		TreeEntityObject treeModel = (TreeEntityObject) modelObj;
		treeModel.setFdHierarchyId(getTreeHierarchyId(treeModel));
		return super.add(modelObj);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void update(EntityObject modelObj) {
		super.update(modelObj);
		TreeEntityObject treeModel = (TreeEntityObject) modelObj;
		String hierarchyId = getTreeHierarchyId(treeModel);
		if (!hierarchyId.equals(treeModel.getFdHierarchyId())) {
			final String hqlStr = "update "
					+ getModelName()
					+ " set fdHierarchyId='"
					+ hierarchyId
					+ "' || substring(fdHierarchyId, "
					+ (treeModel.getFdHierarchyId().length() + 1)
					+ ", length(fdHierarchyId)) where substring(fdHierarchyId,1,"
					+ treeModel.getFdHierarchyId().length() + ")='"
					+ treeModel.getFdHierarchyId() + "'";
			
			getHibernateTemplate().execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					session.createQuery(hqlStr).executeUpdate();
					return null;
				}
			
			});
			
		}
	}
}
