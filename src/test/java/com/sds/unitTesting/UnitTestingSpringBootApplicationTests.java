package com.sds.unitTesting;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UnitTestingSpringBootApplicationTests {
	
	
	
	
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws JSONException {
		
		String response = restTemplate.getForObject("/hello",String.class);
		
		JSONAssert.assertEquals("{name:sagar}", response, false);
		
		
	}

}
