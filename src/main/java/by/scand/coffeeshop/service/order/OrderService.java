package by.scand.coffeeshop.service.order;

import java.util.Map;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;

public interface OrderService {

	void addItem(Goods goods, int amount, Order order);

	void confirmOrder(Buyer buyer, Order order);

	Order buyGoods(Map<Integer, Integer> purchases, String language);

	int calculateOrderCost(Order order);

}