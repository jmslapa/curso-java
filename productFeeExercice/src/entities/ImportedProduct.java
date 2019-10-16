package entities;

public class ImportedProduct extends Product{
	private Double customsFee;
	
	public ImportedProduct() {
		
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}
	
	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double getCustomsFee() {
		return customsFee;
	}
	
	@Override
	public final String priceTag() {
		return "Imported";
	}	
	
	public Double totalPrice() {
		return price + customsFee;
	}
	
	@Override
	public String toString() {
		return name + 
				", $" + 
				totalPrice() + 
				" (Customs fee: $" + 
				customsFee + 
				")";
	}
}
