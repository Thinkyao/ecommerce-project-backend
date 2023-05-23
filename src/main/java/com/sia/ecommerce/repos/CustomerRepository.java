package com.sia.ecommerce.repos;

import org.springframework.data.repository.CrudRepository;

import com.sia.ecommerce.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
