package by.scand.coffeeshop.dao.buyer;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Buyer;

@Repository
public class BuyerDaoImpl extends BaseDao implements BuyerDao {

	@Override
	public int addOne(Buyer buyer) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(buyer);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return buyer.getId();
	}
}
