package com.jopp.customerservice.io;

import com.jopp.customerservice.model.Info;
import lombok.Data;

@Data
public class CustomerResponseWrapper {

    private CustomerResponse response;
    private Info info;
}
