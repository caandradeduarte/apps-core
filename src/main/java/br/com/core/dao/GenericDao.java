package br.com.core.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author Caio Duarte <ca.andrade.duarte@gmail.com>
 * 
 * @param <PrimaryKey>
 *            Type of primary key.
 * @param <Entity>
 *            Entity.
 */
public interface GenericDao<PrimaryKey, Entity> {

	/**
	 * Returns the entity by its id (primary key)
	 * 
	 * @see {@link EntityManager#find(Class, Object)}
	 * 
	 * @param id
	 * @return
	 */
	Entity getById(PrimaryKey id);

	/**
	 * If the entity has id it persists, if not, it merges.
	 * 
	 * @see {@link EntityManager#persist(Object)}
	 * @see {@link EntityManager#merge(Object)}
	 * 
	 * @param entity
	 */
	void save(Entity entity);

	/**
	 * @see {@link EntityManager#refresh(Object)}
	 * 
	 * @param entity
	 */
	void refresh(Entity entity);

	/**
	 * @see {@link EntityManager#remove(Object)}
	 * 
	 * @param entity
	 */
	void remove(Entity entity);

	/**
	 * Saves all members of the list.
	 * @see {@link #save(Object)}
	 * 
	 * @param entities
	 */
	void saveAll(List<Entity> entities);

}
