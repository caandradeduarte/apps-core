package br.com.core.dao;

import javax.persistence.EntityManager;

public interface DummyGenericDao extends GenericDao<Integer, DummyEntity> {

	EntityManager getEntityManager();

}
