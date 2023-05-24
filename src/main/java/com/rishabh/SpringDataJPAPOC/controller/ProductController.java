package com.rishabh.SpringDataJPAPOC.controller;

import com.rishabh.SpringDataJPAPOC.model.product.Product;
import com.rishabh.SpringDataJPAPOC.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public void createProducts(@RequestBody List<Product> productList) {

        productRepository.saveAll(productList);
        productRepository.s
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }
}
