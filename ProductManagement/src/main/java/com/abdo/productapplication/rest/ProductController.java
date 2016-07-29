package com.abdo.productapplication.rest;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abdo.productapplication.domain.Product;
import com.abdo.productapplication.service.ProductService;

@RestController
public class ProductController {

	private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

	
    @Autowired
    private ProductService productService;

    
    @RequestMapping(method=RequestMethod.GET, value="/products/")
    public List<Product> listAllProducts() {
        
    	LOG.info("List All Products started .... ");
    	List<Product> products = productService.getAllProducts();
    	LOG.info("Products size" + products.size());
    	
    	return products;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/products/{productId}/")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long id) {
        
    	LOG.info("get product .... ");
    	Product product = productService.findById(id);
    	
    	if (product == null) {
    		LOG.info("No Product with ID : " + id);
    		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    	}
    	
    	return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/products/name/{productName}/")
    public ResponseEntity<Product> getProductByName(@PathVariable("productName") String name) {
        
    	LOG.debug("get product .... ");
    	Product product = productService.findByName(name);
    	
    	if (product == null) {
    		LOG.info("No Product with Name : " + name);
    		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    	}
    	
    	return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/products/")
    public void createProduct(@Valid @RequestBody Product product) {
        
    	LOG.debug("create product .... ");
    	productService.createProduct(product);
    	
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/products/{productId}/")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") long id, @RequestBody Product product) {
        
    	LOG.debug("update product product .... ");
    	
    	Product savedProduct = productService.findById(id);
    	if (savedProduct == null) {
    		LOG.info("No Product with id : " + id);
    		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
    	}
    	
    	savedProduct.setDescription(product.getDescription());
    	savedProduct.setName(product.getName());
    	
    	productService.updateProduct(savedProduct);
    	return new ResponseEntity<Product>(savedProduct, HttpStatus.OK);
    	
    }

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
    
    
    
    
}