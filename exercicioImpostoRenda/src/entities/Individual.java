package entities;

public class Individual extends TaxPayer{
	
	private double healthSpendings;
	
	public Individual() {
	}
	
	public Individual(String name, Double anualIncome, Double healthSpendings) {
		super(name, anualIncome);
		this.healthSpendings = healthSpendings;
	}
	
	public void setHealthSpendings(Double healthSpendings) {
		this.healthSpendings = healthSpendings;
	}
	
	public Double getHealthSpendings() {
		return healthSpendings;
	}

	@Override
	public double tax() {
		if(anualIncome < 20000) {
			return anualIncome * 0.15 - healthSpendings * 0.5;
		}else {
			return anualIncome * 0.25 - healthSpendings * 0.5;
		}
	}
}
