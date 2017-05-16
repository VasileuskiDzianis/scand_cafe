package by.scand.coffeeshop.dao.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.dao.delivery.DeliveryDaoImpl;

public class DeliveryDaoTest {

	private DeliveryDao deliveryDao;
	@Before
	public void initialization(){
		deliveryDao = new DeliveryDaoImpl();
	}
	
	@Test
	public void testGetDeliveryCost() {
		assertEquals(200, deliveryDao.getDeliveryCost());
	}
	@Test
	public void testGetFreeDeliveryLevel() {
		assertEquals(1000, deliveryDao.getFreeDeliveryLevel());
	}

}
