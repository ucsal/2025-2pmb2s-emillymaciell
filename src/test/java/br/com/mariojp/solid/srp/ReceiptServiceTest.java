package br.com.mariojp.solid.srp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {
    @Test
    void uses_configured_tax_rate_of_8_percent() {
        System.setProperty("tax.rate", "0.08");
        TaxCalculator taxCalculator = new TaxCalculator();
        ReceiptFormatter formatter = new ReceiptFormatter();
        ReceiptService receiptService = new ReceiptService(taxCalculator, formatter);
        Order order = new Order();
        order.add(new Item("Café", 8.0, 2)); // 16
        order.add(new Item("Bolo", 12.5, 1)); // 12.5 -> subtotal 28.5

        String receipt = receiptService.generateReceipt(order.getItems());
        System.out.println(receipt);

        assertTrue(receipt.contains("Subtotal: $28.50"), "O subtotal deve ser 28.50");
        assertTrue(receipt.contains("Tax: $2.28"), "O imposto deve ser 2.28, respeitando tax.rate=0.08");
        assertTrue(receipt.contains("Total: $30.78"), "O total deve ser 30.78");
    }
}
