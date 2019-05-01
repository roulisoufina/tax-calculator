/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.model;

import java.util.List;

/**
 *
 * @author roulis
 */
public class Bill {

    private List<Taxes> taxes;

    private long subtotalPrice;

    private double subtotalTax;

    private double grandTotal;

    public List<Taxes> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxes> taxes) {
        this.taxes = taxes;
    }

    public long getSubtotalPrice() {
        return subtotalPrice;
    }

    public void setSubtotalPrice(long subtotalPrice) {
        this.subtotalPrice = subtotalPrice;
    }

    public double getSubtotalTax() {
        return subtotalTax;
    }

    public void setSubtotalTax(double subtotalTax) {
        this.subtotalTax = subtotalTax;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

}
