package by.scand.coffeeshop.service.discount;

import java.util.List;

import by.scand.coffeeshop.domain.OrderItem;

public interface DiscountService {

	int calculateDiscount(List<OrderItem> items);

	int getNumberOfFreeCup();

}