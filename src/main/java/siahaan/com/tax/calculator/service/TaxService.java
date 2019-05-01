/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.service;

import siahaan.com.tax.calculator.model.Bill;
import siahaan.com.tax.calculator.model.TaxRequest;
import siahaan.com.tax.calculator.model.TaxResponse;

/**
 *
 * @author roulis
 */
public interface TaxService {

    public TaxResponse createTaxObject(TaxRequest request);

    public Bill checkMyBill(String phone);
}
