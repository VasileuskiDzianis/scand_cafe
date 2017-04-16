package by.scand.coffeeshop.domain;

public class Buyer {

	private int id;
	private String firstName;
	private String lastName;
	private String patronymic;
	private String address;

	public Buyer() {
	}

	public Buyer(int id, String firstName, String lastName, String patronymic, String shippingAddress) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.patronymic = patronymic;
		this.address = shippingAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getShippingAddress() {
		return address;
	}

	public void setShippingAddress(String shippingAddress) {
		this.address = shippingAddress;
	}

}
