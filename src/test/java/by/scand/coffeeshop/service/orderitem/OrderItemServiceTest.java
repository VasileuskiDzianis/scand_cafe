package by.scand.coffeeshop.service.orderitem;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.ServiceException;

public class OrderItemServiceTest {
	private OrderItem orderItem;
	private OrderItemService orderItemService;
	@Test
	public void testGetPrice() throws ServiceException {
		orderItem = new OrderItem();
		Goods goods = new Goods();
		goods.setPrice(199);
		orderItem.setAmount(3);
		orderItem.setGoods(goods);
		orderItemService = new OrderItemServiceImpl();
		assertEquals(3*199, orderItemService.getPrice(orderItem));
	}
}
