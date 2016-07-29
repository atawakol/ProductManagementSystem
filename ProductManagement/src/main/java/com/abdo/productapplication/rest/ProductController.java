package com.abdo.productapplication.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdo.productapplication.domain.Product;
import com.abdo.productapplication.service.ProductService;

@RestController
public class ProductController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	
    @Autowired
    private ProductService productService;

    @RequestMapping(method=RequestMethod.GET, value="/product/list/")
    public List<Product> listAllProducts() {
        
    	LOG.info("List All Products started .... ");
    	List<Product> products = productService.getAllProducts();
    	LOG.info("Products size" + products.size());
    	
    	return products;
    }

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
    
    
    
    
}