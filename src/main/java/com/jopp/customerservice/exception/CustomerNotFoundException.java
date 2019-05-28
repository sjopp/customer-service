package com.jopp.customerservice.exception;

import java.time.LocalDateTime;

public class CustomerNotFoundException extends Exception {

    private LocalDateTime timestamp;

    public CustomerNotFoundException() {
        super();
        timestamp = LocalDateTime.now();
    }
    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
        timestamp = LocalDateTime.now();
    }
}
