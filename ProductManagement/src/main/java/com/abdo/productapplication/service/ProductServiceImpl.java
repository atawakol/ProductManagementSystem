package com.abdo.productapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abdo.productapplication.domain.Product;
import com.abdo.productapplication.repository.ProductRepository;

@Service
@Transactional()
public class ProductServiceImpl implements ProductService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void createProduct(Product prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(long prodId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> getAllProducts() {
		
		LOG.info("In Service method --> getAllProducts");
		
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(p -> products.add(p));
		
		return products;
	}

	@Override
	public Product findById(long prodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findById(String prodName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
}
