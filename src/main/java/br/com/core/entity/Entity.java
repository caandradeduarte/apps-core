package br.com.core.entity;

import java.io.Serializable;

/**
 * Entities that extend this must implement an method getId returning its
 * primary key and also must implement an equals method.
 * 
 * @author Caio Duarte <ca.andrade.duarte@gmail.com>
 * 
 * @param <K>
 *            Type of Primary Key.
 */
public abstract class Entity<K> implements Serializable {

	private static final long serialVersionUID = 518862612780819591L;

	public abstract K getId();

	public abstract boolean equals();

}
