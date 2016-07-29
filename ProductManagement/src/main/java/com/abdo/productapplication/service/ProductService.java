package com.abdo.productapplication.service;

import com.abdo.productapplication.domain.Product;
import java.util.List;

public interface ProductService {

	void createProduct(Product prod);
	void updateProduct(Product prod);
	void deleteProduct(long prodId);
	
	List<Product> getAllProducts();
	
	Product findById(long prodId);
	Product findById(String prodName);
	
	
}
