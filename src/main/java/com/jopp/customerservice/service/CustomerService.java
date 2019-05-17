package com.jopp.customerservice.service;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.StreamSupport.*;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public ArrayList<Customer> retrieveAllCustomers() {
        log.debug("Finding all customers");
        Iterable<Customer> customers = customerRepo.findAll();
        log.debug("Customers: {}", customers.toString());
        Stream<Customer> stream = stream(customers.spliterator(), false);
        List<Customer> customerList = stream.collect(Collectors.toList());
        return new ArrayList<>(customerList);
    }
}
