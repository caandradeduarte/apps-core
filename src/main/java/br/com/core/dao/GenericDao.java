package br.com.core.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.core.entity.Entity;

/**
 * @author Caio Duarte <ca.andrade.duarte@gmail.com>
 * 
 * @param <K>
 *            Type of primary key.
 * @param <E>
 *            Entity.
 */
public interface GenericDao<K, E extends Entity<K>> {

	/**
	 * Returns the entity by its id (primary key)
	 * 
	 * @see {@link EntityManager#find(Class, Object)}
	 * 
	 * @param id
	 * @return
	 */
	E getById(K id);

	/**
	 * If the entity has id it persists, if not, it merges.
	 * 
	 * @see {@link EntityManager#persist(Object)}
	 * @see {@link EntityManager#merge(Object)}
	 * 
	 * @param entity
	 */
	void save(E entity);

	/**
	 * @see {@link EntityManager#refresh(Object)}
	 * 
	 * @param entity
	 */
	void refresh(E entity);

	/**
	 * @see {@link EntityManager#remove(Object)}
	 * 
	 * @param entity
	 */
	void remove(E entity);

	/**
	 * Saves all members of the list.
	 * @see {@link #save(Object)}
	 * 
	 * @param entities
	 */
	void saveAll(List<E> entities);

}
