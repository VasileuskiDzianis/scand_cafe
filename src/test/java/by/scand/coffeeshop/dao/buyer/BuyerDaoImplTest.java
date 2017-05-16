package by.scand.coffeeshop.dao.buyer;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.dao.buyer.BuyerDao;
import by.scand.coffeeshop.dao.buyer.BuyerDaoImpl;
import by.scand.coffeeshop.domain.Buyer;

public class BuyerDaoImplTest {

	@Ignore
	@Test
	public void testAddOneBuyer(){
		Buyer buyer = new Buyer();
		buyer.setId(1);
		buyer.setFirstName("Test");
		buyer.setLastName("Test");
		buyer.setPatronymic("Test");
		buyer.setAddress("Test");
		BuyerDao dao = new BuyerDaoImpl();
		assertNotSame(0, dao.addOne(buyer));
		
	}

}
