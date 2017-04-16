package by.scand.coffeeshop.domain;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeShopSpringConfTest {

	@Test
	public void testBuyGoods() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop)ctx.getBean("coffeeShop");
		coffeeShop.setLang("ru");
		Order order;
		HashMap<Integer, Integer> products = new HashMap<Integer,Integer>();
		products.put(2, 3);// three coffee for 100
		products.put(3, 2);// two coffee for 150 
		
		order = coffeeShop.buyGoods(products);
		//2*150 + 3*100 + 200 = 800
		assertEquals(800, order.summ());
		
		
		
		
	}

	@Test
	public void testShowCatalog() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop)ctx.getBean("coffeeShop");
		coffeeShop.setLang("ru");
		for (Goods goods : coffeeShop.showCatalog()) {
			assertEquals('N', goods.getDisabled());
			assertTrue(goods.getPrice()>0);
			
		}
	}

	@Ignore
	@Test
	public void testConfirmOrder() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("shop_spring.xml");
		CoffeeShop coffeeShop = (CoffeeShop)ctx.getBean("coffeeShop");
		coffeeShop.setLang("ru");
		Order order;
		HashMap<Integer, Integer> products = new HashMap<Integer,Integer>();
		products.put(2, 3);// three coffee for 100
		products.put(3, 2);// two coffee for 150 
		order = coffeeShop.buyGoods(products);
		order.summ();
		coffeeShop.confirmOrder(new Buyer("Test_n","Test_sn","Test_pt","Address_test"), order);
	}

}
