package by.scand.coffeeshop.dao.discount;

import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DiscountDaoImpl extends BaseDao implements DiscountDao {

	@Override
	public int getNumberOfFreeCup() {

		int numberOfFreeCup = 0;

		numberOfFreeCup = getOneIntProperty("business_rules", "free_cup");

		return numberOfFreeCup;
	}

}
