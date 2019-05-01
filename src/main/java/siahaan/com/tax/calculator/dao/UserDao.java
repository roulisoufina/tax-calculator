/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator.dao;

import java.math.BigInteger;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siahaan.com.tax.calculator.entity.Customer;

/**
 *
 * @author roulis
 */
@Repository
@Transactional
public interface UserDao extends JpaRepository<Customer, BigInteger> {

    Customer findByPhone(String phone);
}
