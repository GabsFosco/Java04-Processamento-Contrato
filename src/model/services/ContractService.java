package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract) {
		
		Double baseAmount = contract.getAmount() / contract.getMonths();
		
		double interest = onlinePaymentService.interestCalc(baseAmount, contract.getMonths());
		double fee = onlinePaymentService.feeCalc(contract.getAmount(), interest);
		
		double installmentAmount = fee / contract.getMonths();
		
		for (int i = 1; i <= contract.getMonths(); i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i); //Soma 1 mês à data do contrato para criar parcela.
			
			contract.getInstallments().add(new Installment(dueDate, installmentAmount));
		}
		
	}
	
}
