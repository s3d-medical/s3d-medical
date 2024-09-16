package com.s3d.tech.data.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface GenericDao<T, ID extends Serializable> {

	/**
	 * Save new entity
	 * 
	 * @param entity entity object
	 * @return the entity's ID
	 */
	public ID add(T entity);

	/**
	 * update entity
	 * 
	 * @param entity entity object
	 */
	public void update(T entity);

	/**
	 * delete entity
	 * 
	 * @param entity entity object
	 */
	public void delete(T entity);

	/**
	 * delete entity by id
	 * 
	 * @param id entity id
	 */
	public void delete(ID id);

	/**
	 * Get all entities
	 * 
	 * @return entity list
	 */
	public List<T> getAll();

	/**
	 * Get the entity by id
	 * 
	 * @param id entity id
	 * @return entity entity object
	 */
	public T get(ID id);

    /**
     * save or update entity
     *
     * @param entity entity object
     */
    public void saveOrUpdate(final T entity);

    public Set<T> getSetByIds(List<ID> ids);

    public List<T> getListByIds(List<ID> ids);

    public void saveOrUpdate(final List<T> entities);

}
