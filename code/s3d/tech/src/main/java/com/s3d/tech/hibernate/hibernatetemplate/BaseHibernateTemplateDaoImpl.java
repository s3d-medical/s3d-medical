package com.s3d.tech.hibernate.hibernatetemplate;

import java.io.Serializable;
import java.util.List;

import com.s3d.tech.hibernate.GenericDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseHibernateTemplateDaoImpl<T,ID extends Serializable>   implements GenericDao<T,ID> {
private HibernateTemplate hibernateTemplate   ;
	
	public BaseHibernateTemplateDaoImpl(){
		
	}

	public HibernateTemplate getHibernateTemplate() {
		return this.hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public void save(List<T> objs) {
		// TODO Auto-generated method stub

	}

	public void delete(ID id) {
		// TODO Auto-generated method stub
		
	}
	public void delete(T obj) {
		// TODO Auto-generated method stub
		
	}
	public void update(T obj) {
		// TODO Auto-generated method stub
		
	}
	public T get(ID key) {
		// TODO Auto-generated method stub
		return null;
	}
	public T save(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		
	}
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	 
}

	 
