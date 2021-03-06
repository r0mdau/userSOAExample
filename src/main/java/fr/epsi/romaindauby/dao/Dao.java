package fr.epsi.romaindauby.dao;

import java.io.Serializable;


public interface Dao<T, PK extends Serializable> {

	/**
	 * Find an object identified by an ID
	 *
	 * @param id
	 * @return
	 */
	public T find(Class<T> c, PK id);

	/**
	 * Save an object in the data source
	 *
	 * @param obj
	 */
	public PK save(T obj);

	/**
	 * Update an object present in the data source
	 * 
	 * @return
	 */
	public void update(T obj);

	/**
	 * Delete an object from the data source
	 *
	 * @param obj
	 */
	public void delete(T obj);

}