package by.scand.coffeeshop.dao.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.dao.delivery.DeliveryDaoImpl;

public class DeliveryDaoTest {
	
	private static final int DELIVERY_COST = 200;
	private static final int FREE_DELIVERY_LEVEL = 1000;

	private DeliveryDao deliveryDao;
	@Before
	public void initialization(){
		deliveryDao = new DeliveryDaoImpl();
	}
	
	@Test
	public void testGetDeliveryCost() {
		
		assertEquals(DELIVERY_COST, deliveryDao.getDeliveryCost());
	}
	@Test
	public void testGetFreeDeliveryLevel() {
		
		assertEquals(FREE_DELIVERY_LEVEL, deliveryDao.getFreeDeliveryLevel());
	}

}
