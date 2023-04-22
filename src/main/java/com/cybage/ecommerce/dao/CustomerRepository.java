package com.cybage.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cybage.ecommerce.entity.Customer;

//@CrossOrigin
//not annotated with repositoryrestresource hence will not be exposed
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	//behind the scene  select * from customer where email=email;
	Customer  findByEmail(String email);
}
