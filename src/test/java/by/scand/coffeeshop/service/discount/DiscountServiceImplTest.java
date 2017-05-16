package by.scand.coffeeshop.service.discount;

import static org.junit.Assert.assertEquals;
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
	
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private Goods goods3 = new Goods(3, "Coffe sort 3", 100, 'N');
	private Goods goods4 = new Goods(4, "Coffe sort 4", 150, 'N');
	private OrderItem orderItem1 = new OrderItem(goods1, 1);
	private OrderItem orderItem2 = new OrderItem(goods2, 1);
	private OrderItem orderItem3 = new OrderItem(goods3, 1);
	private OrderItem orderItem4 = new OrderItem(goods4, 11);

	@Test
	public void testCalcDiscount(){
		
		int nuberOfFreeCup = 5;
		when(discountDao.getNumberOfFreeCup()).thenReturn(nuberOfFreeCup);
		List<OrderItem> items = new ArrayList<OrderItem>(Arrays.asList(orderItem1, orderItem2, orderItem3));
		
		int result = discountService.calcDiscount(items);
		assertEquals(0, result);
		
		items.add(orderItem4);
		result = discountService.calcDiscount(items);
		// discount should be: 2*(-150)
		assertEquals(-300, result);

	}

}
