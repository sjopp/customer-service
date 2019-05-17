package com.jopp.customerservice.config;

import com.jopp.customerservice.entity.Customer;
import com.jopp.customerservice.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class CustomerRepositoryConfig {

    @Bean
    CommandLineRunner initDatabase(CustomerRepo repository){
        return args -> {
            log.info("Preloading " + repository.save(new Customer("Tim Bob", "1966/09/19")));
            log.info("Preloading " + repository.save(new Customer("Bill Will", "1956/07/11")));
        };
    }
}
