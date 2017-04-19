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
	private String lang;

	public CoffeeShop() {
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
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

	public Order buyGoods(Map<Integer, Integer> purchases) throws DomainException { // Key - goods Id;
																// Value -
																// amount which
																// we get from
																// UI
		for (Map.Entry<Integer, Integer> entry : purchases.entrySet()) {
			order.addItem(catalog.getOneItemOfGoods(entry.getKey(), lang), entry.getValue());
		}
		order.summ();
		return order;
	}

	public List<Goods> showCatalog() throws DomainException {
		return catalog.getCatalog(lang);
	}

	public boolean confirmOrder(Buyer buyer, Order order) throws DomainException {
		Date date = new Date();
		order.setBuyer(buyer);
		order.setDate(date);
		boolean confirmation = false;
		try {
			orderDao.addOne(order);
			confirmation = true;
		} catch (DaoException e) {
			throw new DomainException("Order confirmation error");
		}

		return confirmation;
	}

}