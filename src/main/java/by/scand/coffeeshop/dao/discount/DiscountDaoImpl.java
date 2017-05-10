package by.scand.coffeeshop.dao.discount;

import org.springframework.stereotype.Repository;

import by.scand.coffeeshop.dao.BaseDao;
import by.scand.coffeeshop.exception.DaoException;

@Repository
public class DiscountDaoImpl extends BaseDao implements DiscountDao {

	@Override
	public int getNumberOfFreeCup() throws DaoException {

		int numberOfFreeCup = 0;
		try {
			numberOfFreeCup = getOneIntProperty("business_rules", "free_cup");
		} catch (DaoException e) {
			throw new DaoException("Error: getting number of free cup from database", e);
		}
		return numberOfFreeCup;
	}

}
