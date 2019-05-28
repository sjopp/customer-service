package com.jopp.customerservice.config;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CustomerRepositoryConfig {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository){
        return args -> {
            log.info("Preloading " + repository.save(new Customer("Tim Bob", "1966/09/19", "tbob", "password")));
            log.info("Preloading " + repository.save(new Customer("Bill Will", "1956/07/11", "bWill", "password")));
            log.info("Preloading " + repository.save(new Customer("Sam Jopp", "1995/09/15", "sjopp", "password")));
        };
    }
}
