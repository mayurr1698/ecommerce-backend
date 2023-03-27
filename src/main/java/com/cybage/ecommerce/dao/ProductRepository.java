package com.cybage.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.ecommerce.entity.Product;


public interface ProductRepository  extends JpaRepository<Product, Long>{

}
