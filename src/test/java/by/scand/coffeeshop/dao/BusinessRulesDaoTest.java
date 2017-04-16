package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.domain.BusinessRulesImpl;

public class BusinessRulesDaoTest {

	@Test
	public void testGetOneInt() throws DaoException {
		BusinessRulesDao brDao = new BusinessRulesDao();
		BusinessRulesImpl brImpl;
		brImpl = (BusinessRulesImpl)brDao.getOne(0);
		assertEquals(200, brImpl.getDeliveryCost());
		
		assertEquals(5, brImpl.getEachNCupFree());
		assertEquals(1000, brImpl.getFreeDeliveryBorder());
		
	}

}
