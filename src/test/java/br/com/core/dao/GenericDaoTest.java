package br.com.core.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GenericDaoTest {

	@Mock
	private EntityManager entityManager;

	@InjectMocks
	private DummyGenericDao dao = new DummyGenericDaoImpl();

	@Test
	public void testGetById() {
		dao.getById(1);
		verify(entityManager).find(eq(DummyEntity.class), anyInt());
	}

	@Test
	public void testSave() {
		dao.save(new DummyEntity());
		verify(entityManager).persist(any(DummyEntity.class));
		dao.save(new DummyEntity(1));
		verify(entityManager).merge(any(DummyEntity.class));
	}
	
	@Test
	public void testRefresh(){
		dao.refresh(new DummyEntity());
		verify(entityManager).refresh(any(DummyEntity.class));
	}
	
	@Test
	public void testRemove(){
		dao.remove(new DummyEntity(1));
		verify(entityManager).getReference(eq(DummyEntity.class), eq(1));
		verify(entityManager).remove(any(DummyEntity.class));
	}
	
	@Test
	public void testSaveAll(){
		dao.saveAll(Arrays.asList(new DummyEntity(), new DummyEntity()));
		verify(entityManager, times(2)).persist(any());
	}
	
	@Test
	public void testGetEntityManger(){
		assertNotNull(dao.getEntityManager());
	}
	
}
