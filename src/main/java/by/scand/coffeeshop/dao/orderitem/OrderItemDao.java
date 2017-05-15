package by.scand.coffeeshop.dao.orderitem;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public interface OrderItemDao {

	void addAll(List<OrderItem> orderItems);

}