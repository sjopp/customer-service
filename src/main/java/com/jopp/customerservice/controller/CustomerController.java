package com.jopp.customerservice.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jopp.customerservice.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CustomerController {

    @GetMapping("/customer")
    public ResponseEntity<Customer> getCustomers() {

        log.info("Entering the getCustomer controller");
        Customer customer = new Customer("Sam Jopp", 23);
        log.info("Leaving the getCustomer controller");
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
