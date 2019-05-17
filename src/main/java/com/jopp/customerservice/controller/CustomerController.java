package com.jopp.customerservice.controller;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.io.CustomerRequest;
import com.jopp.customerservice.io.CustomerResponse;
import com.jopp.customerservice.io.CustomerResponseWrapper;
import com.jopp.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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

        addCustomersToResponse(wrapper, customers);

        log.info("Leaving the getCustomer controller");
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @PostMapping("/customer/add")
    public ResponseEntity<Long> addCustomer(@RequestBody CustomerRequest request) {

        log.info("Entering the addCustomer controller");
        Long id = customerService.addCustomerToRepository(request);

        log.info("Leaving the addCustomer controller");
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    private void addCustomersToResponse(CustomerResponseWrapper wrapper, ArrayList<Customer> customers) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomers(customers);
        wrapper.setResponse(customerResponse);
    }
}
