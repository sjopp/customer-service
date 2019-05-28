package com.jopp.customerservice.controller;

import com.jopp.customerservice.exception.CustomerNotFoundException;
import com.jopp.customerservice.io.response.CustomerResponseWrapper;
import com.jopp.customerservice.model.Info;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({CustomerNotFoundException.class})
    public final ResponseEntity<CustomerResponseWrapper> handleException(CustomerNotFoundException e) {

        Info info = new Info();
        info.setMessage(e.getMessage());
        info.setStatus(404);

        CustomerResponseWrapper wrapper = new CustomerResponseWrapper();
        wrapper.setInfo(info);

        return new ResponseEntity<>(wrapper, NOT_FOUND);
    }
}