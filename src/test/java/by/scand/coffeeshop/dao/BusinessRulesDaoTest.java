package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.domain.BusinessRulesImpl;
import by.scand.coffeeshop.domain.DomainException;

public class BusinessRulesDaoTest {

	@Test
	public void testRefreshRules() throws DaoException, DomainException {
		BusinessRulesDao brDao = new BusinessRulesDao();
		BusinessRulesImpl brImpl = new BusinessRulesImpl();
		brImpl.setBusinessRulesDao(brDao);
		brImpl.refreshRules();
		assertEquals(200, brImpl.getDeliveryCost());
		
		assertEquals(5, brImpl.getEachNCupFree());
		assertEquals(1000, brImpl.getFreeDeliveryBorder());
		
	}

}
