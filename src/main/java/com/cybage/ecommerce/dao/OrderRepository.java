package com.cybage.ecommerce.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cybage.ecommerce.entity.Order;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	/*get orders by email address
	behind the scene : select * from orders left outer join customer on orders.customer_id=customer.id
	where customer.email=:email */
	Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);

}
