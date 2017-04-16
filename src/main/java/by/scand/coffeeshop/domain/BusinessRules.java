package by.scand.coffeeshop.domain;

import java.util.List;

public interface BusinessRules {
	
	public int calcDiscount(List<OrderItem> items);
	public int calcDelivery(List<OrderItem> items);
}
