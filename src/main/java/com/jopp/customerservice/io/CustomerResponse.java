package com.jopp.customerservice.io;

import com.jopp.customerservice.entity.Customer;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CustomerResponse {

    private ArrayList<Customer> customers;
}
