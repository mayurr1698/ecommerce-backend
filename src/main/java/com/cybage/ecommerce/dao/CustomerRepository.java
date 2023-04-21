package com.cybage.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cybage.ecommerce.entity.Customer;

@CrossOrigin
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
