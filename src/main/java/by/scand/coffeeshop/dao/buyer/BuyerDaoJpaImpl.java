package by.scand.coffeeshop.dao.buyer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Buyer;

@Repository
public class BuyerDaoJpaImpl extends BaseDao implements BuyerDao {

	@Override
	public int addOne(Buyer buyer) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("by.scand.coffeeshop.jpa.hibernate");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(buyer);
		entityManager.getTransaction().commit();
		entityManager.close();

		return buyer.getId();
	}
}
