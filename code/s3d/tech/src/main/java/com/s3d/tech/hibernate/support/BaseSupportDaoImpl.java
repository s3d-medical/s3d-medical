package com.s3d.tech.hibernate.support;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import com.s3d.tech.hibernate.GenericDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract  class BaseSupportDaoImpl<T, ID extends Serializable> 
extends HibernateDaoSupport implements GenericDao<T, ID> {
	 private Class<T> objClass;  
	 
	public BaseSupportDaoImpl(){
		ParameterizedType parameterizedType = (ParameterizedType) getClass()  
        .getGenericSuperclass() ;		
		objClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	public T save(T t) {
		this.saveOrUpdate(t);
		return t;
	}

	public void delete(T t) {
		this.getSession().delete(t.getClass());
	}

	public void delete(Long id) {
		//this.getSession().load(T, id);
		
		//this.getSession().delete(object);
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
	public Class<T> getObjClass() {
		return objClass;
	}
	public void setObjClass(Class<T> objClass) {
		this.objClass = objClass;
	}
 
	
}
