package com.s3d.webapps.sys.acl.role.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.s3d.webapps.cache.ehcache.WebAppCache;
import com.s3d.webapps.common.dao.BaseDaoImp;
import com.s3d.webapps.common.dao.HQLWrapper;
import com.s3d.webapps.framework.spring.annotation.ChildOf;
import com.s3d.webapps.sys.acl.role.dao.ISysRoleDao;
import com.s3d.webapps.sys.acl.role.persistence.SysRole;
import com.s3d.webapps.util.HQLUtil;

@ChildOf(parent="BaseDao")
@Repository("sysRoleDao")
public class SysRoleDaoImp extends BaseDaoImp implements ISysRoleDao {
	private static final Log logger = LogFactory.getLog(SysRoleDaoImp.class);

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

	@Override
	public String getModelName() {
		return SysRole.class.getName();
	}

	@SuppressWarnings("unchecked")
	private Map getRoleInhMap() {
		WebAppCache cache = new WebAppCache(SysRole.class);
		Map roleInhMap = (Map) cache.get("roleInhMap");
		if (roleInhMap == null) {
			
			roleInhMap = (Map) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					return HQLUtil.buildManyToManyIDMap(session,
					"select fd_roleid,fd_inhroleid from hr_auth_rra");
					
				}
			});
		
			cache.put("roleInhMap", roleInhMap);
		}
		return roleInhMap;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRoleAliasesByOrgIds(List<String> orgIds) {
		List<String> rtnList = getRoleIdsByOrgIds(orgIds);
		if (!rtnList.isEmpty()) {
			final HQLWrapper hqlWrapper = HQLUtil.buildPreparedLogicIN("fd_id",
					rtnList);
			final String sql = "select fd_alias from hr_auth_role where fd_alias is not null and "
					+ hqlWrapper.getHql();
						
			rtnList = (List<String>) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					return HQLUtil.setParameters(
							session.createSQLQuery(sql),
							hqlWrapper.getParameterList()).list();
					
				}
			});
		}
		
		return rtnList;
	}

	@SuppressWarnings("unchecked")
	public List<String> getRoleIdsByOrgIds(List<String> orgIds) {
		List<String> rtnList;
		if (!orgIds.isEmpty()) {
			final HQLWrapper hqlWrapper = HQLUtil.buildPreparedLogicIN(
					"fd_orgelementid", orgIds);
			
			final String sql = "select fd_roleid from hr_auth_ura where "
					+ hqlWrapper.getHql();
			
			rtnList = (List<String>) this.getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					
					return HQLUtil.setParameters(session.createSQLQuery(sql),
							hqlWrapper.getParameterList()).list();
					
				}
			});
			
			rtnList = HQLUtil.fetchManyToManyIDList(rtnList, getRoleInhMap());
		} else
			rtnList = new ArrayList<String>();
		return rtnList;
	}
}
