package com.sia.ecommerce.dto;

import java.util.Set;

import com.sia.ecommerce.entities.Address;
import com.sia.ecommerce.entities.Customer;
import com.sia.ecommerce.entities.Order;
import com.sia.ecommerce.entities.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
}
