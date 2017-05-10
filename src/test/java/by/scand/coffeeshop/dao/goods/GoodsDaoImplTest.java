package by.scand.coffeeshop.dao.goods;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.dao.goods.GoodsDao;
import by.scand.coffeeshop.dao.goods.GoodsDaoImpl;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.exception.DaoException;

public class GoodsDaoImplTest {

	@Test
	public void testGetOne() throws DaoException {
		GoodsDao goodsDaoImpl = new GoodsDaoImpl();
		Goods goods = goodsDaoImpl.getOne(1,"en");
		assertEquals(1, goods.getId());
		assertEquals("Test Coffee Sort 1", goods.getName());
		assertEquals(50, goods.getPrice());
		assertEquals('Y', goods.getDisabled());
		
		//System.out.println(goods);
		
	}

	@Test
	public void testGetAll() throws DaoException {
		GoodsDao goodsDaoImpl = new GoodsDaoImpl();
		List<Goods> goodsList;
		goodsList = goodsDaoImpl.getAll("en");
		//size of ArrayList should be equal with number of "active" products in table goods
		assertEquals(7, goodsList.size());
		//System.out.println(goodsList);
		
	}

	

}
