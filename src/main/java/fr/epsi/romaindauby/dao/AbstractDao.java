package fr.epsi.romaindauby.dao;

import java.io.Serializable;
import java.util.List;

import fr.epsi.romaindauby.common.HibernateSessionUtils;


public abstract class AbstractDao<T, PK extends Serializable> extends HibernateSessionUtils implements Dao<T, PK> {

	/**
	 * Find an object by PK
	 */
	@SuppressWarnings("unchecked")
	public T find(Class<T> c, PK id) {
		return (T) getHibernateTemplate().get(c, id);
	}

	/**
	 * Find all objects
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> c) {
		return getHibernateTemplate().find("from " + c.getCanonicalName());
	}

	/**
	 * Save an object
	 */
	@SuppressWarnings("unchecked")
	public PK save(T obj) {
		return (PK) getHibernateTemplate().save(obj);
	}

	/**
	 * Update an object
	 */
	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}

	/**
	 * Delete an object
	 */
	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}

}