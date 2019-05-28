package com.jopp.customerservice.io.response;

import com.jopp.customerservice.entity.Customer;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CustomerResponse {

    private Customer customer;
    private boolean exists;
}
