package com.sia.ecommerce.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sia.ecommerce.entities.Product;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {

	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

	Page<Product> findByNameContaining(@Param("name") String name, Pageable page);
}
