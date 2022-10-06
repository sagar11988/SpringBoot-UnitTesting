package com.sds.unitTesting.service;

import java.util.List;

import com.sds.unitTesting.model.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public void save(Product product);
	
	public Product findById(int productId);
	
	public void deleteByID(int productId);

}
