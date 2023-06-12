package com.sia.ecommerce.services;

import com.sia.ecommerce.dto.PaymentInfo;
import com.sia.ecommerce.dto.Purchase;
import com.sia.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);

	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}
