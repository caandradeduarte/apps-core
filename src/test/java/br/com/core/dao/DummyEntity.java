package br.com.core.dao;

import br.com.core.entity.Entity;

public class DummyEntity extends Entity<Integer> {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	public DummyEntity(){}
	
	public DummyEntity(Integer id){
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public boolean equals() {
		return false;
	}

}
