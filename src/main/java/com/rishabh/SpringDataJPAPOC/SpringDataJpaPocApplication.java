package com.rishabh.SpringDataJPAPOC;

import com.rishabh.SpringDataJPAPOC.model.customer.Customer;
import com.rishabh.SpringDataJPAPOC.model.product.Product;
import com.rishabh.SpringDataJPAPOC.repository.customer.CustomerRepository;
import com.rishabh.SpringDataJPAPOC.repository.product.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.saveAll(List.of(
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
        ));

       /* productRepository.saveAll(List.of(
                Product.builder()
                        .productName("Iphone12")
                        .code("123")
                        .id(1)
                        .build()
        ));*/
    }
}
