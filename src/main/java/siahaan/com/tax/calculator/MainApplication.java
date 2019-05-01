/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siahaan.com.tax.calculator;

import javax.inject.Inject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import siahaan.com.tax.calculator.dao.UserDao;
import siahaan.com.tax.calculator.entity.Customer;

/**
 *
 * @author ovo
 */

@EnableAutoConfiguration
@ComponentScan({"siahaan.com.tax.calculator"})
//@SpringBootApplication
public class MainApplication implements CommandLineRunner{

    @Inject
    private UserDao userDao;
    
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        initiate();
    }
    private void initiate() {
        // open this code if need them for initial
//        Customer user1 = new Customer("user 1", "081212345");
//        userDao.save(user1);
//        
//        Customer user2 = new Customer("user 2", "085212345");
//        userDao.save(user2);
//        
//        Customer user3 = new Customer("user 3", "081912345");
//        userDao.save(user3);
    }
}

