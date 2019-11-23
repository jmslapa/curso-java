package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {
	
	private Date dueDate;
	private Double amount;
	
	public Installment(){
	}
	
	public Installment(Date dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	public Date getDueDate() {
		return this.dueDate;
	}
	
	public Double getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(dueDate) + " - " + String.format("%.2f", amount);
	}
	
}
