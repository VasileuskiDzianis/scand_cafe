package by.scand.coffeeshop.service.discount;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;
import by.scand.coffeeshop.exception.ServiceException;

public interface DiscountService {
	
	public int calcDiscount(List<OrderItem> items) throws ServiceException;
	public int getNumberOfFreeCup() throws ServiceException;

}
