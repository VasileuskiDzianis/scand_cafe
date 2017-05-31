package by.scand.coffeeshop.service.discount;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceImplTest {
	@Mock
	private DiscountDao discountDao;
	@InjectMocks
	private DiscountServiceImpl discountService = new DiscountServiceImpl();;
	private Goods goods1;
	private Goods goods2;
	private Goods goods3;
	private Goods goods4;
	private OrderItem orderItem1;
	private OrderItem orderItem2;
	private OrderItem orderItem3;
	private OrderItem orderItem4;
	
	@Before
	public void orderItemsInit(){
		goods1 = new Goods();
		goods2 = new Goods();
		goods3 = new Goods();
		goods4 = new Goods();
		goods1.setPrice(150);
		goods2.setPrice(200);
		goods3.setPrice(100);
		goods4.setPrice(150);
		orderItem1 = new OrderItem(goods1, 1);
		orderItem2 = new OrderItem(goods2, 1);
		orderItem3 = new OrderItem(goods3, 1);
		orderItem4 = new OrderItem(goods4, 11);
	}

	@Test
	public void testCalcDiscount(){
		int nuberOfFreeCup = 5;
		List<OrderItem> items = new ArrayList<OrderItem>(Arrays.asList(orderItem1, orderItem2, orderItem3));
		
		when(discountDao.getNumberOfFreeCup()).thenReturn(nuberOfFreeCup);
				
		int result = discountService.calculateDiscount(items);
		
		assertEquals(0, result);
		
		items.add(orderItem4);
		result = discountService.calculateDiscount(items);
		
		// discount should be: 2*(-150)
		assertEquals(-300, result);
	}
}