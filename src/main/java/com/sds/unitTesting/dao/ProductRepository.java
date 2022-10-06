package com.sds.unitTesting.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sds.unitTesting.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
