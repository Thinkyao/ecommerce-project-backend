package com.sia.ecommerce.services;

import com.sia.ecommerce.dto.Purchase;
import com.sia.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
