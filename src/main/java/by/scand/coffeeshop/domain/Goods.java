package by.scand.coffeeshop.domain;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.JoinColumn;

@Entity
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "goods_name", joinColumns = @JoinColumn(name = "goods_id"))
	@MapKeyColumn(name = "locale")
	@Column(name = "name")
	private Map<String, String> name;

	@Column(name = "price")
	private int price; // coins

	@Column(name = "disabled")
	private char disabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getName() {
		return name;
	}

	public void setName(Map<String, String> name) {
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

}
