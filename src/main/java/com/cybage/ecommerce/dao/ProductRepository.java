package com.cybage.ecommerce.dao;

import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cybage.ecommerce.entity.Product;

//@CrossOrigin("http://localhost:4200") - for specific ip can add multiple for any ip use wildCard @crosOrigin only
//@CrossOrigin
public interface ProductRepository  extends JpaRepository<Product, Long>{
	
	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
	Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);

}
