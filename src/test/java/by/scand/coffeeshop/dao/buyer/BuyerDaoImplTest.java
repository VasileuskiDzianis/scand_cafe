package by.scand.coffeeshop.dao.buyer;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.dao.buyer.BuyerDao;
import by.scand.coffeeshop.dao.buyer.BuyerDaoImpl;
import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.exception.DaoException;

public class BuyerDaoImplTest {

	@Ignore
	@Test
	public void testAddOneBuyer() throws DaoException {
		Buyer buyer = new Buyer(1,"Тест","Тест","Тест","Тест");
		BuyerDao dao = new BuyerDaoImpl();
		assertNotSame(0, dao.addOne(buyer));
		
	}

}
