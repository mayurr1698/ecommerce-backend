package com.cybage.ecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.ecommerce.dao.CustomerRepository;
import com.cybage.ecommerce.dto.Purchase;
import com.cybage.ecommerce.dto.PurchaseResponse;
import com.cybage.ecommerce.entity.Customer;
import com.cybage.ecommerce.entity.Order;
import com.cybage.ecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		//retive order info from dto
		Order order = purchase.getOrder();
		
		//generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
		
		//populate order with order items
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));
		
		//populate order with billing and shipping address
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());
		
		//populate customer with order
		Customer customer = purchase.getCustomer();
		customer.add(order);
		
		//save to database
		customerRepository.save(customer);
		//return a response
		
		return new PurchaseResponse(orderTrackingNumber);
	}


	private String generateOrderTrackingNumber() {
		// generate random uuid
		return UUID.randomUUID().toString();
	}

}
