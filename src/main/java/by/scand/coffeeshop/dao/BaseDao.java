package by.scand.coffeeshop.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public abstract class BaseDao {

	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
}
