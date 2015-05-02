package com.s3d.tech.hibernate.jdbctemplate;

import java.io.Serializable;

import com.s3d.tech.hibernate.GenericDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract  class BaseTemplateDaoImpl<T,ID extends Serializable>  implements GenericDao<T,ID> {
	private JdbcTemplate jdbcTemplate;
	
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

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
