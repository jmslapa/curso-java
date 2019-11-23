package services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entities.Contract;
import entities.Installment;

public class InstallmentService {

	private int numberOfInstallments;
	private PaymentService paymentService;
	private List<Installment> list;	

	public InstallmentService(int numberOfInstallments, PaymentService paymentService) {
		this.numberOfInstallments = numberOfInstallments;
		this.paymentService = paymentService;
		list = new ArrayList<>();
	}
	
	public int getNumberOfInstallments() {
		return this.numberOfInstallments;
	}
	
	public PaymentService getPaymentService() {
		return this.paymentService;
	}
	
	public List<Installment> getInstallments() {
		return this.list;
	}
	
	private Date addMonths(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, amount);
		return cal.getTime();
	}

	public void processTheContract(Contract contract) {

		Double valueFraction = contract.getTotalValue() / numberOfInstallments;	
		
		for (int i = 1 ; i <= numberOfInstallments; i++) {			
			list.add(new Installment(addMonths(contract.getDate(), i), valueFraction + paymentService.paymentTax(valueFraction, i)));
		}	
		
	}

}
