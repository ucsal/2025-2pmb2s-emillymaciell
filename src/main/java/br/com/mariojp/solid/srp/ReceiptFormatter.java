package br.com.mariojp.solid.srp;

import java.util.List;
import java.util.Locale;

public class ReceiptFormatter {
    public String format(List<Item> items, double subtotal, double tax, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== RECIBO ===\n");
        for (Item i : items) {
            sb.append(i.getName()).append(" x").append(i.getQuantity()).append(" = ")
                    .append(i.getUnitPrice() * i.getQuantity())
                    .append("\n");
        }
        sb.append(String.format(Locale.US, "Subtotal: $%.2f%n", subtotal));
        sb.append(String.format(Locale.US, "Tax: $%.2f%n", tax));
        sb.append(String.format(Locale.US, "Total: $%.2f%n", total));

        return sb.toString();
    }
}
