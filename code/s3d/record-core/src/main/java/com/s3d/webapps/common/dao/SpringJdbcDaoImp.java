package com.s3d.webapps.common.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.util.HibernateConfigurationHelper;


public class SpringJdbcDaoImp extends JdbcDaoSupport  implements ISpringJDbcDao ,ApplicationContextAware{
	
	protected ApplicationContext applicationContext;
	
	protected RowMapper rowMapper;
	
	private String modelName;

	private String tableName;
	
	private Map<String, String> tableColmunMap;
	
	protected Map<String,Object> cache=new HashMap<String, Object>();
	
	public String getRowMapperSql(){
		return "select * from "+this.getTableName()+" where fd_id=? ";
	}
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public RowMapper getRowMapper() {
		return rowMapper;
	}

	public void setRowMapper(RowMapper rowMapper) {
		this.rowMapper = rowMapper;
	}

	public String getTableName() {
		if(this.tableName ==null){
			try {
				this.tableName = HibernateConfigurationHelper.getTableName(Class.forName(this.modelName));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return tableName;
	}

	
	public String getTableColmunName(String property) {
		if(this.tableColmunMap==null)
			this.tableColmunMap = new HashMap<String, String>();
		if(this.tableColmunMap.get(property)!=null)
			return this.tableColmunMap.get(property);
		String colname;
		try {
			colname = HibernateConfigurationHelper.getColumnName(Class.forName(this.modelName), property);
			if(StringUtils.isEmpty(colname)){
				this.tableColmunMap.put(property,colname);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		return colname;
	}

	public void updateUsingJdbc(EntityObject modelObj)  {
		modelObj.recalculateFields();
		this.cache.put(modelObj.getFdId(), modelObj);
	}

	public String addUsingJdbc(EntityObject modelObj)  {
		modelObj.recalculateFields();
		this.cache.put(modelObj.getFdId(), modelObj);
		return null;
	}

	public void deleteUsingJdbc(EntityObject modelObj)  {
		modelObj.recalculateFields();
		String sql = "DELETE FROM " + this.getTableName() + " WHERE fd_id=?";
		Object[] paramValues = { modelObj.getFdId() };
		this.getJdbcTemplate().update(sql, paramValues);
		this.cache.remove(modelObj.getFdId());
	}
	
	public void saveOnNotExsits(EntityObject modelObj)  {
		if(! this.isRecordExist(modelObj.getFdId())){
			this.addUsingJdbc(modelObj);
		}		
	}

	public boolean isRecordExist(String fdId)  {
		if(cache==null)
			cache=new HashMap<String, Object>();
		if(cache.get(fdId)!=null)
			return true;
	
		Object [] paras = {fdId};
		Object obj;
		try {
			obj = getJdbcTemplate().queryForObject(this.getRowMapperSql(),paras,this.getRowMapper());
		} catch (EmptyResultDataAccessException e) {
			obj = null;
		}
		if(obj!=null){
			cache.put(fdId,obj);
			return true;
		}			
		return false;
	}

	public EntityObject findById(String fdId)  {
		if(isRecordExist(fdId))
			return (EntityObject)cache.get(fdId);

		return null;
	}

	/**
	 * 设置spring提供的applicationContext（spring自动调用）。
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
