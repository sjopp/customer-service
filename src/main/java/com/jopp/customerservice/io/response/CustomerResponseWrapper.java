package com.jopp.customerservice.io.response;

import com.jopp.customerservice.model.Info;
import lombok.Data;

@Data
public class CustomerResponseWrapper {

    private CustomerResponse data;
    private Info info;
}
