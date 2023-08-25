package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;


public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		
		String startDate = "25/08/2023";
		Double contractAmount = 600.00;
		Integer contractMonths = 3;

		LocalDate contractDate = LocalDate.parse(startDate, fmt);
		
		Contract contract = new Contract(contractDate, contractMonths, contractAmount);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processContract(contract);
		
		System.out.println("PARCELAS:");
		for (int i = 1; i <= contractMonths; i++) {
			System.out.println("Parcela " + i + ": " + contract.getInstallments().get(i-1));
		}
		
		
	}

}