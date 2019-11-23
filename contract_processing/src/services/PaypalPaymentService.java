package services;

public class PaypalPaymentService implements PaymentService{

	public double paymentTax(Double amount, int installmentNumber) {
		
		double installmentTax = (double)(installmentNumber * 0.01) * amount;
		double paymentTax = 0.02 * (amount + installmentTax);
		
		return installmentTax + paymentTax;
	}
	
	
}
