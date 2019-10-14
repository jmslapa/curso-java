package entities;

public class Employee {
	// ATTRIBUTES
	private int id;
	private String name;
	private double salary;
	//CONSTRUCTOR
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	//METHODS
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
	public double getSalary() {
		return salary;
	}
	
	public void salaryIncrease(double percentage) {
		salary *= percentage/100 + 1;
	}
	
	public String toString() {
		return id + 
			   ", " + 
			   name + 
			   ", $" +
			   String.format("%.2f", salary);
	}
	
}
