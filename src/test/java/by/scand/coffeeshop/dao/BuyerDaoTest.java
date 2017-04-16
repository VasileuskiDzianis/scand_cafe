package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.domain.Buyer;

public class BuyerDaoTest {

	@Ignore
	@Test
	public void testAddOneBuyer() throws DaoException {
		Buyer buyer = new Buyer(1,"Тест","Тест","Тест","Тест");
		BuyerDao dao = new BuyerDao();
		assertNotSame(0, dao.addOne(buyer));
		
	}

}
