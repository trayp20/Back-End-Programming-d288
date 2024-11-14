package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public  class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    @Autowired
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() <= 6) {


            Division division = divisionRepository.findById(2L).get();
            // Create sample customers
                        Customer customer1 = new Customer("John", "Doe", "123 Main St", "12345", "1234567890", new Date(), new Date(), division);
                        Customer customer2 = new Customer("Jane", "Doe", "456 Elm St", "23456", "0987654321", new Date(), new Date(), division);
                        Customer customer3 = new Customer("Jim", "Beam", "789 Oak St", "34567", "1122334455", new Date(), new Date(), division);
                        Customer customer4 = new Customer("Jack", "Daniels", "321 Pine St", "45678", "2233445566", new Date(), new Date(), division);
                        Customer customer5 = new Customer("Johnny", "Walker", "654 Maple St", "56789", "3344556677", new Date(), new Date(), division);

           //  Save customers to the repository
                       customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5));
        }
    }
}