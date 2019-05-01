/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.model;

/**
 *
 * @author roulis
 */
public class TaxResponse {

    private String taxCode;
    private String name;
    private long price;
    private String Status;

    public String getTaxCode() {
        return taxCode;
    }

    public TaxResponse setTaxCode(String taxCode) {
        this.taxCode = taxCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaxResponse setName(String name) {
        this.name = name;
        return this;
    }

    public long getPrice() {
        return price;
    }

    public TaxResponse setPrice(long price) {
        this.price = price;
        return this;
    }

    public String getStatus() {
        return Status;
    }

    public TaxResponse setStatus(String Status) {
        this.Status = Status;
        return this;
    }

}
