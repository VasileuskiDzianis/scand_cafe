package by.scand.coffeeshop.service.order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.delivery.DeliveryServiceImpl;
import by.scand.coffeeshop.service.discount.DiscountServiceImpl;
import by.scand.coffeeshop.service.orderitem.OrderItemServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {
	private Order order;
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private Goods goods3 = new Goods(3, "Coffe sort 3", 100, 'N');
	private Goods goods4 = new Goods(4, "Coffe sort 4", 100, 'N');
	
	@Mock
	private DeliveryDao deliveryDao;
	@Mock
	private DiscountDao discountDao;
	
	private DeliveryServiceImpl deliveryService;
	private DiscountServiceImpl discountService;
	private OrderServiceImpl orderService;
	
	
	@Before
	public void initialization() throws DaoException{
		when(deliveryDao.getDeliveryCost()).thenReturn(200);
		when(deliveryDao.getFreeDeliveryLevel()).thenReturn(1000);
		deliveryService = new DeliveryServiceImpl();
		deliveryService.setDeliveryDao(deliveryDao);
		when(discountDao.getNumberOfFreeCup()).thenReturn(5);
		discountService = new DiscountServiceImpl();
		discountService.setDiscountDao(discountDao);
		orderService = new OrderServiceImpl();
		orderService.setDeliveryService(deliveryService);
		orderService.setDiscountService(discountService);
		orderService.setOrderItemService(new OrderItemServiceImpl());
		
	}
	
	@Test
	public void testSumAndAddItem() throws ServiceException {
		order = new Order();
		orderService.addItem(goods1, 1, order);
		orderService.addItem(goods2, 1, order);
		orderService.addItem(goods3, 1, order);
		//it should be calculated: 150*1 + 200*1 + 100*1 + 200(delivery)
		assertEquals(650, orderService.sum(order));
		
		orderService.addItem(goods4, 7, order);
		//it should be calculated: 150*1 + 200*1 + 100*1 + 7*100 +0(delivery) - 1*100(discount)
		assertEquals(1050, orderService.sum(order));
	}

}
