package by.scand.coffeeshop.service.delivery;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.exception.DaoException;
import by.scand.coffeeshop.exception.ServiceException;
import by.scand.coffeeshop.service.delivery.DeliveryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryServiceImplTest {
	
	@Mock
	private DeliveryDao deliveryDao;
	private DeliveryServiceImpl deliveryService;
	
	@Test
	public void testCalcDelivery() throws DaoException, ServiceException {
		when(deliveryDao.getDeliveryCost()).thenReturn(200);
		when(deliveryDao.getFreeDeliveryLevel()).thenReturn(1000);
		deliveryService = new DeliveryServiceImpl();
		deliveryService.setDeliveryDao(deliveryDao);
		
		assertEquals(200, deliveryService.calcDelivery(999));
		assertEquals(0, deliveryService.calcDelivery(1000));
		assertEquals(0, deliveryService.calcDelivery(1001));
		
		
	}

}
