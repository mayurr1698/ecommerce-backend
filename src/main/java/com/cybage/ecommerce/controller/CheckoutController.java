package com.cybage.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.ecommerce.dto.Purchase;
import com.cybage.ecommerce.dto.PurchaseResponse;
import com.cybage.ecommerce.service.CheckoutService;

//@CrossOrigin
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private CheckoutService checkoutService;

	@Autowired
	public CheckoutController(CheckoutService checkoutService) {
		super();
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
		return purchaseResponse;
		
	}

}
