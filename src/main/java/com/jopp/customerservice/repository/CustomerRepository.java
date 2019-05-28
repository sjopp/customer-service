package com.jopp.customerservice.repository;

import com.jopp.customerservice.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByUsername(String username);
}
