package com.s3d.webapps.common.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.s3d.webapps.common.entity.EntityObject;
import com.s3d.webapps.component.db.Page;

/**
 * 描述了常用的CRUD以及查询等方法的接口，建议大部分的Dao接口继承。<br>
 * 详细方法请参阅{@link IDaoServiceCommon IDaoServiceCommon}<br>
 * 注意：要继承该类，必须<br>
 * <li>对应的model继承类{@link com.s3d.webapps.common.model.IBaseModel IBaseModel}；</li>
 * 作用范围：所有Dao层代码，作为基类继承。
 * 
 * @see BaseDaoImp
 * @author s3d
 * @version 1.0 2006-04-02
 */
public interface IBaseDao {
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
	public abstract EntityObject findByPrimaryKey(String id) ;

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
	public abstract EntityObject findByPrimaryKey(String id, Object modelInfo,
			boolean noLazy) ;

	/**
	 * 根据主键数组查找记录列表。
	 * 
	 * @param ids
	 * @return model对象列表
	 * @
	 */
	public abstract List findByPrimaryKeys(String[] ids) ;

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
	public abstract List findList(String whereBlock, String orderBy)
			;

	/**
	 * 根据条件查找记录，并返回model对象列表。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param hqlInfo
	 *            HQL配置信息
	 * @return model对象列表
	 * @
	 */
	public abstract Page findPage(HQLInfo hqlInfo) ;

	/**
	 * 根据条件查找记录，并以页面对象返回。<br>
	 * 建议在实际业务逻辑的实现中调用本方法，然后再提供给其他地方使用。
	 * 
	 * @param whereBlock
	 *            where的条件（见{@link IHQLInfo#setWhereBlock(java.lang.String)
	 *            IHQLInfo.setWhereBlock(java.lang.String)}）
	 * @param orderBy
	 *            排序列（见{@link IHQLInfo#setOrderBy(java.lang.String)
	 *            IHQLInfo.setOrderBy(java.lang.String)}）
	 * @param pageno
	 *            第几页
	 * @param rowsize
	 *            每页多少行
	 * @return 页面对象
	 * @
	 */
	public abstract Page findPage(String whereBlock, String orderBy,
			int pageno, int rowsize) ;

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
	 * @return HibernateTemplate
	 */
	public abstract HibernateTemplate getHibernateTemplate();

	/**
	 * @deprecated  会有session close问题,建议使用 getHibernateTemplate().execute(new HibernateCallback() { ....  的方式
	 * @return HibernateSession
	 */
	public abstract Session getHibernateSession();

	public abstract boolean isExist(String modelName, String fdId)
			;

	public Iterator findValueIterator(HQLInfo hqlInfo) ;

	/**
	 * 通过迭代器回调 处理查询的方法，该方法中会自动回收缓存
	 * 
	 * @author 李勇
	 * @param hqlInfo
	 * @param callBack
	 * @param isClear
	 *            是否清空session
	 */
	public void findValueIterator(HQLInfo hqlInfo, boolean isClear,
			IteratorCallBack callBack) ;

}
