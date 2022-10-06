package com.sds.unitTesting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sds.unitTesting.dao.ProductRepository;
import com.sds.unitTesting.model.Product;

//@Service
@Component
public class ProductServiceImpl implements ProductService{
	

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> findAll() {
		
		List<Product> products = repository.findAll();
		
		for (Product product : products) {
			
			
			product.setValue(product.getPrice()*product.getQuantity());
		}
		
	 return products;	
	}

	@Override
	public void save(Product product) {
		
		repository.save(product);
	}

	@Override
	public Product findById(int productId) {
		
		return repository.findById(productId).get();
	}

	@Override
	public void deleteByID(int productId) {
		
		Optional<Product> product = repository.findById(productId);
		
		if(product.isPresent()) {
			
			repository.deleteById(productId);
			
		}else {
			
			System.out.println("No Product found");
		}
		
		
		
	}

}
