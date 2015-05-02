package com.s3d.tech.hibernate.hibernatetemplate;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseTemplateDaoImpl<T,KEY>   {
	private HibernateTemplate hibernateTemplate;
	
	public T save(T t) {
		//this.getSession().save(t);
		return t;
	}

	public void delete(T t) {
		 
		//this.
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		//this.hibernateTemplate.
	}

	public void create(T t) {
		// TODO Auto-generated method stub
		
	}

	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		
	}

	public T get(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
