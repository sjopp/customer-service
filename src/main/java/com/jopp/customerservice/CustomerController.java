package com.jopp.customerservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CustomerController {

    @GetMapping("/customers")
    public ResponseEntity getCustomers() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity addCustomer(
//            @RequestBody Customer customer) {
//
//    }
}
