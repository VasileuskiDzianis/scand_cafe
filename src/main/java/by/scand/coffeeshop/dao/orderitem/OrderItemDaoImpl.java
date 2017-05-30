package by.scand.coffeeshop.dao.orderitem;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.OrderItem;

@Repository
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

	@Override
	public void addAll(List<OrderItem> orderItems) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		for (OrderItem orderItem : orderItems) {
			entityManager.persist(orderItem);
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
