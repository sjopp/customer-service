package com.jopp.customerservice;

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
    public ResponseEntity<JSONObject> getCustomers() {

        log.info("Entering the getCustomer controller");
        Customer customer = new Customer("Sam Jopp", 23);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", customer.getName());
        return new ResponseEntity(jsonObject, HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity addCustomer(
//            @RequestBody Customer customer) {
//
//    }
}
