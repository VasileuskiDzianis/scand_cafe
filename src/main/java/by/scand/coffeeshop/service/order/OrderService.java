package by.scand.coffeeshop.service.order;

import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.ServiceException;

public interface OrderService {
	public void addItem(Goods goods, int amount, Order order);
	public int sum(Order order) throws ServiceException;
	public int saveOrder(Order order)throws ServiceException;
}
