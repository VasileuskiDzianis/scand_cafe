package by.scand.coffeeshop.dao.discount;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.scand.coffeeshop.dao.discount.DiscountDao;
import by.scand.coffeeshop.dao.discount.DiscountDaoImpl;

public class DiscountDaoTest {
	private static final int NUMBER_OF_FREE_CUP = 5;

	private DiscountDao discountDao;
	
	@Before
	public void initialization(){
		
		discountDao = new DiscountDaoImpl();
	}
	
	@Test
	public void testGetNumberOfFreeCup() {
		
		assertEquals(NUMBER_OF_FREE_CUP, discountDao.getNumberOfFreeCup());
	}
}