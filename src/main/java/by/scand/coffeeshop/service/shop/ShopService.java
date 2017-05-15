package by.scand.coffeeshop.service.shop;

import java.util.List;
import java.util.Map;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;

public interface ShopService {

	Order buyGoods(Map<Integer, Integer> purchases, String language);

	List<Goods> getCatalog(String language);

	boolean confirmOrder(Buyer buyer, Order order);

}