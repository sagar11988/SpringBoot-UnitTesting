package com.sds.unitTesting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.sds.unitTesting.controller.HelloController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloController.class)
public class HelloControllerTest {
	
	@Autowired
	MockMvc mockmvc;	
	
	
	@Test
	public void Test_sayHello() throws Exception {
		
		
		RequestBuilder  request= MockMvcRequestBuilders
				                  .get("/hello")
				                  .accept(MediaType.APPLICATION_JSON);
		
		
		MvcResult result = mockmvc.perform(request).andReturn();
		
		
		
		assertEquals("{name:sagar}", result.getResponse().getContentAsString());
		
		
	}
	
	@Test
	public void Test_jsonPath() throws Exception {
		
		String josnResponse="[{\"productId\":1,\"name\":\"Motor\",\"price\":150.0,\"status\":false,\"quantity\":10,\"value\":1500.0},"
				          + " {\"productId\":2,\"name\":\"Cycle\",\"price\":140.0,\"status\":true,\"quantity\":89,\"value\":12460.0},"
				          + " {\"productId\":3,\"name\":\"Laptop\",\"price\":130.0,\"status\":false,\"quantity\":23,\"value\":2990.0},"
				          + " {\"productId\":4,\"name\":\"Desktop\",\"price\":120.0,\"status\":true,\"quantity\":34,\"value\":4080.0},"
				          + " {\"productId\":5,\"name\":\"Car\",\"price\":500.0,\"status\":true,\"quantity\":12,\"value\":6000.0}]";
		
		
		DocumentContext response = JsonPath.parse(josnResponse);
		
		int length = response.read("$.length()");
		
		System.out.println("length"+length);
		
		System.out.println("names "+response.read("$..name").toString());
		
		
		System.out.println("$.[1] "+response.read("$.[1]").toString());
		
		System.out.println("$.[?@.name=='Cycle'] "+response.read("$.[?(@.name=='Cycle')]").toString());
		
		System.out.println("$.[0:2] "+response.read("$.[0:2]").toString());
		
		assertThat(length).isEqualTo(5);
		
	//	length5
	//	names ["Motor","Cycle","Laptop","Desktop","Car"]
	//	$.[1] {productId=2, name=Cycle, price=140.0, status=true, quantity=89, value=12460.0}
	//	$.[?@.name=='Cycle'] [{"productId":2,"name":"Cycle","price":140.0,"status":true,"quantity":89,"value":12460.0}]
	//	$.[0:2] [{"productId":1,"name":"Motor","price":150.0,"status":false,"quantity":10,"value":1500.0},{"productId":2,"name":"Cycle","price":140.0,"status":true,"quantity":89,"value":12460.0}]

	
		
	}
	
	
	
	

}
