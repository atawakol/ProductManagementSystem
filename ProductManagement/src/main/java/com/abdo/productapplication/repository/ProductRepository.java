package com.abdo.productapplication.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.abdo.productapplication.domain.Product;


public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findByName(String name);
	
	List<Product> findByDescriptionLike(String desc);
	
}
