package com.jopp.customerservice.service;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.exception.CustomerNotFoundException;
import com.jopp.customerservice.io.request.CustomerRequest;
import com.jopp.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.StreamSupport.stream;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    public Customer findCustomer(String username) throws CustomerNotFoundException {
        log.debug("Finding customer username: {}", username);
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException("Customer : " + username + " has not been found");
        }
    }

    public Long addCustomerToRepository(CustomerRequest request) {
        log.debug("Saving customer to database");
        customerRepository.save(request.getCustomer());

        return request.getCustomer().getId();
    }
}
