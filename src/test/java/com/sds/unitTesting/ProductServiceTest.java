package com.sds.unitTesting;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.sds.unitTesting.dao.ProductRepository;
import com.sds.unitTesting.model.Product;
import com.sds.unitTesting.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl ProductService;
	
	@Mock
	ProductRepository repository;
	
	
	@Test
	public void findAllTest() {
		

		List<Product> mockproduct=new ArrayList<>();		
		mockproduct.add(new Product(2, "Cycle", 140.0, true, 10));
		when(repository.findAll()).thenReturn(mockproduct);
		
		List<Product> products = ProductService.findAll();
		
		assertEquals(new BigDecimal(1440), new BigDecimal(products.get(0).getValue()));
		
	}

}
