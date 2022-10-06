package com.sds.unitTesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/hello")
	public String SayHello() {
		
		
		return "{name:sagar}";
	}
	
	@RequestMapping(value = "/{q:.+}", method = RequestMethod.GET) 
    public String display(@PathVariable("q") String q) {
 

       return q;

}

}
