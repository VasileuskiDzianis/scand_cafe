package by.scand.coffeeshop.dao;

import by.scand.coffeeshop.domain.BusinessRules;
import by.scand.coffeeshop.domain.BusinessRulesImpl;

public class BusinessRulesDaoMock extends BusinessRulesDao {
	@Override
	public void refreshRules(BusinessRulesImpl rules) throws DaoException {
		rules.setDeliveryCost(200);
		rules.setEachNCupFree(5);
		rules.setFreeDeliveryBorder(1000);
		
				
		
	}
}
