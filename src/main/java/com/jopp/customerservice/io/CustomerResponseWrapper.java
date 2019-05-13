package com.jopp.customerservice.io;

import com.jopp.customerservice.model.Info;
import lombok.Data;

@Data
public class CustomerResponseWrapper {

    private CustomerResponse customerResponse;
    private Info info;
}
