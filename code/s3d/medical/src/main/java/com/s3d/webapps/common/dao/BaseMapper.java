package com.s3d.webapps.common.dao;

import java.util.List;

import com.s3d.webapps.common.entity.BaseEntityObject;

public interface BaseMapper<T extends BaseEntityObject, PK extends java.io.Serializable> {

	void insert(T model);

	boolean delete(PK modelPK);
	
	T load(PK modelPK);
	
	boolean update(T model);

	boolean updateSelective(T model);
	
	int countAll();
	
	List<PK> findAllIds();	
}
