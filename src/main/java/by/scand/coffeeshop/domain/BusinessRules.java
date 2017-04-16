package by.scand.coffeeshop.domain;

import java.util.List;

import by.scand.coffeeshop.dao.BusinessRulesDao;

public interface BusinessRules {
	
	public void setBusinessRulesDao(BusinessRulesDao businessRulesDao);
	public int calcDiscount(List<OrderItem> items);
	public int calcDelivery(List<OrderItem> items);
}
