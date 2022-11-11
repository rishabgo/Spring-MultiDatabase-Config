package com.rishabh.SpringDataJPAPOC.repository.product;

import com.rishabh.SpringDataJPAPOC.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
