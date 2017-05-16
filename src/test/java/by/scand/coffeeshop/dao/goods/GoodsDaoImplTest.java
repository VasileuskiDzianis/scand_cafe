package by.scand.coffeeshop.dao.goods;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.dao.goods.GoodsDao;
import by.scand.coffeeshop.dao.goods.GoodsDaoImpl;
import by.scand.coffeeshop.domain.Goods;

public class GoodsDaoImplTest {

	@Test
	public void testGetOne() {
		GoodsDao goodsDaoImpl = new GoodsDaoImpl();
		Goods goods = goodsDaoImpl.getOne(1, "en");
		assertEquals(1, goods.getId());
		assertEquals("Test Coffee Sort 1", goods.getName());
		assertEquals(50, goods.getPrice());
		assertEquals('Y', goods.getDisabled());
	}

	@Test
	public void testGetAll() {
		GoodsDao goodsDaoImpl = new GoodsDaoImpl();
		List<Goods> goodsList;
		goodsList = goodsDaoImpl.getAll("en");
		assertEquals(7, goodsList.size());

	}

}
