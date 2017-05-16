package by.scand.coffeeshop.service.delivery;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.service.delivery.DeliveryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DeliveryServiceImplTest {
	
	@Mock
	private DeliveryDao deliveryDao;
	@InjectMocks
	private DeliveryServiceImpl deliveryService = new DeliveryServiceImpl();
	
	@Test
	public void testCalcDelivery(){
		int deliveryCost = 200;
		int freeDeliveryLevel = 1000;
		
		when(deliveryDao.getDeliveryCost()).thenReturn(deliveryCost);
		when(deliveryDao.getFreeDeliveryLevel()).thenReturn(freeDeliveryLevel);
		
		int result = deliveryService.calcDelivery(999);
		assertEquals(deliveryCost, result);
		result = deliveryService.calcDelivery(freeDeliveryLevel);
		assertEquals(0, result);
			
		
	}

}
