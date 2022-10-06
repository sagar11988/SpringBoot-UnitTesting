package com.sds.unitTesting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sds.unitTesting.model.Product;
import com.sds.unitTesting.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productservice;
	
	
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		
		List<Product> products = productservice.findAll();
		
		return products;
	}	
	
	@GetMapping("/products/{productId}")
	public Product getProductInfo(@PathVariable(name = "productId") int productId) {
		
		return  productservice.findById(productId);
		
	}
	
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		
		product.setProductId(0);
		
	    productservice.save(product);
	    
	    return product;
		
	}
	

	@PutMapping("/products")
	public Product modifyProduct(@RequestBody Product product) {
		
	//	product.setProductId(0);
		
	    productservice.save(product);
	    
	    return product;
		
	}
	
	
	@DeleteMapping("/products/{productId}")
	public String removeProduct(@PathVariable(name = "productId") int productId) {
		
	//	product.setProductId(0);
		
		Product product = productservice.findById(productId);
		
		Optional<Product> isNull=Optional.of(product);
		
		if(isNull.isEmpty()) {
			
			System.out.println("Product not found");
		}
		
	    productservice.deleteByID(productId);
	    
	 return  "Deleted the product with id-"+productId;
		
	}
	
	
	

}
