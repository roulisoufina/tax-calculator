/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.lang3.StringUtils;
import siahaan.com.tax.calculator.constant.EnumTax;
import siahaan.com.tax.calculator.dao.TaxDao;
import siahaan.com.tax.calculator.dao.UserDao;
import siahaan.com.tax.calculator.entity.Tax;
import siahaan.com.tax.calculator.entity.Customer;
import siahaan.com.tax.calculator.exception.ResourceNotFoundException;
import siahaan.com.tax.calculator.model.Bill;
import siahaan.com.tax.calculator.model.TaxRequest;
import siahaan.com.tax.calculator.model.TaxResponse;
import siahaan.com.tax.calculator.model.Taxes;
import siahaan.com.tax.calculator.service.TaxService;

/**
 *
 * @author roulis
 */
@Named("defaultTaxService")
public class DefaultTaxService implements TaxService {

    @Inject
    private TaxDao taxDao;

    @Inject
    private UserDao userDao;

    @Override
    public TaxResponse createTaxObject(TaxRequest request) {
        Customer user = Optional.ofNullable(userDao.findByPhone(request.getPhone())).orElseThrow(() -> new ResourceNotFoundException("customer is not found"));
        Tax tax = new Tax(new BigInteger(request.getTaxCode()), request.getName(), request.getPrice(), user);
        Tax result = taxDao.save(tax);
        TaxResponse response = new TaxResponse()
                .setName(result.getName())
                .setPrice(result.getPrice())
                .setStatus("success")
                .setTaxCode(result.getTaxCode().toString());
        return response;
    }

    @Override
    public Bill checkMyBill(String phone) {
        Customer user = Optional.ofNullable(userDao.findByPhone(phone)).orElseThrow(() -> new ResourceNotFoundException("customer is not found"));
        Bill response = new Bill();
        List<Tax> taxes = taxDao.findByUser(user);

        List<Taxes> responseTax = new ArrayList<Taxes>();
        taxes.stream().forEach(t -> {
            EnumTax selectedTax = EnumTax.ENTERTAINMENT;
            if (StringUtils.equalsIgnoreCase(t.getTaxCode().toString(), EnumTax.FOODANDBEVERAGE.getTaxCode())) {
                selectedTax = EnumTax.FOODANDBEVERAGE;
            } else if (StringUtils.equalsIgnoreCase(t.getTaxCode().toString(), EnumTax.TOBACCO.getTaxCode())) {
                selectedTax = EnumTax.TOBACCO;
            }
            Taxes obj = new Taxes();
            obj.setName(t.getName());
            obj.setTaxCode(t.getTaxCode().toString());
            obj.setType(selectedTax.getType());
            obj.setRefundable(selectedTax.getRefundable());
            final long price = t.getPrice();
            obj.setPrice(price);
            final double tax = calculateTax(t.getTaxCode().toString(), t.getPrice());
            obj.setTax(tax);
            final double amount = (price + tax);
            obj.setAmount(amount);
            responseTax.add(obj);
        });

        response.setTaxes(responseTax);
        final long subtotalPrice = responseTax.stream().mapToLong(a -> a.getPrice()).sum();
        final double subtotalTax = responseTax.stream().mapToDouble(a -> a.getTax()).sum();
        final double grandTotal = responseTax.stream().mapToDouble(a -> a.getAmount()).sum();
        response.setSubtotalPrice(subtotalPrice);
        response.setSubtotalTax(subtotalTax);
        response.setGrandTotal(grandTotal);
        return response;
    }

    private double calculateTax(String taxCode, long price) {
        double tax = new Double("0");
        if (StringUtils.equals(taxCode, EnumTax.FOODANDBEVERAGE.getTaxCode())) {
            tax = 0.1 * price;
        } else if (StringUtils.equals(taxCode, EnumTax.TOBACCO.getTaxCode())) {
            tax = 10 + (0.02 * price);
        } else if (StringUtils.equals(taxCode, EnumTax.ENTERTAINMENT.getTaxCode())) {
            if (price < 100) {
                tax = 0;
            } else {
                tax = 0.01 * (price - 100);
            }
        }
        return tax;
    }
}
