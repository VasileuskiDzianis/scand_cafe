package by.scand.coffeeshop.dao.buyer;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.exception.DaoException;

public interface BuyerDao {

	int addOne(Buyer buyer) throws DaoException;

}