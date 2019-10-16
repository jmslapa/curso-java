package entities;

public abstract class TaxPayer {
	
	protected String name;
	protected Double anualIncome;
	
	public TaxPayer() {		
	}
	public TaxPayer(String name, Double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAnualIncome(Double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public Double getAnualIncome() {
		return anualIncome;
	}
	
	public abstract double tax();
	
	public String toString() {
		return name + 
				": $" + 
				String.format("%.2f", tax());
	}
}
