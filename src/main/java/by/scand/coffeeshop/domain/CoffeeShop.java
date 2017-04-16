package by.scand.coffeeshop.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import by.scand.coffeeshop.dao.DaoException;
import by.scand.coffeeshop.dao.OrderDao;

public class CoffeeShop {

	private Catalog catalog;
	private Order order;
	private OrderDao orderDao;

	public CoffeeShop() {
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Order buyGoods(Map<Integer, Integer> purchases) { // Key - goods Id;
																// Value -
																// amount which
																// we get from
																// UI
		for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
			order.addItem(catalog.getOneItemOfGoods(entry.getKey()), entry.getValue());
		}
		return order;
	}

	public List<Goods> showCatalog() {
		return catalog.getCatalog();
	}

	public boolean confirmOrder(Buyer buyer, Order order) {
		Date date = new Date();
		order.setBuyer(buyer);
		order.setDate(date);
		try {
			orderDao.addOne(order);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}