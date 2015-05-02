package com.s3d.webapps.common.service;

import java.util.List;

import com.s3d.webapps.common.dao.HQLInfo;
import com.s3d.webapps.common.dao.IBaseDao;
import com.s3d.webapps.common.dao.ISpringJDbcDao;
import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.component.db.Page;

public interface BaseServiceMgr {
	
	/**
	 * @return Dao采用的域模型
	 */
	public abstract String getModelName();

	/**
	 * 将记录更新到数据库中。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract String add(EntityObject modelObj) ;

	/**
	 * 根据model对象从数据库中删除记录。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract void delete(EntityObject modelObj) ;

	/**
	 * 刷新Hibernate的Session
	 */
	public void flushHibernateSession();

	/**
	 * 清空Hibernate的Session
	 * 
	 */
	public void clearHibernateSession();

	/**
	 * 根据主键查找记录。
	 * 
	 * @param id
	 * @return model对象
	 * @
	 */
	public abstract <R extends EntityObject>  R findByPrimaryKey(String id) ;

	/**
	 * 根据主键查找记录
	 * 
	 * @param id
	 * @param modelInfo
	 *            域模型信息，可以是域模型的Class，也可以是域模型的全称，若值为null则取xml配置的信息
	 * @param noLazy
	 *            为true则强制从数据库中读取，不做性能优化
	 * @return
	 * @
	 */
	public abstract <R extends EntityObject> R findByPrimaryKey(String id, Object modelInfo,
			boolean noLazy) ;

	/**
	 * 根据主键数组查找记录列表。
	 * 
	 * @param ids
	 * @return model对象列表
	 * @
	 */
	public abstract List<EntityObject> findByPrimaryKeys(String[] ids) ;

	/**
	 * 根据条件查找记录，并返回model对象列表。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param hqlInfo
	 *            HQL的配置信息
	 * @return model对象列表
	 * @
	 */
	public abstract List findList(HQLInfo hqlInfo) ;

	/**
	 * 根据条件查找记录，并返回model对象列表。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param whereBlock
	 *            where的条件（见{@link IHQLInfo#setWhereBlock(java.lang.String)
	 *            IHQLInfo.setWhereBlock(java.lang.String)}）
	 * @param orderBy
	 *            排序列（见{@link IHQLInfo#setOrderBy(java.lang.String)
	 *            IHQLInfo.setOrderBy(java.lang.String)}）
	 * @return model对象列表
	 * @
	 */
	public abstract List findList(String whereBlock, String orderBy);


	/**
	 * 根据条件查找记录，并返回指定的值。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param hqlInfo
	 *            HQL配置信息
	 * @return 当selectBlock设置的是单个值，则返回由该值组成的List，若设置了多个值，则先由这多个值组成一个数组：Object[]，
	 *         再返回这个数组的List
	 * @
	 */
	public abstract List findValue(HQLInfo hqlInfo) ;

	/**
	 * 根据条件查找记录，并返回指定的值。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param selectBlock
	 *            返回值（见{@link IHQLInfo#setSelectBlock(java.lang.String)
	 *            IHQLInfo.setSelectBlock(java.lang.String)}）
	 * @param whereBlock
	 *            where的条件（见{@link IHQLInfo#setWhereBlock(java.lang.String)
	 *            IHQLInfo.setWhereBlock(java.lang.String)}）
	 * @param orderBy
	 *            排序列（见{@link IHQLInfo#setOrderBy(java.lang.String)
	 *            IHQLInfo.setOrderBy(java.lang.String)}）
	 * @return 当selectBlock设置的是单个值，则返回由该值组成的List，若设置了多个值，则先由这多个值组成一个数组：Object[]，
	 *         再返回这个数组的List
	 * @
	 */
	public abstract List findValue(String selectBlock, String whereBlock,
			String orderBy) ;

	/**
	 * 将记录更新到数据库中。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract void update(EntityObject modelObj) ;

	/**
	 * 根据记录ID从数据库中删除记录。
	 * 
	 * @param id
	 * @
	 */
	public abstract void delete(String id) ;

	/**
	 * 根据ID数组从数据库中批量删除记录。
	 * 
	 * @param ids
	 * @
	 */
	public abstract void delete(String[] ids) ;

	/**
	 * 获取BaseDao。
	 * 
	 * @return
	 * @
	 */
	public abstract IBaseDao getBaseDao() ;
	
	/**
	 * 获取SpringJDbcDao。
	 * 
	 * @return
	 * @
	 */
	public abstract ISpringJDbcDao getSpringJDbcDao() ;
	
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

	/**
	 * 将记录更新到数据库中。
	 * 
	 * @param modelObj
	 *            model对象
	 * @
	 */
	public abstract void updateUsingJdbc(EntityObject modelObj) ;
	
	public abstract EntityObject findById(String id) ;

	public abstract Page findPage(HQLInfo hqlInfo);
	
}
