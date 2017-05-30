package by.scand.coffeeshop.dao.order;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Order;

@Repository
public class OrderDaoImpl extends BaseDao implements OrderDao {
		
	@Override
	public int addOne(Order order) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return order.getId();
	}
}