package by.scand.coffeeshop.domain;

public class OrderItem {
	private int id;
	private Goods goods;
	private int amount;
	private int orderId;
	private int cost;

	public OrderItem() {

	}

	public OrderItem(Goods goods, int amount) {
		this.goods = goods;
		this.amount = amount;
	}
	
	

	public OrderItem(int id, int orderId, Goods goods, int amount) {
		this.id = id;
		this.goods = goods;
		this.amount = amount;
		this.orderId = orderId;
	}
	
	
	
	public int getCost() {
		cost = getPrice();
		return cost;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	// return item price
	public int getPrice() {

		return goods.getPrice() * amount;
	}

}
