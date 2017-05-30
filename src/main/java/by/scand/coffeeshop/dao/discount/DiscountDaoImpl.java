package by.scand.coffeeshop.dao.discount;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import by.scand.coffeeshop.dao.BaseDao;

@Repository
public class DiscountDaoImpl extends BaseDao implements DiscountDao {

	@Value("#{businessRules['numberOfFreeCup'] ?: 5}")
	private int numberOfFreeCup;
	
	@Override
	public int getNumberOfFreeCup() {

		return numberOfFreeCup;
	}
}
