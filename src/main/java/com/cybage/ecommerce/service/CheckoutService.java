package com.cybage.ecommerce.service;

import com.cybage.ecommerce.dto.Purchase;
import com.cybage.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
