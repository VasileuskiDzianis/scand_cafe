package by.scand.coffeeshop.dao.order;

import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.DaoException;

public interface OrderDao {

	int addOne(Order order) throws DaoException;

}