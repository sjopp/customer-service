package com.jopp.customerservice.controller;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.exception.CustomerNotFoundException;
import com.jopp.customerservice.io.response.CustomerListResponse;
import com.jopp.customerservice.io.response.CustomerListResponseWrapper;
import com.jopp.customerservice.io.response.CustomerResponse;
import com.jopp.customerservice.io.response.CustomerResponseWrapper;
import com.jopp.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class FetchCustomersController {

    private final CustomerService customerService;

    @Autowired
    public FetchCustomersController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<CustomerListResponseWrapper> getCustomers() {

        log.info("Entering the getCustomers controller");
        CustomerListResponseWrapper wrapper = new CustomerListResponseWrapper();

        ArrayList<Customer> customers = customerService.retrieveAllCustomers();

        addCustomersToResponse(wrapper, customers);

        log.info("Leaving the getCustomers controller");
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @GetMapping("/customer/{username}")
    public ResponseEntity<CustomerResponseWrapper> getCustomer(
            @PathVariable("username") String username) throws CustomerNotFoundException {

        log.info("Entering the getCustomer controller");
        log.debug("Getting customer " + username);

        Customer customer = customerService.findCustomer(username);

        CustomerResponseWrapper wrapper = new CustomerResponseWrapper();
        addCustomerToResponse(wrapper, customer);

        log.info("Leaving the getCustomer controller");
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    private void addCustomersToResponse(CustomerListResponseWrapper wrapper, ArrayList<Customer> customers) {
        CustomerListResponse customerListResponse = new CustomerListResponse();
        customerListResponse.setCustomers(customers);
        wrapper.setData(customerListResponse);
    }

    private void addCustomerToResponse(CustomerResponseWrapper wrapper, Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomer(customer);
        customerResponse.setExists(true);
        wrapper.setData(customerResponse);
    }
}
