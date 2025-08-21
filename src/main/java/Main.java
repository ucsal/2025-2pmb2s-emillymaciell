import br.com.mariojp.solid.srp.*;

public class Main {

	public static void main(String[] args) {
		runExample("Cenário 1: Taxa Padrão (10%)", null);
		runExample("Cenário 2: Taxa Configurada (8%)", "0.08");
	}

	private static void runExample(String scenario, String taxRate) {
		if (taxRate != null) {
			System.setProperty("tax.rate", taxRate);
		} else {
			System.clearProperty("tax.rate");
		}

		TaxCalculator taxCalculator = new TaxCalculator();
		ReceiptFormatter formatter = new ReceiptFormatter();
		ReceiptService receiptService = new ReceiptService(taxCalculator, formatter);

		Order o = new Order();
		o.add(new Item("Café", 8.0, 2)); // 16
		o.add(new Item("Bolo", 12.5, 1)); // 12.5 -> subtotal 28.5
		String receipt = receiptService.generateReceipt(o.getItems());
		System.out.println(receipt);
	}
}
