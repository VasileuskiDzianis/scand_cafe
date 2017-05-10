package by.scand.coffeeshop.dao.orderitem;

import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import by.scand.coffeeshop.dao.orderitem.OrderItemDao;
import by.scand.coffeeshop.dao.orderitem.OrderItemDaoImpl;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;

public class OrderItemDaoImplTest {
	private Goods goods1 = new Goods(1, "Coffe sort 1", 150, 'N');
	private Goods goods2 = new Goods(2, "Coffe sort 2", 200, 'N');
	private OrderItem ordItem1 = new OrderItem(0,1,goods1,2);
	private OrderItem ordItem2 = new OrderItem(1,1,goods2,3);
	
	@Ignore
	@Test
	public void testAddAllListOfOrderItem() throws DaoException {
		ArrayList<OrderItem> itemsList = new ArrayList<OrderItem>();
		itemsList.add(ordItem1);
		itemsList.add(ordItem2);
		OrderItemDao dao = new OrderItemDaoImpl();
		dao.addAll(itemsList);
	}

}
