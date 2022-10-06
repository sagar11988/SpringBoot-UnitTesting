package com.sds.unitTesting;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sds.unitTesting.controller.ProductController;
import com.sds.unitTesting.model.Product;
import com.sds.unitTesting.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	MockMvc mockmvc;
	
	
	@MockBean	
	ProductServiceImpl mockProductService;
	
	
	@Ignore
	public void Test_getallProduct() throws Exception {
		
		
		RequestBuilder  request= MockMvcRequestBuilders
				                  .get("/products")
				                  .accept(MediaType.APPLICATION_JSON);
		
		
		mockmvc.perform(request)
			   .andExpect(status().isOk())
			   .andExpect(content().json("{\"productId\":12345,\"name\":\"Laptop\",\"price\":25000.0,\"status\":true,\"quantity\":12}"))
			   .andReturn();
		
	}
	
	
	@Test
	public void Test_getProductInfo() throws Exception {
		
		
		when(mockProductService.findById(anyInt())).thenReturn(new Product(2, "Cycle", 140.0, true, 89));
		
		RequestBuilder  request= MockMvcRequestBuilders
				                  .get("/products/2")
				                  .accept(MediaType.APPLICATION_JSON);
		
		mockmvc.perform(request)
			   .andExpect(status().isOk())
			   .andExpect(content().json("{\"productId\":2,\"name\":\"Cycle\",\"price\":140.0,\"status\":true,\"quantity\":89,\"value\":0.0}"))
			   .andReturn();
		
	}
	
	
	@Test
	public void Test_getAllProductInfo() throws Exception {
		
		List<Product> mockproduct=new ArrayList<>();
		
		mockproduct.add(new Product(2, "Cycle", 140.0, true, 89));
 		
		when(mockProductService.findAll()).thenReturn(mockproduct);
		
		RequestBuilder  request= MockMvcRequestBuilders
				                  .get("/products")
				                  .accept(MediaType.APPLICATION_JSON);
		
		
		mockmvc.perform(request)
			   .andExpect(status().isOk())
			   .andExpect(content().json("[{\"productId\":2,\"name\":\"Cycle\",\"price\":140.0,\"status\":true,\"quantity\":89,\"value\":0.0}]"))
			   .andReturn();
			  
		
	}
	
	

	
	
	
	

}
