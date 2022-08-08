package com.customer.microcustomer.controller;

import com.customer.microcustomer.entities.Customer;
import com.customer.microcustomer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        return ResponseEntity.ok(customerRepository.findById(id).get());
    }

    @PutMapping("")
    public ResponseEntity<Customer> save(@RequestBody Customer input) {
        return ResponseEntity.ok(customerRepository.save(input));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        customerRepository.deleteById(id);
    }
}
