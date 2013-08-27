package br.com.core.dao;

import javax.persistence.EntityManager;


public class DummyGenericDaoImpl extends GenericDaoImpl<Integer, DummyEntity> implements
		DummyGenericDao {

	@Override
	public EntityManager getEntityManager() {
		return super.getEntityManager();
	}
	
}
