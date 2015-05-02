package com.s3d.tech.hibernate.jdbctemplate;

import java.io.Serializable;
import java.util.List;

import com.s3d.tech.hibernate.GenericDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public  class BaseJdbcTemplateDaoImpl<T,ID extends Serializable>  implements GenericDao<T,ID> {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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

	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
