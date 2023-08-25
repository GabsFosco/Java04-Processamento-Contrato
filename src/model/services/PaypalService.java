package model.services;

public class PaypalService implements OnlinePaymentService {

	private final static Double monthlyInterest = 0.01;
	private final static Double tax = 0.02;
	
	public double interestCalc(double amount, int months) {
		
		double interest = 0.0;
		
		for (int i = 1; i <= months; i++) {
			interest += monthlyInterest * i * amount;
		}
		return interest;
	}
	
	public double feeCalc(double amount, double interest) {
		return (amount + interest) * 1+tax;
	}
}
