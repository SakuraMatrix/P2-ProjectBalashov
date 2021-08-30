package com.github.ProjectBalashov;


import com.github.ProjectBalashov.Customer;
import com.github.ProjectBalashov.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
public class CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Flux<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public Mono<Customer> getCustomerById(@PathVariable int id) {
        return customerRepository.getCustomerById(id);
    }

    public Mono<Boolean> deposit(@PathVariable int id, @PathVariable double amt) {
        return customerRepository.deposit(id, amt);
    }

    public Mono<Boolean> withdraw(@PathVariable int id, @PathVariable double amt) {
        return customerRepository.withdraw(id, amt);
    }

    //@PostMapping("/create")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.createCustomer(customer);
    }



}