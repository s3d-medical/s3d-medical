package com.s3d.tech.data.dao.hibernate;

import com.s3d.tech.data.dao.GenericDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * @author  wind.chen
 * @date 2014-05-14
 * @param <T>
 * @param <ID>
 */
@SuppressWarnings("unchecked")
public class HibernateDao <T, ID extends Serializable> implements GenericDao<T, ID>{

	protected final Log logger = LogFactory.getLog(getClass());
	protected SessionFactory sessionFactory;
	protected Class<T> entityClass;
	private HibernateTemplate hibernateTemplate ;
	
	/**
	 * HibernateDao Constructor, set entityClass
	 */
	public HibernateDao() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * HibernateDao Constructor
	 * 
	 * @param sessionFactory Hibernate sessionFactory
	 * @param entityClass clazz for <T>
	 */
	public HibernateDao(final SessionFactory sessionFactory, final Class<T> entityClass) {
		this.sessionFactory = sessionFactory;
		this.entityClass = entityClass;
		
	}

	/**
	 * Get sessionFactory.
	 * 
	 * @return Hibernate sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Auto inject sessionFactory by "@Autowired"
	 * 
	 * @param sessionFactory Hibernate sessionFactory
	 */
    @Autowired
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.hibernateTemplate = new HibernateTemplate(this.sessionFactory,true);
	}

	/**
	 * Get current session.
	 * 
	 * @return current session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	// -- Basic CRUD Function --//

	/**
	 * Save new entity
	 * 
	 * @param entity entity object
	 * @return saved entity's id
	 */
	public ID add( T entity) {
		Assert.notNull(entity, "entity must not be null");
		ID id = (ID) getSession().save(entity);
		getSession().flush();
		return id;
	}

	/**
	 * Update entity
	 * 
	 * @param entity updated entity object
	 */
	public void update(final T entity) {
		Assert.notNull(entity, "entity must not be null");
		getSession().update(entity);
		getSession().flush();
	}

	/**
	 * Save or update object
	 * 
	 * @param entity entity object
	 */
	public void saveOrUpdate(final T entity) {
		Assert.notNull(entity, "entity must not be null");
		getSession().saveOrUpdate(entity);
		getSession().flush();
	}

    public void saveOrUpdate(final List<T> entities) {
        Assert.notNull(entities, "entity must not be null");
        for(int i =0 ; i< entities.size(); i ++){
            getSession().saveOrUpdate(entities.get(i));
        }
        getSession().flush();
    }

    /**
	 * Delete entity
	 * 
	 * @param entity entity object
	 */
	public void delete(final T entity) {
		Assert.notNull(entity, "entity must not be null");
		if (null != entity) {
			getSession().delete(entity);
			getSession().flush();
		}
	}

	/**
	 * Delete entity by id
	 * 
	 * @param id entity id
	 */
	public void delete(final ID id) {
		Assert.notNull(id, "id must not be null");
		T obj = get(id);
		if (null != obj) {
			delete(obj);
		}
	}

	/**
	 * Get object by id
	 * 
	 * @param id entity id
	 * @return entity
	 */
	public T get(final ID id) {
		Assert.notNull(id, "id must not be null");
		return (T) getSession().get(entityClass, id);
	}

	/**
	 * Load object by id
	 * 
	 * @param id entity id
	 * @return entity
	 */
	public T load(final ID id) {
		Assert.notNull(id, "id must not be null");
		return (T) getSession().load(entityClass, id);
	}

	/**
	 * Get all entities
	 * 
	 * @return entity list
	 */
	public List<T> getAll() {
		return get();
	}

	/**
	 * Get all objects by order
	 * 
	 * @param orderBy order by column
	 * @param isAsc order is asc or not
	 * @return entity list
	 */
	public List<T> getAll(String orderBy, boolean isAsc) {
		Criteria c = createCriteria();
		if (isAsc) {
			c.addOrder(Order.asc(orderBy));
		} else {
			c.addOrder(Order.desc(orderBy));
		}
		return c.list();
	}

	/**
	 * Get objects by ids
	 * 
	 * @param ids entities' id list
	 * @return entity list
	 */
	public List<T> getByIds(List<ID> ids) {
        if(ids == null || ids.isEmpty()){
            return new ArrayList<T>(0);
        }
		return get(Restrictions.in(getIdName(), ids));
	}
    public Set<T> getSetByIds(List<ID> ids){
        List<T> list = this.getByIds(ids);
        Set<T> set = new HashSet<T>();
        if(list != null && !list.isEmpty()){
            set.addAll(list);
        }
        return set;
    }

    public List<T> getListByIds(List<ID> ids){
        return this.getByIds(ids);
    }
	/**
	 * Query by HQL
	 * 
	 * @param hql HQL query string
	 * @param <X> any conent in list
	 * @param values HQL parameters
	 * @return list which meets HQL query
	 */
	public <X> List<X> get(final String hql, final Object... values) {
		return createQuery(hql, values).list();
	}

	/**
	 * Query by HQL
	 * 
	 * @param hql HQL query string
	 * @param values named HQL parameters
	 * @param <X> any object in list
	 * @return list which meets HQL query
	 */
	public <X> List<X> get(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).list();
	}

	/**
	 * Get objects by criteria
	 * 
	 * @param criterions Criterions
	 * @return entity objects
	 */
	public List<T> get(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/**
	 * Query by sql
	 * @param sql
	 * @param params
	 * @return
	 */
	protected List<T> sqlList(String sql, Map<String, Object> params) {
		SQLQuery query = getSession().createSQLQuery(sql);
		Set<String> paramNames = params.keySet();
		for (String name : paramNames) {
			query.setParameter(name, params.get(name));
		}
		query.addEntity(entityClass);
		return query.list();
	}

	/**
	 * Query unique object by HQL
	 * 
	 * @param hql HQL query string
	 * @param <X> any object
	 * @param values HQL parameters
	 * @return unique object which meets HQL query
	 */
	public <X> X getUnique(final String hql, final Object... values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * Query unique object by HQL
	 * 
	 * @param hql HQL query string
	 * @param <X> any object
	 * @param values HQL named parameters
	 * @return unique object which meets HQL query
	 */
	public <X> X getUnique(final String hql, final Map<String, ?> values) {
		return (X) createQuery(hql, values).uniqueResult();
	}

	/**
	 * Execute batch HQL update/delete operation
	 * 
	 * @param hql HQL query string
	 * @param values HQL parameters
	 * @return effected records number
	 */
	public int batchExecute(final String hql, final Object... values) {
		return createQuery(hql, values).executeUpdate();
	}

	/**
	 * Execute batch HQL update/delete operation
	 * 
	 * @param hql HQL query string
	 * @param values HQL named parameters
	 * @return effected records number
	 */
	public int batchExecute(final String hql, final Map<String, ?> values) {
		return createQuery(hql, values).executeUpdate();
	}

	/**
	 * Create query object
	 * 
	 * @param queryString HQL query string
	 * @param values HQL parameters
	 * @return Query object
	 */
	public Query createQuery(final String queryString, final Object... values) {
		Assert.hasText(queryString, "queryString must not be null");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query;
	}

	/**
	 * Create query object
	 * 
	 * @param queryString HQL query string
	 * @param values HQL named parameters
	 * @return Query object
	 */
	public Query createQuery(final String queryString, final Map<String, ?> values) {
		Assert.hasText(queryString, "queryString must not be null");
		Query query = getSession().createQuery(queryString);
		if (values != null) {
			query.setProperties(values);
		}
		return query;
	}

	/**
	 * Get unique object by criteria
	 * 
	 * @param criterions Criterions
	 * @return unique entity
	 */
	public T getUnique(final Criterion... criterions) {
		return (T) createCriteria(criterions).uniqueResult();
	}

	/**
	 * Construct Criteria
	 * 
	 * @param criterions Criterions
	 * @return Criteria object
	 */
	public Criteria createCriteria(final Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	/**
	 * Get primary key's name
	 * 
	 * @return primary key's name
	 */
	public String getIdName() {
		ClassMetadata meta = getSessionFactory().getClassMetadata(entityClass);
		return meta.getIdentifierPropertyName();
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
