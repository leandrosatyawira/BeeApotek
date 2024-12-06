package models;

public abstract class Medicine {
	private String name;
	private String id;
	private int quantity;
	private String category;
	private String type;
	private int price;
	
	public Medicine(String name, String id, int quantity, String category, String type, int price) {
		super();
		this.name = name;
		this.id = id;
		this.quantity = quantity;
		this.category = category;
		this.type = type;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
	
	