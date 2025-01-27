package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint3PropertiesLoad {

	@Autowired
	private ExampleProperties props;
	
	@RequestMapping("/greet")
	public String greet(@RequestParam String details) {
		return props.getMessage() + ":" + details;
	}
}
