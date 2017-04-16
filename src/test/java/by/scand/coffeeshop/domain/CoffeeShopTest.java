package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import by.scand.coffeeshop.dao.OrderDaoMock;

public class CoffeeShopTest {

	@Test
	public void testBuyGoods() {
		
		
	}

	@Test
	public void testShowCatalog() {
		
	}

	@Test
	public void testConfirmOrder() {
		CoffeeShop coffeeShop = new CoffeeShop();
		OrderDaoMock orderDao = new OrderDaoMock();
		coffeeShop.setOrderDao(orderDao);
		coffeeShop.confirmOrder(new Buyer(), new Order());
	}

}
