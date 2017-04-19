package by.scand.coffeeshop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.scand.coffeeshop.dao.*;

public class Order {

	private int id;
	private List<OrderItem> items;
	private Date date;
	private Buyer buyer;
	private BusinessRules businessRules;
	private int discount;
	private int delivery;
	private int cost;

	public Order() {
		items = new ArrayList<OrderItem>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setBusinessRules(BusinessRules businessRules) {
		this.businessRules = businessRules;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void addItem(Goods goods, int amount) {
		items.add(new OrderItem(goods, amount));
	}
	//this method calculate value of all order including delivery and discount
	public int summ() throws DomainException {
		cost = 0;
		for (OrderItem orderItem : items) {
			cost += orderItem.getPrice();
		}
		discount = businessRules.calcDiscount(items);
		cost += discount;
		delivery = businessRules.calcDelivery(items);
		cost += delivery;

		return cost;
	}

}
