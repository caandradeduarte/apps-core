package br.com.core.dao;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.util.ReflectionUtils;

import br.com.core.entity.Entity;

/**
 * <p>
 * {@link GenericDao} implementation.
 * </p>
 * 
 * @author Caio Duarte <ca.andrade.duarte@gmail.com>
 * 
 * @param <K>
 * @param <E>
 */
public class GenericDaoImpl<K, E extends Entity<K>> implements GenericDao<K, E> {

	@PersistenceContext
	private EntityManager entityManager;

	protected Class<E> entityClass;

	/**
	 * returns the instantiated {@link EntityManager}.
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Default constructor.
	 */
	@SuppressWarnings("unchecked")
	public GenericDaoImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.core.dao.GenericDao#getById(java.lang.Object)
	 */
	public E getById(K id) {
		return entityManager.find(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.core.dao.GenericDao#save(java.lang.Object)
	 */
	public void save(E entity) {
		Method getId = ReflectionUtils.findMethod(entityClass, "getId");
		if (ReflectionUtils.invokeMethod(getId, entity) == null)
			entityManager.persist(entity);
		else
			entityManager.merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.core.dao.GenericDao#refresh(java.lang.Object)
	 */
	public void refresh(E entity) {
		entityManager.refresh(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.core.dao.GenericDao#remove(java.lang.Object)
	 */
	public void remove(E entity) {
		Method getId = ReflectionUtils.findMethod(entityClass, "getId");
		entityManager.remove(entityManager.getReference(entityClass,
				ReflectionUtils.invokeMethod(getId, entity)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.core.dao.GenericDao#saveAll(java.util.List)
	 */
	public void saveAll(List<E> entities) {
		for (E e : entities) {
			save(e);
		}
	}

}
