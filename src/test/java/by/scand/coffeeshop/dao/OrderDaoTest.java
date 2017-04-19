package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.domain.BusinessRulesImpl;
import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.DomainException;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;

public class OrderDaoTest {
	private Order order;
	private OrderItemDao orderItemDao = new OrderItemDao();
	private BuyerDao buyerDao = new BuyerDao();
	private Buyer buyer = new Buyer(0,"Test","Test","Test","Test");
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private OrderDao orderDao;
	
	@Ignore
	@Test
	public void testAddOneOrder() throws DaoException, DomainException {
		order = new Order();
		order.setBusinessRules(new BusinessRulesImpl(5,200,1000));
		order.addItem(goods1, 5);
		order.setBuyer(buyer);
		order.setDate(new Date());
		order.summ();
		
		orderDao = new OrderDao();
		orderDao.setBuyerDao(buyerDao);
		orderDao.setOrderItemDao(orderItemDao);
		
		assertNotSame(0,orderDao.addOne(order));
		
		
		
	}

}
