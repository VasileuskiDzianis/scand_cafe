package by.scand.coffeeshop.service.discount;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public interface DiscountService {
	
	public int calcDiscount(List<OrderItem> items);
	public int getNumberOfFreeCup();

}
