package by.scand.coffeeshop.domain;

public class Goods {

	private int id;
	private String name;
	private int price;
	private char disabled;

	public Goods() {
	}
	
	

	public Goods(int id, String name, int price, char disabled) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.disabled = disabled;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getDisabled() {
		return disabled;
	}

	public void setDisabled(char disabled) {
		this.disabled = disabled;
	}



	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", disabled=" + disabled + "]";
	}
	
	

}
