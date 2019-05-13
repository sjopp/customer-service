package com.jopp.customerservice.controller;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.io.CustomerResponse;
import com.jopp.customerservice.io.CustomerResponseWrapper;
import com.jopp.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Slf4j
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<CustomerResponseWrapper> getCustomers() {

        log.info("Entering the getCustomer controller");
        CustomerResponseWrapper wrapper = new CustomerResponseWrapper();
        ArrayList<Customer> customers = customerService.retrieveAllCustomers();

        Customer customer = new Customer();
        customer.setFullName("Sam Jopp");
        customer.setDateOfBirth("1995/09/15");
        customer.setId(1L);
        customers.add(customer);

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomers(customers);
        wrapper.setCustomerResponse(customerResponse);

        log.info("Leaving the getCustomer controller");
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }
}
