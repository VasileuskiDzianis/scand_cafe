package by.scand.coffeeshop.service.orderitem;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;

public class OrderItemServiceTest {
	private OrderItem orderItem;
	private OrderItemService orderItemService;
	
	@Test
	public void testGetPrice(){
		Goods goods = new Goods();
		goods.setPrice(199);
		
		orderItem = new OrderItem(goods,3);
		orderItemService = new OrderItemServiceImpl();
		
		assertEquals(3*199, orderItemService.getOrderItemCost(orderItem));
	}
}
