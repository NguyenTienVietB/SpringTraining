package org.example;


import java.util.List;

import org.example.dao.CustomerDAO;
import org.example.entities.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

        customerDAO.save(new Customer("Rooney", "Manchester"));
        customerDAO.save(new Customer("Gerrard", "Liverpool"));
        //customerDAO.test(new Customer("Terry", "Chelsea"));

        List<Customer> listCustomer = customerDAO.findAll();
        for (Customer customer : listCustomer) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getAddress());
        }

        context.close();
    }
}