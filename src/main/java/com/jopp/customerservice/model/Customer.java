package com.jopp.customerservice.model;

import lombok.Getter;
import lombok.Setter;

import static com.jopp.customerservice.model.Membership.NONE;

@Getter
@Setter
public class Customer {

    private String name;
    private int age;
    private Membership membership;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.membership = NONE;
    }
}
