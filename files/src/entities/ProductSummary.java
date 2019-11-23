package entities;

import java.util.Locale;

public class ProductSummary {
	
	private String name;
	private Double price;
	private Integer soldAmount;	
	
	public ProductSummary(String name, Double price, Integer soldAmount) {
		this.setName(name);
		this.setPrice(price);
		this.setSoldAmount(soldAmount);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getSoldAmount() {
		return this.soldAmount;
	}
	
	public void setSoldAmount(Integer soldAmount) {
		this.soldAmount = soldAmount;
	}
	
	@Override
	public String toString() {
		Locale.setDefault(Locale.US);
		return this.name + "," + String.format("%.2f", this.price * this.soldAmount);
	}
}
