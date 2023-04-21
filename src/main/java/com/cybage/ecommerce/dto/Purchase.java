package com.cybage.ecommerce.dto;

import java.util.Set;

import com.cybage.ecommerce.entity.Address;
import com.cybage.ecommerce.entity.Customer;
import com.cybage.ecommerce.entity.Order;
import com.cybage.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {
	
	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;

}
