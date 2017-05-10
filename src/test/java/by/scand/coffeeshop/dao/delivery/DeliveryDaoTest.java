package by.scand.coffeeshop.dao.delivery;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.scand.coffeeshop.dao.delivery.DeliveryDao;
import by.scand.coffeeshop.dao.delivery.DeliveryDaoImpl;
import by.scand.coffeeshop.exception.DaoException;

public class DeliveryDaoTest {

	private DeliveryDao deliveryDao;
	@Before
	public void initialization(){
		deliveryDao = new DeliveryDaoImpl();
	}
	
	@Test
	public void testGetDeliveryCost() throws DaoException {
		assertEquals(200, deliveryDao.getDeliveryCost());
	}
	@Test
	public void testGetFreeDeliveryLevel() throws DaoException {
		assertEquals(1000, deliveryDao.getFreeDeliveryLevel());
	}

}
