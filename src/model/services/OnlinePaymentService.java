package model.services;

public interface OnlinePaymentService {
	
	double interestCalc(double amount, int months);
	
	double feeCalc(double amount, double interest);
	
}
