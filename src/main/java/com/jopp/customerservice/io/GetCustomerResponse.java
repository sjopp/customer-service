package com.jopp.customerservice.io;

import com.jopp.customerservice.model.Customer;
import com.jopp.customerservice.model.Info;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetCustomerResponse {

    private Customer customer;
    private Info info;
}
