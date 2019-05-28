package com.jopp.customerservice.io.response;

import com.jopp.customerservice.model.Info;
import lombok.Data;

@Data
public class CustomerListResponseWrapper {

    private CustomerListResponse data;
    private Info info;
}
