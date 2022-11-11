package com.rishabh.SpringDataJPAPOC;

import com.rishabh.SpringDataJPAPOC.model.customer.Customer;
import com.rishabh.SpringDataJPAPOC.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaPocApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaPocApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

       /* customerRepository.saveAll(List.of(
                Customer.builder()
                        .name("rishabh goyal")
                        .email("rgoyal@test")
                        .build(),
                Customer.builder()
                        .name("XYZ")
                        .email("xyz@test")
                        .build(),
				Customer.builder()
						.name("ABC")
						.email("abc@test")
						.build()
        ));*/
    }
}
