package br.com.mariojp.solid.srp;

import java.util.List;

public class ReceiptService {

	private final TaxCalculator taxCalculator;
	private final ReceiptFormatter formatter;

	public ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter formatter) {
		this.taxCalculator = taxCalculator;
		this.formatter = formatter;
	}

	public String generateReceipt(List<Item> items) {
		double subtotal = items.stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		double tax = taxCalculator.calculateTax(subtotal);
		double total = subtotal + tax;

		return formatter.format(items, subtotal, tax, total);
	}
}
