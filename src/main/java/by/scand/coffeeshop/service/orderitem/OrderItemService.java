package by.scand.coffeeshop.service.orderitem;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.ServiceException;

public interface OrderItemService {
	public int getPrice(OrderItem orderItem) throws ServiceException;
	public void addAllItems(List<OrderItem> orderItems) throws ServiceException;
}
