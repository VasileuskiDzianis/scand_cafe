package by.scand.coffeeshop.dao.goods;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.scand.coffeeshop.dao.goods.GoodsDaoImpl;
import by.scand.coffeeshop.domain.Goods;

public class GoodsDaoImplTest {
	private static EntityManagerFactory entityManagerFactory;
	private GoodsDaoImpl goodsDao;

	@BeforeClass
	public static void createEntityManagerFactory() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("by.scand.coffeeshop.jpa.hibernate");
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		
		entityManagerFactory.close();
	}
	
	@Before
	public void initializeGoodsDao(){
		goodsDao = new GoodsDaoImpl();
		
		goodsDao.setEntityManagerFactory(entityManagerFactory);
	}

	@Test
	public void testGetOneById() {
		Goods goods = goodsDao.getOneById(1);

		assertEquals(1, goods.getId());
		assertEquals("Test Coffee Sort 1", goods.getName().get("en"));
		assertEquals(50, goods.getPrice());
		assertEquals('Y', goods.getDisabled());
	}

	@Test
	public void testGetAll() {
		List<Goods> goodsList;

		goodsList = goodsDao.getAll();

		assertEquals(7, goodsList.size());
	}

}
