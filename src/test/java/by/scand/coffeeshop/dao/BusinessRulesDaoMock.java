package by.scand.coffeeshop.dao;

import by.scand.coffeeshop.domain.BusinessRules;
import by.scand.coffeeshop.domain.BusinessRulesImpl;

public class BusinessRulesDaoMock extends BusinessRulesDao {
	@Override
	public BusinessRules getOne(int id) throws DaoException {
		BusinessRulesImpl brImpl = new BusinessRulesImpl(5, 200, 1000);
		
		return brImpl;
		
	}
}
