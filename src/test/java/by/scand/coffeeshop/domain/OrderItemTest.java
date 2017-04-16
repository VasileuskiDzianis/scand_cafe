package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;

public class OrderItemTest {
	private OrderItem orderItem;
	
	@Test
	public void getSumTest(){
		orderItem = new OrderItem();
		Goods goods = new Goods();
		goods.setPrice(199);
		orderItem.setAmount(3);
		orderItem.setGoods(goods);
		assertEquals(3*199,orderItem.getPrice());
	}
	
}
