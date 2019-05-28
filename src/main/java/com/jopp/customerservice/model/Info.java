package com.jopp.customerservice.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Info {

    private int status;
    private String message;
}
