package by.scand.coffeeshop.dao.goods;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.domain.Goods;

@Repository
public class GoodsDaoImpl extends BaseDao implements GoodsDao {

	@Override
	public Goods getOneById(int id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Goods goods = entityManager.find(Goods.class, id);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return goods;
	}

	@Override
	public List<Goods> getAll() {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		List<Goods> goodsList = entityManager.createQuery("from Goods where disabled = \'N\'", Goods.class).getResultList();
		
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return goodsList;
	}
}