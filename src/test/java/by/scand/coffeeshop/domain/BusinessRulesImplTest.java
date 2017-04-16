package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.domain.BusinessRules;
import by.scand.coffeeshop.domain.BusinessRulesImpl;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;

public class BusinessRulesImplTest{
	private BusinessRules discount = new BusinessRulesImpl(5,200,1000);
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private Goods goods3 = new Goods(3, "Coffe sort 3", 100, 'N');
	private Goods goods4 = new Goods(4, "Coffe sort 4", 150, 'N');
	private OrderItem orderItem1 = new OrderItem(goods1,1);
	private OrderItem orderItem2 = new OrderItem(goods2,1);
	private OrderItem orderItem3 = new OrderItem(goods3,1);
	private OrderItem orderItem4 = new OrderItem(goods4,11);
	
	
	@Test
		public void calcDiscountTest() {
		
		List<OrderItem> items = new ArrayList<OrderItem>(Arrays.asList(orderItem1,orderItem2,orderItem3));
		assertEquals(0, discount.calcDiscount(items));
		items.add(orderItem4);
		//discount should be: 2*(-150)
		assertEquals(-300, discount.calcDiscount(items));
	}
	@Test
	public void calcDeliveryTest() {
		List<OrderItem> items = new ArrayList<OrderItem>(Arrays.asList(orderItem1,orderItem2,orderItem3));
		//order sum less then delivery should be 200
		assertEquals(200, discount.calcDelivery(items));
		items.add(orderItem4);
		//order sum more then 1000, delivery - free
		assertEquals(0, discount.calcDelivery(items));
		
	}
	

}
