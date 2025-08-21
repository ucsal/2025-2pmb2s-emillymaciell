package br.com.mariojp.solid.srp;

public class TaxCalculator {
    private double taxRate;

    public TaxCalculator() {
        String rateProperty = System.getProperty("tax.rate");
        this.taxRate = rateProperty != null ? Double.parseDouble(rateProperty) : 0.10;
    }

    public double calculateTax(double subtotal) {
        return subtotal * taxRate;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
