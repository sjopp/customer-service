package com.jopp.customerservice.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.internal.util.privilegedactions.GetMethodFromPropertyName;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class GeneralException extends Exception {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private HttpStatus status;

    GeneralException() {
        timestamp = LocalDateTime.now();
    }

    GeneralException(String message) {
        super(message);
        timestamp = LocalDateTime.now();
    }

    GeneralException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        timestamp = LocalDateTime.now();

    }
}

