package com.jopp.customerservice.controller;

import com.jopp.customerservice.io.CustomerRequest;
import com.jopp.customerservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AddCustomerController {

    private final CustomerService customerService;

    @Autowired
    public AddCustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer/add")
    public ResponseEntity<Long> addCustomer(@RequestBody CustomerRequest request) {

        log.info("Entering the addCustomer controller");
        Long id = customerService.addCustomerToRepository(request);

        log.info("Leaving the addCustomer controller");
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
