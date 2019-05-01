/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.dao;

import java.math.BigInteger;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siahaan.com.tax.calculator.entity.Customer;
import siahaan.com.tax.calculator.entity.Tax;

/**
 *
 * @author roulis
 */
@Repository
@Transactional
public interface TaxDao extends JpaRepository<Tax, BigInteger> {

    List<Tax> findByUser(Customer user);
}
