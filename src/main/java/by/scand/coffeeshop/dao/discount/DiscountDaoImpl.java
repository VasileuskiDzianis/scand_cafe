package by.scand.coffeeshop.dao.discount;

import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DiscountDaoImpl extends BaseDao implements DiscountDao {

	@Override
	public int getNumberOfFreeCup() {

		return getOneIntProperty("business_rules", "free_cup");
	}
}
