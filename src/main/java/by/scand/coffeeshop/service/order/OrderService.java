package by.scand.coffeeshop.service.order;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;

public interface OrderService {
	public void addItem(Goods goods, int amount, Order order);

	public int sum(Order order);

	public int saveOrder(Order order);
}
