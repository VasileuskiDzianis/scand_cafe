package by.scand.coffeeshop.service.orderitem;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public interface OrderItemService {
	public int getPrice(OrderItem orderItem);
	public void addAllItems(List<OrderItem> orderItems);
}
