package com.sia.ecommerce.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sia.ecommerce.entities.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {

	Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
}
