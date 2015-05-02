package com.s3d.tech.hibernate;

import java.io.Serializable;

public interface GenericDao<T, ID extends Serializable > {
	public T save(T t); 
	public void saveOrUpdate(T t);
	public void delete(Long id); 
	public void update(T t);
	public T get(ID key);
}