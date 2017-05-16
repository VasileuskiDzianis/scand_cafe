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
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.dao.order.OrderDao;
import by.scand.coffeeshop.dao.order.OrderDaoImpl;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.service.delivery.DeliveryService;
import by.scand.coffeeshop.service.delivery.DeliveryServiceImpl;
import by.scand.coffeeshop.service.discount.DiscountService;
import by.scand.coffeeshop.service.discount.DiscountServiceImpl;
import by.scand.coffeeshop.service.orderitem.OrderItemService;
import by.scand.coffeeshop.service.orderitem.OrderItemServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	private Goods goods = new Goods(1, "Coffe sort 1", 150, 'N');
	private OrderItem orderItem = new OrderItem(goods, 8);

	@Mock
	private DeliveryService deliveryService;
	@Mock
	private DiscountService discountService;
	@Mock
	private OrderItemService orderItemService;
	@InjectMocks
	private OrderServiceImpl orderService = new OrderServiceImpl();

	private Order order;

	@Before
	public void initialization() {
		order = new Order();
		order.setItems(new ArrayList<OrderItem>(Arrays.asList(orderItem)));
	}

	@Test
	public void testSum() {
		int costOfGoods = 8 * 150;
		int discount = -150;
		int delivery = 0;

		when(deliveryService.calcDelivery(costOfGoods)).thenReturn(delivery);
		when(discountService.calcDiscount(order.getItems())).thenReturn(discount);
		when(orderItemService.getPrice(orderItem)).thenReturn(costOfGoods);

		// it should be calculated: 150*8 - 150(discount) + 0(delivery)
		assertEquals(1050, orderService.sum(order));

	}

}
