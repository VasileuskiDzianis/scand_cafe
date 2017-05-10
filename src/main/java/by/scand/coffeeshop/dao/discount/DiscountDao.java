package by.scand.coffeeshop.dao.discount;

import by.scand.coffeeshop.exception.DaoException;

public interface DiscountDao {
	public int getNumberOfFreeCup() throws DaoException;
}
