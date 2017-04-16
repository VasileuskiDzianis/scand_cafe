package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import by.scand.coffeeshop.dao.GoodsDaoMock;

public class CatalogTest{
	
	private Catalog catalog;
	@Test
	public void testGetCatalog() {
		catalog = new Catalog();
		catalog.setGoodsDao(new GoodsDaoMock());
		List<Goods> goods = catalog.getCatalog();
		for (Goods product : goods) {
			assertEquals('N',product.getDisabled());
		}
	}
	@Test
	public void testGetOneItemOfGoods(){
		catalog = new Catalog();
		catalog.setGoodsDao(new GoodsDaoMock());
		Goods goods;
		goods = catalog.getOneItemOfGoods(3);
		
		assertEquals("Coffe sort 3",goods.getName());
		
		
	}

}
