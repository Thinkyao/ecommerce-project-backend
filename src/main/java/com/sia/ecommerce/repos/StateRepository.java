package com.sia.ecommerce.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sia.ecommerce.entities.State;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends CrudRepository<State, Integer> {

	List<State> findByCountryCode(@Param("code") String code);
}
