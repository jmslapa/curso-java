package entities;

public class Product {
	protected String name;
	protected Double price;
	
	public Product() {
		
	}
	
	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String priceTag() {
		return "Common";
	}
	
	public String toString() {
		return name + 
				", $" + 
				price;				
	}
}
