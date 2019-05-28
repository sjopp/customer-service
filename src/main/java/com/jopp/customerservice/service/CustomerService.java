package com.jopp.customerservice.service;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.io.request.CustomerRequest;
import com.jopp.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ArrayList<Customer> retrieveAllCustomers() {
        log.debug("Finding all customers");
        Iterable<Customer> customers = customerRepository.findAll();
        log.debug("Customers: {}", customers.toString());
        Stream<Customer> stream = stream(customers.spliterator(), false);
        List<Customer> customerList = stream.collect(Collectors.toList());
        return new ArrayList<>(customerList);
    }

    public Customer findCustomer(String username) {
        log.debug("Finding customer username: {}", username);
        try {
            return customerRepository.findByUsername(username);
        } catch (Exception e) {
//            throw new CustomerNotFoundException();
        }
        return null;
    }

    public Long addCustomerToRepository(CustomerRequest request) {
        log.debug("Saving customer to database");
        customerRepository.save(request.getCustomer());

        return request.getCustomer().getId();
    }
}
