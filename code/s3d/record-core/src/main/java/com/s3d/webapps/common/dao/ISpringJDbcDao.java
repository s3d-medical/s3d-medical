package com.s3d.webapps.common.dao;

import org.springframework.jdbc.core.RowMapper;

import com.s3d.webapps.common.entity.EntityObject;

public interface ISpringJDbcDao {
	
	/**
	 * @return Dao采用的域模型
	 */
	public abstract String getModelName();
	
	/**
	 * @return Dao采用的表名
	 */
	public abstract String getTableName();
	
	/**
	 * @return 列名
	 */
	public abstract String getTableColmunName(String property);
	
	/**
	 * 将记录更新到数据库中。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract String addUsingJdbc(EntityObject modelObj) ;

	/**
	 * 根据model对象从数据库中删除记录。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract void deleteUsingJdbc(EntityObject modelObj) ;
	
	public abstract EntityObject findById(String fdId) ;
	

	/**
	 * 将记录更新到数据库中。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract void updateUsingJdbc(EntityObject modelObj) ;
	
	public void saveOnNotExsits(EntityObject modelObj) ;

	public abstract boolean isRecordExist(String fdId)	;
	
	public RowMapper getRowMapper() ;
}
