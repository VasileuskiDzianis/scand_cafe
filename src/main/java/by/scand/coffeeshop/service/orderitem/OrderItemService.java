package by.scand.coffeeshop.service.orderitem;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public interface OrderItemService {
	
	int getOrderItemCost(OrderItem orderItem);
	
	void addAllItems(List<OrderItem> orderItems);
}
