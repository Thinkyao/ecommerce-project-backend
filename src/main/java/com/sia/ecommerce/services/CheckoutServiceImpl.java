package com.sia.ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.sia.ecommerce.dto.PaymentInfo;
import com.sia.ecommerce.dto.Purchase;
import com.sia.ecommerce.dto.PurchaseResponse;
import com.sia.ecommerce.entities.Customer;
import com.sia.ecommerce.entities.Order;
import com.sia.ecommerce.entities.OrderItem;
import com.sia.ecommerce.repos.CustomerRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@Service
@PropertySource(value = { "classpath:application.yaml" })
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;

	public CheckoutServiceImpl(CustomerRepository customerRepository,
			@Value("secret:sk_test_51NI5WzCkG81qxo3fTfDBV33ncmZQ4HAPllz32n33FtR7wayXOS2DmnOWL56EzHMSNDjPcMDEEDk08OjQJpMkHvcD00JztccmEv") String secretKey) {

		this.customerRepository = customerRepository;

		// initialize Stripe API with secret key
		Stripe.apiKey = secretKey;
	}

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		// retrieve the order info from dto
		Order order = purchase.getOrder();

		// generate tracking number
		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		// populate order with orderItems
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		// populate order with billingAddress and shippingAddress
		order.setBillingAddress(purchase.getBillingAddress());
		order.setShippingAddress(purchase.getShippingAddress());

		// populate customer with order
		Customer customer = purchase.getCustomer();

		// check if this is an existing customer
		String theEmail = customer.getEmail();

		Customer customerFromDB = customerRepository.findByEmail(theEmail);

		if (customerFromDB != null) {
			// we found them ... let's assign them accordingly
			customer = customerFromDB;
		}

		customer.add(order);

		// save to the database
		customerRepository.save(customer);

		// return a response
		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {

		// generate a random UUID number (UUID version-4)
		// For details see: https://en.wikipedia.org/wiki/Universally_unique_identifier
		//
		return UUID.randomUUID().toString();
	}

	@Override
	public PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException {

		List<String> paymentMethodTypes = new ArrayList<>();
		paymentMethodTypes.add("card");

		Map<String, Object> params = new HashMap<>();
		params.put("amount", paymentInfo.getAmount());
		params.put("currency", paymentInfo.getCurrency());
		params.put("payment_method_types", paymentMethodTypes);

		return PaymentIntent.create(params);
	}
}
