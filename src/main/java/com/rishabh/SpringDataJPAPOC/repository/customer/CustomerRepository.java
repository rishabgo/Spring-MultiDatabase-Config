package com.rishabh.SpringDataJPAPOC.repository.customer;

import com.rishabh.SpringDataJPAPOC.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
