package by.scand.coffeeshop.dao.orderitem;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.DaoException;

public interface OrderItemDao {

	void addAll(List<OrderItem> orderItems) throws DaoException;

}