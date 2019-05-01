/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.controller;

import java.math.BigInteger;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import siahaan.com.tax.calculator.model.Bill;
import siahaan.com.tax.calculator.model.TaxRequest;
import siahaan.com.tax.calculator.model.TaxResponse;
import siahaan.com.tax.calculator.service.TaxService;

/**
 *
 * @author roulis
 */
@Named("TaxController")
@RestController
@RequestMapping(value = "/tax")
public class TaxController {

    @Inject
    private TaxService taxService;

    @RequestMapping(method = RequestMethod.POST, value = "create")
    public ResponseEntity createTax(@Valid @RequestBody TaxRequest request, @RequestHeader("phone") String phone) throws Exception {
        if (!StringUtils.isEmpty(phone)) {
            request.setPhone(phone);
        }
        TaxResponse response = taxService.createTaxObject(request);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bill")
    public ResponseEntity getBill(@RequestParam(name = "phone", required = true) String phone) {
        Bill response = taxService.checkMyBill(phone);
        return ResponseEntity.ok(response);
    }
}
