package by.scand.coffeeshop.dao.orderitem;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.dao.orderitem.OrderItemDao;
import by.scand.coffeeshop.dao.orderitem.OrderItemDaoImpl;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;

public class OrderItemDaoImplTest {
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private OrderItem ordItem1 = new OrderItem(goods1,2);
	private OrderItem ordItem2 = new OrderItem(goods2,3);
	
	@Ignore
	@Test
	public void testAddAllListOfOrderItem() {
		ArrayList<OrderItem> itemsList = new ArrayList<OrderItem>();
		OrderItemDao dao = new OrderItemDaoImpl();
		
		itemsList.add(ordItem1);
		itemsList.add(ordItem2);
		
		dao.addAll(itemsList);
	}
}