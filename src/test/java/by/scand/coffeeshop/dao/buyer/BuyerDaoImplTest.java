package by.scand.coffeeshop.dao.buyer;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.scand.coffeeshop.dao.buyer.BuyerDaoImpl;
import by.scand.coffeeshop.domain.Buyer;

public class BuyerDaoImplTest {
	private static EntityManagerFactory entityManagerFactory;
	private BuyerDaoImpl buyerDao;

	@BeforeClass
	public static void createEntityManagerFactory() {

		entityManagerFactory = Persistence.createEntityManagerFactory("by.scand.coffeeshop.jpa.hibernate");
	}

	@AfterClass
	public static void closeEntityManagerFactory() {

		entityManagerFactory.close();
	}

	@Before
	public void initializeGoodsDao() {
		buyerDao = new BuyerDaoImpl();

		buyerDao.setEntityManagerFactory(entityManagerFactory);
	}

	// @Ignore
	@Test
	public void testAddOneBuyer() {
		Buyer buyer = new Buyer();
		buyer.setFirstName("Test");
		buyer.setLastName("Test");
		buyer.setPatronymic("Test");
		buyer.setAddress("Test");

		assertNotSame(0, buyerDao.addOne(buyer));
	}
}
