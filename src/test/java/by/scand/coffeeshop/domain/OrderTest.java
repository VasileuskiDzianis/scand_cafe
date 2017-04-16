package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.dao.BusinessRulesDao;
import by.scand.coffeeshop.dao.BusinessRulesDaoMock;
import by.scand.coffeeshop.dao.DaoException;

public class OrderTest {
	private Order order;
	private BusinessRulesDao brDao = new BusinessRulesDaoMock();
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private Goods goods3 = new Goods(3, "Coffe sort 3", 100, 'N');
	private Goods goods4 = new Goods(4, "Coffe sort 4", 100, 'N');

	@Test
	public void testSumm() throws DaoException {
		
		
		order = new Order();
		order.setBusinessRulesDao(brDao);
		order.addItem(goods1, 1);
		order.addItem(goods2, 1);
		order.addItem(goods3, 1);
		//it should be calculated: 150*1 + 200*1 + 100*1 + 200(delivery)
		assertEquals(650, order.summ());
		
		order.addItem(goods4, 7);
		//it should be calculated: 150*1 + 200*1 + 100*1 + 7*100 +0(delivery) - 1*100(discount)
		assertEquals(1050, order.summ());
		
	}

}
