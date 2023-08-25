package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private LocalDate date;
	private Integer months;
	private Double amount;
	private List<Installment> installments = new ArrayList<>();
	
	public Contract(LocalDate date, Integer months, Double amount) {
		this.date = date;
		this.months = months;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}
	
	
}
