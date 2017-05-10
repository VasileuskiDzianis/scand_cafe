package by.scand.coffeeshop.dao.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.dao.discount.DiscountDaoImpl;
import by.scand.coffeeshop.exception.DaoException;

public class DiscountDaoTest {

	private DiscountDao discountDao;
	@Before
	public void initialization(){
		discountDao = new DiscountDaoImpl();
	}
	
	@Test
	public void testGetNumberOfFreeCup() throws DaoException {
		assertEquals(5, discountDao.getNumberOfFreeCup());
	}

}
