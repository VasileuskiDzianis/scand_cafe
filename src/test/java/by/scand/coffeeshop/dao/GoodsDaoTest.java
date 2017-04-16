package by.scand.coffeeshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.domain.Goods;

public class GoodsDaoTest {

	@Test
	public void testGetOne() throws DaoException {
		GoodsDao goodsDao = new GoodsDao();
		Goods goods = goodsDao.getOne(1);
		assertEquals(1, goods.getId());
		assertEquals("Test Coffee Sort 1", goods.getName());
		assertEquals(50, goods.getPrice());
		assertEquals('Y', goods.getDisabled());
		
	}

	@Test
	public void testGetAll() throws DaoException {
		GoodsDao goodsDao = new GoodsDao();
		List<Goods> goodsList;
		goodsList = goodsDao.getAll();
		//size of ArrayList should be equal with number of products in table goods
		assertEquals(4, goodsList.size());
		
	}

	@Test
	public void testAddOneGoods() {
		//fail("Not yet implemented");
	}

}
