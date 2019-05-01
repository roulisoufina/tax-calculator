/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.constant;

/**
 *
 * @author roulis
 */
public enum EnumTax {

    FOODANDBEVERAGE("1", "Food & Beverage", "Yes"),
    TOBACCO("2", "Tobacco", "No"),
    ENTERTAINMENT("3", "Entertainment", "No");

    private String taxCode;
    private String type;
    private String refundable;

    private EnumTax(String taxCode, String type, String refundable) {
        this.taxCode = taxCode;
        this.type = type;
        this.refundable = refundable;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefundable() {
        return refundable;
    }

    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

}
