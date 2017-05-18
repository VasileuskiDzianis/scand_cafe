package by.scand.coffeeshop.service.order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.service.delivery.DeliveryService;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.orderitem.OrderItemService;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	private Goods goods = new Goods(1, "Coffe sort 1", 150, 'N');
	private OrderItem orderItem = new OrderItem(goods, 8);
	private Order order = new Order();
	@Mock
	private DeliveryService deliveryService;
	@Mock
	private DiscountService discountService;
	@Mock
	private OrderItemService orderItemService;
	@InjectMocks
	private OrderServiceImpl orderService = new OrderServiceImpl();

	@Before
	public void initialization() {
		
		order.setItems(new ArrayList<OrderItem>(Arrays.asList(orderItem)));
	}

	@Test
	public void testSum() {
		int costOfGoods = 8 * 150;
		int discount = -150;
		int delivery = 0;

		when(deliveryService.calculateDeliveryCost(costOfGoods)).thenReturn(delivery);
		when(discountService.calculateDiscount(order.getItems())).thenReturn(discount);
		when(orderItemService.getOrderItemCost(orderItem)).thenReturn(costOfGoods);

		// it should be calculated: 150*8 - 150(discount) + 0(delivery)
		assertEquals(1050, orderService.calculateOrderCost(order));
	}
}