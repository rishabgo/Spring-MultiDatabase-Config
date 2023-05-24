package com.rishabh.SpringDataJPAPOC.controller;

import com.rishabh.SpringDataJPAPOC.model.customer.Customer;
import com.rishabh.SpringDataJPAPOC.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public void saveCustomers(@RequestBody final List<Customer> customerList) {
        customerRepository.saveAll(customerList);
        ConcurrentHashMap map = new ConcurrentHashMap();

    }
}
