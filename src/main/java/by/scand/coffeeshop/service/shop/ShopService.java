package by.scand.coffeeshop.service.shop;

import java.util.List;
import java.util.Map;

import by.scand.coffeeshop.domain.Buyer;
import by.scand.coffeeshop.domain.Goods;
import by.scand.coffeeshop.domain.Order;
import by.scand.coffeeshop.exception.ServiceException;

public interface ShopService {

	void setLang(String lang);

	Order buyGoods(Map<Integer, Integer> purchases) throws ServiceException;

	List<Goods> getCatalog() throws ServiceException;

	boolean confirmOrder(Buyer buyer, Order order) throws ServiceException;

}