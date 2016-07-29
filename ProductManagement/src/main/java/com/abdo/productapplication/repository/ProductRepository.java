package com.abdo.productapplication.repository;

import org.springframework.data.repository.CrudRepository;
import com.abdo.productapplication.domain.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findByName(String name);
	
}
