package entities;

public class Company extends TaxPayer{
	
	private Integer employeesQuantity;
	
	public Company() {
	}
	public Company(String name, Double anualIncome, Integer employeesQuantity) {
		super(name, anualIncome);
		this.employeesQuantity = employeesQuantity;
	}
	
	public void setEmployeesQuantity(Integer employeesQuantity) {
		this.employeesQuantity = employeesQuantity;
	}
	
	public Integer getEmployeesQuantity() {
		return employeesQuantity;
	}
	
	@Override
	public double tax() {
		if(employeesQuantity <= 10) {
			return anualIncome * 0.16;
		}else{
			return anualIncome * 0.14;
		}
	}
}
