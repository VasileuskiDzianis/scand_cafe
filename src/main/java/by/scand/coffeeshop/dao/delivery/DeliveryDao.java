package by.scand.coffeeshop.dao.delivery;

import by.scand.coffeeshop.exception.DaoException;

public interface DeliveryDao {
	public int getDeliveryCost() throws DaoException;
	public int getFreeDeliveryLevel() throws DaoException;
}
